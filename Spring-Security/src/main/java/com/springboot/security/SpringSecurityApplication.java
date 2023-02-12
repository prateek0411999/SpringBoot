package com.springboot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	
		// SPRING SECURITY
			// it automatically secures the web application by default and further we can customize as per our need
			// to enable spring security in our project
			// we need to add spring-boot-starter-security in the package file (pom.xml)
		
		// there are just 3 main components of SPRING SECURITY
				// 1. Authentication 
				// 2. Authorization  -> Authorization is the process to allow authority to perform actions in the application.
				// 3. Filter -> A filter is an object that is invoked at the preprocessing and post-processing of a request
					// (FILTER IS SIMILAR TO MIDDLEWARE)
		
		
		
		// NOW WHEN WE RUN THE APP AND TRY TO ACCESS THE CONTROLLERS APIS
				// WE WILL SEE THE WHITELABEL ERROR PAGE 
				// THIS IS BECAUSE SPRING SECURITY PACKAGE WILL AUTOMATICALLY CONFIGURED OUR APP FOR AUTHENTICATION 
					// IT WILL AUTOMATICALLY REDIRECTRS US TO LOGIN PAGE (i.e. created by spring security itself)
					// WE CAN"T ACCESS API as we'll not be signed in yet
					
		// BY DEFAULT SPRING SECURITY WILL PROTECT ALL THE ROUTES/APIS  IN THE APPLICAITON
			 // (we can also configure this as well -> sometimes we need Public APIS as well)
		
	
		
		
		
		
		//Advantages
	//		Spring Security has numerous advantages. Some of that are given below.
	//
	//		Comprehensive support for authentication and authorization.
	//		Protection against common tasks
	//		Servlet API integration
	//		Integration with Spring MVC
	//		Portability
	//		CSRF protection
	//		Java Configuration support
		
		
//		Spring Security framework supports wide range of authentication models. These models either provided by third parties or framework itself. Spring Security supports integration with all of these technologies.
//
//		HTTP BASIC authentication headers
//		HTTP Digest authentication headers
//		HTTP X.509 client certificate exchange
//		LDAP (Lighweight Directory Access Protocol)
//		Form-based authentication
//		OpenID authentication
//		Automatic remember-me authentication
//		Kerberos
//		JOSSO (Java Open Source Single Sign-On)
//		AppFuse
//		AndroMDA
//		Mule ESB
//		DWR(Direct Web Request)
	}

}
