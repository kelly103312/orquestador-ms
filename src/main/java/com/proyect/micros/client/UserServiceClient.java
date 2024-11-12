package com.proyect.micros.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "user-client", url = "http://localhost:30688")
public interface UserServiceClient {
	@PostMapping("/user/register")
	Object userRegister(@RequestBody Object object);
	
}
