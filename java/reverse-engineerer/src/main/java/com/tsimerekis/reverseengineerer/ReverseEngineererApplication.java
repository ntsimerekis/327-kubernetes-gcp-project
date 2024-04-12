package com.tsimerekis.reverseengineerer;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ReverseEngineererApplication {

	private static final Logger logger = Logger.getLogger(LoggingInterceptor.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(ReverseEngineererApplication.class, args);
	}

}
