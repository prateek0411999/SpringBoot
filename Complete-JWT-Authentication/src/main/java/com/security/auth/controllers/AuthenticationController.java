package com.security.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.services.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

	@Autowired
	private  AuthenticationService service;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register (
			@RequestBody RegisterRequest request){
		
		return ResponseEntity.ok(service.register(request));
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(
			@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(service.login(request));
		
	}
}
