package com.springboot.first.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootFirstAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstAppApplication.class, args);
		
		// now when we make any change in our spring boot application
		// we've to manually restart the server again and again
		// to see the updated changes
		// to solve this issue
		// we can use
		// spring-boot-devtools dependency
		// it will automatically restart the server once we save any changes
	}

}
