package com.code.CompleteSpringDataJPAProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompleteSpringDataJpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompleteSpringDataJpaProjectApplication.class, args);
	}



	// what is spring data JPA, why is it introducted, what exactly JPA means ?
	     // so whenever we're working with database we need to connect to the database and for that we use JDBC
	     // now java works on the concepts of objects and classes
		// and database works on tables, columns and rows
		// Earlier in a traditional way what we used to do is we'll fetch the data from the database and we convert each of those rows to an object of our class right ???
		// So that was the coversions we were doing and ideally we should not be doing those conversions
		// there has to be a system which automically defines the mapping of objects to the rows and columns in the database

		// so that's where the  ORM (object relational mapping ) Concept/functionality comes into the picture
		// frameworks like HIBERNATE, MyBatis does the mapping for us (but they have their own of implementation right ????)
		// every framework has different type of implementation for doing different things

		// so now just think of moving the framework to MyBatis instead of using HIBERNATE in a application
		//  (we're thinking  -> we need to make changes in all the places where we're using hibernate right ?????)
		// BUT THAT IS NOT THE CASE
		// JAVA has defined a standard specifications that is being used by all the third party ORM providers
		// so that developers can change the framework very easily in their application
		// and that Standard Specification or Set of Rules is nothing but JPA (JAVA PERSISTENCE API) or we call it as SPRING DATA JPA
		// so all the orm providers like hibernate, mybatis will be using this JPA Specification to implement their stuff

		// I.E.
		// JAVA ONLY PROVIDES JPA Specification
		// NOT THE ORM
		// WE NEED TO USE THE THIRD PARTY ORM LIKE HIBERNATE OR MYBATIS
		// TO IMPLEMENT THE ORM FUNCTIONALITY IN OUR APPLICATION
}
