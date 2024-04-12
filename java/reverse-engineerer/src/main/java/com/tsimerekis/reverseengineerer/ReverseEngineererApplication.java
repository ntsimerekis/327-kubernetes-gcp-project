package com.tsimerekis.reverseengineerer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@ServletComponentScan
@SpringBootApplication
public class ReverseEngineererApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReverseEngineererApplication.class, args);
	}

}
