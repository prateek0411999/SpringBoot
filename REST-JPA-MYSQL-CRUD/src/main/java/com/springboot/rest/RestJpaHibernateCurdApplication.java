package com.springboot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestJpaHibernateCurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestJpaHibernateCurdApplication.class, args);
	
		// configured mysql database in application.properties file in resources
		// initialized the JPA entity employee inside the models package
		// will create a EmployeeRepository interface (which manages/organizes the data) that will extend the jpa repository class (which takes 2 args, 1st one is entity class name, 2nd is primary key datatype)
		// spring data jpa internally provides @Repository annotation so we don't need to add @Repository annotation to EmployeeRepository interface
		// also Spring Data JPA made jpaRepository methods transactional so we don't need to add @Transaction annotation in service classes
					// A repository is a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects. It is a specialization of the @Component annotation allowing for implementation classes to be autodetected through classpath scanning.
	
		
		
		
		
		
						// Spring Boot Architecture
		//Spring Boot follows a layered architecture in which each layer communicates with the layer directly below or above (hierarchical structure) it.
		//Spring Boot Architecture has four layers:
		
		//Presentation Layer – Authentication & Json Translation (CONTROLLER) (@RestController)
				//		✔️ Performing authentication. 
				//		✔️ Converting JSON data into an object (and vice versa).
				//		✔️ Handling HTTP requests.
				//		✔️ Transfering authentication to the business layer.
		//Business Layer – Business Logic, Validation & Authorization (SERVICE)
				//		The Business layer communicates with both the Presentation layer and the Persistence Layer.
				//		✔️ Performing validation.
				//		✔️ Performing authorization.
				//		✔️ Handling the business logic and rules.
		//Persistence Layer – Storage Logic
				//		This layer is responsible for:
				//
				//			✔️ Containing storage logic.
				//
				//			✔️ Fetching objects and translating them into database rows (and vice versa).
		//Database Layer – Actual Database   

		// controller is responsible for handling the client request first
		// controller then call the appropiate service
		// service then class the repository

		//Annotation
				//@Controller : Annotated class indicates that it is a controller component, and mainly used at the presentation layer. 
				//@Service : It indicates annotated class is a Service component in the business layer. 
				// @Repository : You need to use this annotation within the persistence layer, this acts like database repository.
								// repository  basically extends the jpa library class
								// so all the jpa methods (or you can say hibernate methods)
								// will be accessible to that repository instance
	}

}
