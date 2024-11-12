package com.proyect.micros.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.micros.DTO.RequestDTO;
import com.proyect.micros.DTO.ResponseDTO;
import com.proyect.micros.DTO.ResponseUserDTO;
import com.proyect.micros.service.OrchestratorService;


@RestController
@RequestMapping("/process")
public class RequestController {
	private final OrchestratorService orchestadorService;
	
	public RequestController(OrchestratorService orchestadorService) {
		this.orchestadorService = orchestadorService;
	}
	
	@PostMapping
	public ResponseUserDTO request(@RequestBody RequestDTO request) {
		return orchestadorService.handleRequest(request);
	}
}
