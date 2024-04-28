package com.tsimerekis.backend;

import com.google.cloud.spring.data.spanner.core.mapping.Column;
import com.google.cloud.spring.data.spanner.core.mapping.Interleaved;
import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import com.google.cloud.spring.data.spanner.core.mapping.NotMapped;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import org.springframework.web.multipart.MultipartFile;

@Table(name = "entries")
public class BirdEntry {

    @PrimaryKey
    private String uuid;

    private String birdCode;
    private String plusCode;
    private String url;

    @NotMapped
    private MultipartFile file;

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setBirdCode(String birdCode) {
        this.birdCode = birdCode;
    }

    public void setPlusCode(String plusCode) {
        this.plusCode = plusCode;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUuid() {
        return uuid;
    }

    public String getBirdCode() {
        return birdCode;
    }

    public String getPlusCode() {
        return plusCode;
    }

    public MultipartFile getFile() {
        return file;
    }

    public String getUrl() {
        return url;
    }
}
