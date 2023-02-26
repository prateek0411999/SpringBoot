package com.springboot.associations.onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.associations.onetoone.model.User;
import com.springboot.associations.onetoone.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController  {
	
	@Autowired
	private UserService userService;
	
	
	// create user 
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.createUser(user), HttpStatusCode.valueOf(200));
	}
	
}
