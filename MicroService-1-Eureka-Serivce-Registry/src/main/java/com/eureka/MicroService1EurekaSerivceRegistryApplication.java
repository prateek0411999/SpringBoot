package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroService1EurekaSerivceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroService1EurekaSerivceRegistryApplication.class, args);
	}
	
	// eureka service registry is simply 
	// a registry where we can register our clients (or other microservices that are running on different ips and port)
	// so that calling one microservice from other can be easy
	// without this if we wanted to call another microservice from one 
	// we need to make a API call like
		// http://localhost:8080/api/v1......
	//i.e. we need to specify this ip and port 
	// and this can become difficult to manage especially when 
	// we have multiple microservices
	// for this problem
	// we make use of eureka 
	// In all the other microservice i.e. nothing but a client to eureka service registry
	// we need to add 
				//		<dependency>
					//    <groupId>org.springframework.cloud</groupId>
					//    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
					//</dependency>
	      // and some dependency manageement stuff
	// and we also need to specify a name for this 
	// as we can see in application.yml / appplication.properties
	// so that eureka service registry can detect the same
	
	// as we're using defualt port for service registry i.e. 8761 
	// spring boot automatically checks in the microservices where the >spring-cloud-starter-netflix-eureka-client<  dependecies is there
	// and assigs them with the registry
	
	// and then in our microservices we can simply use the name
	// of the microservice to call an API
	// so this
	   // http://localhost:8080/api/v1......
	 //becomes
		// http://contact-service/api/v1////....
	
	
}
