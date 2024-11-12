package com.proyect.micros.service;

import org.springframework.stereotype.Service;

import com.proyect.micros.DTO.RequestDTO;
import com.proyect.micros.DTO.ResponseDTO;
import com.proyect.micros.DTO.ResponseUserDTO;
import com.proyect.micros.client.AuthServiceClient;
import com.proyect.micros.client.NotesServiceClient;
import com.proyect.micros.client.PruebaClient;
import com.proyect.micros.client.UserServiceClient;

@Service
public class OrchestratorService {
	private final NotesServiceClient noteService;
	private final PruebaClient pruebaService;
	private final UserServiceClient userService;
	private final AuthServiceClient authService;
	
	public OrchestratorService(AuthServiceClient authService,UserServiceClient userService,NotesServiceClient noteService, PruebaClient prueba) {
		this.noteService = noteService;
		this.pruebaService = prueba;
		this.userService=userService;
		this.authService=authService;
	}
	
	public ResponseUserDTO handleRequest(RequestDTO request) {
		ResponseUserDTO response = new ResponseUserDTO();
		
		try {

            /*if (request.getType().equalsIgnoreCase("update_notes")) {
            	return handleUpdateFlow(request.getObject());
            }*/
            
            if (request.getType().equalsIgnoreCase("/auth/login")) {
            	return handleAuthFlow(request.getObject());
            }
            
            if(request.getType().equalsIgnoreCase("user/register")) {
            	System.out.print("user regiter");
            	return handleUserRegisterFlow(request.getObject());
            }

        } catch (Exception e) {
        	response.setEstado("500");
        	response.setMessage(e.getMessage());
            return response;
        }
		return response;
	}
	
	public ResponseDTO handleUpdateFlow(Object object) {
		System.out.println(object.toString());
		return this.noteService.updateNote(object);
	}
	public ResponseUserDTO handleAuthFlow(Object object) {
		ResponseUserDTO response = new ResponseUserDTO();
		try {
			Object objectResponse = this.authService.login(object);	
			response.setObject(objectResponse);
			return response;		
		} catch (Exception e) {
        	response.setEstado("400");
        	response.setMessage("En estos momentos no se puede acceder al servicio de prueba");
            return response;
        }
	}
	public ResponseUserDTO handleUserRegisterFlow(Object object) {
		ResponseUserDTO response = new ResponseUserDTO();
		System.out.print(object.toString());
		try {
			Object objectResponse = this.userService.userRegister(object);	
			System.out.print(objectResponse.toString());
			response.setObject(objectResponse);
			return response;	
		} catch (Exception e) {
			System.out.print(e.getMessage());
        	response.setEstado("400");
        	response.setMessage("En estos momentos no se puede acceder al servicio de usuario");
            return response;
        }
	}
}
