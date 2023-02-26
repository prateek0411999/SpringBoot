package com.microservice.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	private Long id;
	private String name;
	private String phone;
	
	List<Contact> contacts = new ArrayList<>();
}
