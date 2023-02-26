package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroService1UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroService1UserApplication.class, args);
		
		/// we've create 2 spring boot apps 
		// microservice 1 user
		// microservice 1 contact
		
		// microservice 1 user wiil be calling to microservice Contact to get the contacts
		// of a specific user that is gettting fetched
		// we'll be using RestTemplate for this
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}



