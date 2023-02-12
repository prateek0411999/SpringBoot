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
		
		// there are just 3 main components of SPRING SECURITY (Check image in root directory)
				// 1. Authentication 
				// 2. Authorization  -> Authorization is the process to allow authority to perform actions in the application.
				// 3. Filter -> A filter is an object that is invoked at the preprocessing and post-processing of a request
					// (FILTER IS SIMILAR TO MIDDLEWARE- jo ki sabse main kaam krte hh)
		
		
		
		// NOW WHEN WE RUN THE APP AND TRY TO ACCESS THE CONTROLLERS APIS
				// WE WILL SEE THE WHITELABEL ERROR PAGE 
				// THIS IS BECAUSE SPRING SECURITY PACKAGE WILL AUTOMATICALLY CONFIGURED OUR APP FOR AUTHENTICATION  (sign in & sign out functionality will be added automatically by spring security)
							// ROUTES
							// ---> /login -> if we are not logged in and try to access the application apis (by default it will protect every route but it can be configured for making public apis as well)
							// ---> /logout -> to logout
					// IT WILL AUTOMATICALLY REDIRECTS US TO LOGIN PAGE (i.e. created by spring security itself , will ask for username & password)
					// WE CAN"T ACCESS API as we'll not be signed in yet
					
		// BY DEFAULT SPRING SECURITY WILL PROTECT ALL THE ROUTES/APIS  IN THE APPLICAITON
			 // (we can also configure this as well -> sometimes we need Public APIS as well)
		
			// BUT THE THING IS FROM WHERE WE'll get the users username and password
				// to access those routes (obviously it won't be our own create user class records right)
			   // by default spring security will create a user record 
					// with username -> user
					// and password -> we'll get in the console (Using generated security password: 14556e87-9eff-4c31-b672-c620eace2ad6)
		
		
		
		
		
		
		
		
		
		
		// NOW WE'll SEE HOW SPRING SECURITY DOES THIS THINGS AUTOMATICALLY (See image in root directory then study) EEEEZZZZZZZZZ
		
				//i.e. how spring security works
					// (what all components gets used when a client sends a request to our back-end server)
		
				// 1. When the request comes it will go into the Filter (it will intercept the request mid way )
							// (now filter can only intercept but he can't do authentication itself right)
		
				// 2. Filter will then create the Authentication Object with basic details and give the request to AuthenticationManager
				// 3. Now AuthenticationManager is responsible to use that Authentication Object and check if that user is valid or not
						// it will call the authenticate method passing in the Authentication Object recieved from filter
							// authenticate(Authentication  auth)
						// now this AuthenticationManager is an interface it just contains this authenticate action
						// now to call this authenticate method we've number of Authentication Providers (session based, token based, OAuth 1.0, OAuth 2.0, Digest Auth, Hawk authentication ......)   (Authentication providers are simply classes that are implementing different types of authentication and we can use that as per our need)
						// but now the thing is AuthenticationManager doesn't know which AuthenticationProvider to use  right!!!!!!!!!!! (like which one we want)
						// so now AuthenticationManager will call a ProviderManager
						// ProviderManager has the power to check for suitable AuthenticationManager for us
							// if a particular AuthenticationProvider is suitable then it will choose that
							// else it will return false 
						// every AuthenticationProvider uses a inbuilt service for User model
						// i.e. UserDetailService 
						// AuthenticationProviders can call this service to check for passed attributes
								// whether a user exists in our database  or not
								// based on that it will return true and false
						// once the authentication is done
						// then  AuthenticationProvider will update the property called as authentication_true in that same Authentication object that got passed to it intially
						// i.e. valid authentication object will be returned to ProviderManager
						// and ProviderManager will then send this same valid object to the Filter 
			// 4. and Now filter will store that object in the securityContext
			// 5. and now securityContext has the object so the request will be forwarded to the appropiate controller
						
		
		
		
		
		
		
		
		
		
		
		
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
