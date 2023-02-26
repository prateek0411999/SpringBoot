package com.springboot.security.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.dto.AuthRequest;

@RestController
public class AuthenticationController {

	//public String authenticateAndGetToken(String username, String password)
	// lets use a dto class instead
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		
	}

}
