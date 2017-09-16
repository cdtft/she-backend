package com.cdut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableDiscoveryClient
@EnableHystrixDashboard
public class ServiceFeignApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServiceFeignApplication.class, args);
	}
}
