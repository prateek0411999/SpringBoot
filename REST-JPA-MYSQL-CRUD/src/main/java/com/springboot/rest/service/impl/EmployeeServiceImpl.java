package com.springboot.rest.service.impl;

import org.springframework.stereotype.Service;

import com.springboot.rest.model.Employee;
import com.springboot.rest.repository.EmployeeRepository;
import com.springboot.rest.service.EmployeeService;

//@Service annotation is used with classes that provide some business functionalities.
// this @service annotation contains @component annotation inside of it
// so this class is basically a spring component or BEAN (we can say)
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	// 1. setter based dependency injection (used when we have optional parameters)
	// 2. constructor based dependency injection (used when we have mandatory params)
	
	// also we don't need to write @Autowired annotation
	// in spring if a spring bean or spring component has only ONE constructor
	//then the @Autowired annotation can be ommited
	// spring will use that constructor and inject all the necessary dependencies
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

}
