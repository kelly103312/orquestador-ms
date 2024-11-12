package com.proyect.micros.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "auth-client", url = "http://localhost:30673")
public interface AuthServiceClient {
	@PostMapping("/auth/login")
	Object login(@RequestBody Object object);
	
}
