package com.springboot.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.model.Employee;
import com.springboot.rest.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")   // base api for this controller
public class EmployeeController {

	// controller will be calling to service 
	// to complete the incoming http request
	// so lets define the service object for employee
	
	// @PathVariable to map the path variable with parameter variable
	// @RequestParam to map the url parameters with function params
	// @RequestBody to get the body json and covert it to object of param class
	
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// CREATE EMPLOYEE REST API 
	
		// (POST REQuest so we'll use @PostMapping annotation)
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
	
	
	
	
	// GET ALL EMPLOYEE REST API
		
		// (GET Request - @GetMapping)
	
	@GetMapping("/list")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	
	
	
	
	
	// GET EMPLOYEE BY ID
		
		// (GET Request)
		// USING PATH VARIABLE
		// localhost:8080/api/employees/1
		
		//	@GetMapping("{id}")
		//	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
		//		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
		//	} 
			
		// USING REQUEST PARAM
		// localhost:8080/api/employees/get?id=1
	
	@GetMapping("/get")
	public ResponseEntity<Employee> getEmployeeById(@RequestParam("id") String id){
		//converting string to long
		long employee_id = Long.parseLong(id);
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employee_id), HttpStatus.OK);
	}
	
	

	
	// UPDATE EMPOYEE REST API 
	
		//(PUTMapping -> updating all contents)
		//sending id as request param - localhost:8080/api/employees/update?id=2  and json as requestbody
		// we can send the id as path variable also - localhost:8080/api/employees/update/1   and json as requestbody (for this we just need to use @PathVariable annotation)
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestParam("id") String id, @RequestBody Employee employee){
		//converting string to long
		long employee_id = Long.parseLong(id);
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employee_id), HttpStatus.OK);
	}
	
	
	
	
	// DELETE EMPLOYEE REST API
	
			//using path variable -> @PathVariable annotation
			// localhost:8080/api/employees/delete/1
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id){
		//converting string to long
		long employee_id = Long.parseLong(id);
		// calling service method
		employeeService.deleteEmployeeByID(employee_id);
		// we'll choose reposnseEntity params with body and status
		return new ResponseEntity<String>("Employee deleted Successfully!!", HttpStatus.OK);
	}
	
		
	
	
	
	
}
