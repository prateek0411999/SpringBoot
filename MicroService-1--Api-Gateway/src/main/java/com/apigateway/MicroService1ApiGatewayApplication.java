package com.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroService1ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroService1ApiGatewayApplication.class, args);
	// to configure the gateway
		// we need to define the same in application.yml
		
		
	}

}
