package com.awscodesnippet.S3DemoApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S3DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3DemoApplication.class, args);
		System.out.println("Welcome to S3 Demo Application");
	}

}
