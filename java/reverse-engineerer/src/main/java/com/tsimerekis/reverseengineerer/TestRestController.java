package com.tsimerekis.reverseengineerer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TestRestController {

    private static int i;

    @GetMapping("/api/count")
    public Integer count() {
        return i++;
    }

    @GetMapping("/api/count2")
    public Integer count2() {
        return i++;
    }

    @GetMapping("/ready")
    public String ready() {
        return new String("ok");
    }

    @GetMapping("/healthy")
    public String healthy() {
        return new String("ok");
    }
    
}