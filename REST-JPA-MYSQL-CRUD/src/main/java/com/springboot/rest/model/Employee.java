package com.springboot.rest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//creating the JPA Entity

@Data
@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="first_name", nullable = false)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email", nullable = false)
	private String email;
}
