package com.proyect.micros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrquestadorMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrquestadorMsApplication.class, args);
	}

}
