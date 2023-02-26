package com.springboot.security.models;

import lombok.Data;

@Data
public class User {

	String username;
	String password;
	String email;
	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
}
