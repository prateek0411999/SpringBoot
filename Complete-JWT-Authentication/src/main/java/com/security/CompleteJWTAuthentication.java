package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@SpringBootApplication
public class CompleteJWTAuthentication {

	public static void main(String[] args) {
		SpringApplication.run(CompleteJWTAuthentication.class, args);
		
		// FLOW IS LIKE
				// BEFORE THIS GO THROUGH THE SPRING SECURITY FLOW, You can find some attached images in the root directory of some projects
				// Just get a hang of filter, then AuthenticationManager that needs an authentication object
				// when we run the authenticate method of AuthenticationManager
				// the request will go the authenticationProvider who actually sets the isAuthenticate value to TRUE in that authentication object
							// authenticationProvider does this by calling the UserDetailsService  (where we also override its loadUserbyUsername method in the config classfile so that it make use of our user model in our database rather than its own)
							// we can configure the appropiate authenticationProvider to be used in the Config Classfile by overiding its method
							// so authenticationProvider simply compares the username from authentication object that was sent with the userDetailsSerivce.loaduserbyUsername
							// if it matches then it's fine control moves forward
							// else it will throw the error
						// The whole process looks like this
						// 		authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
	
				// UserNamePasswordAuthenticationToken is the Authentication object which is passed to authenticate method of Authentication Manager.
			
		
		// STEP BY STEP
//	1. 	Once a user sends a request it  reaches the right authentication filter based on the authentication mechanism used.
//	2.	Now it extract the given credentials from the request and then using the supplied values UsernamePasswordAuthenticationToken is  created( the authentication object).Then  it calls ‘authenticate’ method of the Authentication Manager.
//	3.	The request then passes to Authentication Provider and the Authentication Provider contains an implementation of UserDetailsService.
//	4.	Spring loads the user information in UserDetailsService  by calling loadbyuserName and compares the username/password combination with the credentials supplied at login.
//  5.	If the user is valid then Authentication Manger creates UsernamePasswordAuthenticationToken  instance with follwing Constructor  , setting authenticated =true .
	}

}
