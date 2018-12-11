package com.visionet.micoserviceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicoserviceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicoserviceEurekaApplication.class, args);
	}
}
