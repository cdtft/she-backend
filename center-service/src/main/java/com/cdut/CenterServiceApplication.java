package com.cdut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CenterServiceApplication {
    /*
    * 服务注册和发现模块
    * */
	public static void main(String[] args) {

		SpringApplication.run(CenterServiceApplication.class, args);
	}
}
