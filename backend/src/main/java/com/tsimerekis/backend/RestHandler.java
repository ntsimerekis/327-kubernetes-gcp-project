package com.tsimerekis.backend;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.HttpMethod;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@RestController
public class RestHandler {

    private final String bucketName;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private final BirdRepository birdRepository;

    private Storage storage;


    @Autowired
    RestHandler(BirdRepository birdRepository, Storage storage, @Value("${BUCKET_ID}") String bucketName) {
        this.storage = storage;
        this.bucketName = bucketName;
        this.birdRepository = birdRepository;
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute BirdEntry entry) {
        String uuid = UUID.randomUUID().toString();
        entry.setUuid(uuid);
        logger.info(entry.getUuid() + " " + entry.getBirdCode() + " " + entry.getPlusCode());
        //upload to spanner
        this.birdRepository.getSpannerTemplate().insert(entry);
        //upload photo to storage
        try {
            this.storage.create(
                    BlobInfo.newBuilder(bucketName, entry.getUuid()+".jpeg").build(),
                    entry.getFile().getBytes()
            );
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
        return entry.getUuid();
    }

    @GetMapping("/get")
    public String get(@RequestParam String uuid) {
        Map<String, String> extensionHeaders = new HashMap<>();
        extensionHeaders.put("Content-Type", "application/octet-stream");
        BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of("tsimeekis-my_bucket", uuid + ".jpeg")).build();
        URL url =
                storage.signUrl(
                        blobInfo,
                        15,
                        TimeUnit.MINUTES,
                        Storage.SignUrlOption.httpMethod(HttpMethod.PUT),
                        Storage.SignUrlOption.withExtHeaders(extensionHeaders),
                        Storage.SignUrlOption.withV4Signature());
        return url.getPath();
    }

    @GetMapping("/api/ready")
    public String ready() {
        return "ok";
    }

    @GetMapping("/api/healthy")
    public String healthy() {
        return "ok";
    }
}
