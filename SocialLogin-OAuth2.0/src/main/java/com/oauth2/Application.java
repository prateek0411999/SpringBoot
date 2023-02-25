package com.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		//spring security already has done everthing for us
		// we can need to configure the securityFilterChain
		// and tell that we will be using oauth2Login
		// and in the application.properites file
		// we just need to give client-id and client-secret and that's it
		
	}

}
