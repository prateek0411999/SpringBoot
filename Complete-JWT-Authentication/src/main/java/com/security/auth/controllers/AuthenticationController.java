package com.security.auth.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.User;
import com.security.repository.UserRepository;
import com.security.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private  AuthenticationService service;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register (
			@RequestBody RegisterRequest request){
		
		// check if user already present or not
		Optional<User> user1 = userRepository.findByEmail(request.getEmail());
		if (user1.isPresent()) {
			
			return ResponseEntity.ok(AuthenticationResponse.builder().token("Can't assign token, user already exists").build());
		}
		
		return ResponseEntity.ok(service.register(request));
		
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(
			@RequestBody AuthenticationRequest request){
		
		System.out.print("@@@@@" + request);
		return ResponseEntity.ok(service.login(request));
		
	}
}



























