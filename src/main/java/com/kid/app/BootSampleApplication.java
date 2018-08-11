package com.kid.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kid.endpoint", "com.kid.security", "com.kid.service", "com.kid.model", "com.kid.dao"})
public class BootSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSampleApplication.class, args);
	}
}
