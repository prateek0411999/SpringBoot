package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroService1ContactApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroService1ContactApplication.class, args);
		
		// we'll be hitting the request on this microservice i.e. api gateway running on 8999
		// and as specified in the configuration 
		// our request will be redirected to 
		// correct service
		// which is running on a different ip and port 
	}

}
