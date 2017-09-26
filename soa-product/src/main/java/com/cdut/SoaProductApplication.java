package com.cdut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SoaProductApplication {

	public static void main(String[] args) {

		SpringApplication.run(SoaProductApplication.class, args);
	}
}
