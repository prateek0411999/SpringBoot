package com.microservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact {
	private Long id;
	private String email;
	private String name;
	
	private Long user_id;
}
