package com.springboot.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.exception.ResourceNotFoundException;
import com.springboot.rest.model.Employee;
import com.springboot.rest.repository.EmployeeRepository;
import com.springboot.rest.service.EmployeeService;

//@Service annotation is used with classes that provide some business functionalities.
// this @service annotation contains @component annotation inside of it
// so this class is basically a spring component or BEAN (we can say)
@Service
public class EmployeeServiceImpl implements EmployeeService {
	// service basically deals with java objects and  database operation on them
	// database se related query chalane k liye
	// apne ko JPARepository ka object chahiye
	// as it contains methods for doing the same like save, find and more
	// APAN USE KR RHE SPRING SO
	// JPARepository ka object k liye SPRING IOC hi help se
	// dependency Injection perform krke object leke aayenge
	// @Autowire annotion -> is responsible for dependency Injection
	// that's why we've employeeRepository private variable   (isko jpa object bol toh bhi chalega coz obj class extends jpa so can access its methods)
	// and we'll perform constuctor injection 
	// and then employeeRepository object will acts as jpa object
	// and we can use this to perform database functions
	// save, findById like that
	// aur dependency injection 3 types se ho skti hh constructor based, setter based, field based
	
	// 1. setter based dependency injection (used when we have optional parameters)
			// where we use setter method for doing the same
	// 2. constructor based dependency injection (used when we have mandatory params)
	// 3. field based injection
		// for this  we directly use @Autowired annotation on private variable itself
		// no need of constructor or setter for that
	
	// also we don't need to write @Autowired annotation
	// in spring if a spring bean or spring component has only ONE constructor
	//then the @Autowired annotation can be ommited
	// spring will use that constructor and inject all the necessary dependencies
	private EmployeeRepository employeeRepository;
	
	// not mandatory  
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		//we'll use the findAll method in jpa
		// this by default returns the list of all employees
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		//findById stores the employee in Optional Object
		// and to get the employee from optional object
		// we need to use get method
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		throw new ResourceNotFoundException("Employee", "Id", id);
	
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		Optional<Employee> existing_employee = employeeRepository.findById(id);
		if (existing_employee.isPresent()) {
			Employee emp =  existing_employee.get();
			
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setEmail(employee.getEmail());
			// save this updated emp to database
			employeeRepository.save(emp);
			return emp;	
		}
		throw new ResourceNotFoundException("Employee", "Id", id);
	
		
	}


	@Override
	public void deleteEmployeeByID(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> existing_employee = employeeRepository.findById(id);
		if (existing_employee.isPresent()) {
			Employee employee =  existing_employee.get();
			employeeRepository.deleteById(id);
			return;
		}
		throw new ResourceNotFoundException("Employee", "Id", id);
	
	}
	
	
	

}