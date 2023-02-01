package com.springboot.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.model.Employee;
import com.springboot.rest.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")   // base api for this controller
public class EmployeeController {

	// controller will be calling to service 
	// to complete the incoming http request
	// so lets define the service object for employee
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// build create employee REST API (POST REQuest so we'll use @PostMapping annotation)
	// Y are we using ResponseEntity class as a return ttype?
	// BECAUSE
	// we can provide complete response details in this class
	// for example we can add status, header etc
	
	//@RequestBody annotation allows us to retrieve the request body 
	// and automatically convert it to java object
	
	@PostMapping("/create")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
}
