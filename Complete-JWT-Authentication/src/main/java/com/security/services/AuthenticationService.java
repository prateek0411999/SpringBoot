package com.security.services;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.auth.controllers.AuthenticationRequest;
import com.security.auth.controllers.AuthenticationResponse;
import com.security.auth.controllers.RegisterRequest;
import com.security.auth.controllers.ResponseMessage;
import com.security.model.Role;
import com.security.model.User;
import com.security.repository.UserRepository;
import com.security.services.jwt.jwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final jwtService jwtService;
	
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest request) {

		
		// save the user to the database and return the token
		
		var user = User.builder()
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();
		userRepository.save((com.security.model.User) user);
		
		// generate token for that user
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
	
	public AuthenticationResponse login(AuthenticationRequest request) {
		//authentication manager is an interface that is used for authentication
		// in spring security
		// this authentication manager needs the authentication object as parameter
		//  and returns an “Authentication” object on successful authentication of the user
		// new UsernamePasswordAuthenticationToken(
		//		request.getEmail(), 
		//		request.getPassword()
		//		)    
				// this authenicationToken object contains this
				// AuthenticationToken [Principal=prateekkkk@gmail.com, Credentials=[PROTECTED], Authenticated=false, Details=null, Granted Authorities=[]]
//		System.out.println("@@@@@@@@" +  request.getEmail() + request.getPassword());
//		System.out.println(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//				request.getEmail(), 
//				request.getPassword()
//				)));
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(), 
						request.getPassword()
						)
				);
	
		var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		System.out.print("@@@@@@@@" + user);
		// generate token for that user
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
}
