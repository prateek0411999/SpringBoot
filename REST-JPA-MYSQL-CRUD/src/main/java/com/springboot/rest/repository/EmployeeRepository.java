package com.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.model.Employee;

//@Repository -> not needed as we're extending JPARepository class
//Now as it is extending JPARepository
// instance of this interface
// can now have the access to jpa methods
// such as 
// save -> to save the object of the class type
// getById
// findAll
// findById
// saveAll
// count
// delete, deleteAll, deleteById,
// exitsById and many more

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
