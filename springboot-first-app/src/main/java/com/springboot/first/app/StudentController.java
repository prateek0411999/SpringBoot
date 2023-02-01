package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	//@GetMapping("/student")  we can give it like this or write like below
	@GetMapping(path = "/student")
	public Student getStudent(){
		return new Student("prateek", "sharma");
		// we're returning the object here
		// but we're getting back a json
		// that is a beauty of SPRING MVC
		// as it uses JackSon library
		// to convert java objects into json and vice-versa
		// uses HTTPResponse Convertors internally
		
	}
	
	@GetMapping(path="/students")
	public List<Student> getStudents()
	{
		List<Student> students = new ArrayList<>();
		students.add(new Student("kunal", "sharma"));
		students.add(new Student("manik", "sharma"));
		students.add(new Student("dahuja", "sharma"));
		students.add(new Student("ankit", "sharma"));
		
		students.add(new Student("deshwal", "sharma"));
		return students;
	}
	
	
	// handle the path variable 
		// if we wanted to get the record of Student with id 1 and its a path variable
		// http://localhost:8080/student/1'
		// in order to bind id with ID
		// we need to use @PathVariable annotation (binds incoming path variable to method arguments)
		
		@GetMapping("/student/{id}")
		public String studentPathIDVariable(@PathVariable("id") String ID) {
			// we can get the ID here and perform the action
			return "find the student with   " + ID+ "  and return his/her record";
		}
		
		// handle the path variable 
	
		// http://localhost:8080/student/prateek/sharma	
		// in order to bind first_name, last_name with firstName, lastName
		// we need to use @PathVariable annotation (binds incoming path variable to method arguments)
		
		@GetMapping("/student/{first_name}/{last_name}")
		public Student studentPathVariable(@PathVariable("first_name") String firstName, @PathVariable("last_name") String lastName) {
			return new Student(firstName, lastName);
		}
		
		
	
		
	//handle the Request Params or Query Params
		// @RequestParam
	//http://localhost:8080/student?firstName='Ramesh'
		@GetMapping("/get/student")
		public Student getParticularStudent(@RequestParam(name = "firstName") String first_name) {
			// we can get the query param
			// and search that record in the database
			// can then return the record
			// for now we'll return the new record
			System.out.println("REQUEST  PARAM FIRST NAME -----" + first_name );
			return new Student("adfadf", "adfasdf");
		}
		
	
	
	
	
	

	
}
