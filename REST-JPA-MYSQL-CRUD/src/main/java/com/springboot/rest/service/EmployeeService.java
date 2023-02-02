package com.springboot.rest.service;

import java.util.List;

import com.springboot.rest.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployeeByID(long id);
}
