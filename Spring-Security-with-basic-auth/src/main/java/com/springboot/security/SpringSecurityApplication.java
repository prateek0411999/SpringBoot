package com.springboot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	
		// Previously apna
		// form based authentication ho rha tha
		// i.e. /login p form submit krte the
		// and /logout bhi kr skte the
		
		// but we now we'll configure our spring security to use BASIC AUTHENTICATION
			// basic authentication
				// is a very old way of doing api requests
				// and is not used anywhere now
				// but hmm isiliye kr rhe taaki hmm dekh paaye
				// kese change krna hh spring security configuration
				
		
		// IN BASIC AUTH
				// we basically send the username and password in header as Base64 encoded
				// i.e. har ek request k sath headers m encoded email and password jayega bnde ka
				// very risky approach but starting m yahi use hota tha bhot phele
				// postman m bhi basic auth use krke requeest hit kr skte hh
				// it will ask for username and password and it will automatically convert that to base64 and then sends the request
		
		
		
		// SO TO CUSTOMIZE SPRING SECURITY WE NEED TO
				// CREATE A CONFIG Class 
				// addd necessary annotation so that spring knows ki yeh hmari config class hh
					// @Configuration
				// add @EnableWebSecurity -> spring security k liye hh yeh
				// vo class extends karegi WebSecurityConfigurerAdapter ko
				// and then we'll overide the already consisting methods of this class
				// these changes has been depreacted after 3.0
				
		
		// check SecurityConfig class for further learning
		
		
	}

}
