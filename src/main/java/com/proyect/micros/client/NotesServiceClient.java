package com.proyect.micros.client;

import org.springframework.cloud.openfeign.FeignClient;	
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.proyect.micros.DTO.RequestDTO;
import com.proyect.micros.DTO.ResponseDTO;

@FeignClient(name = "note-client", url = "http://localhost:8081")
public interface NotesServiceClient {
	@PutMapping("notes/update")
	ResponseDTO updateNote(@RequestBody Object object);
	
}
