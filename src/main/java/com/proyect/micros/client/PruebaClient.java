package com.proyect.micros.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyect.micros.DTO.ResponseDTO;

@FeignClient(name = "prueba-client", url = "http://192.168.1.6:9091")
public interface PruebaClient {
	@GetMapping("/cachetadita")
	ResponseDTO pruebaFunction();
}
