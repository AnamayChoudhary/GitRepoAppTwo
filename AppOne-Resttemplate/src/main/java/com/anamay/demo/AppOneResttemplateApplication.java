package com.anamay.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppOneResttemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppOneResttemplateApplication.class, args);
	}

}
