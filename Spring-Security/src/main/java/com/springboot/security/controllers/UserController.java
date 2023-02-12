package com.springboot.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.models.User;
import com.springboot.security.services.UserService;


@RestController
@RequestMapping("/v1/users")
public class UserController {

	@Autowired
	private UserService user_service;
	
	// get all users
	@GetMapping("/")
	public List<User> getAllUsers(){
		return this.user_service.getAllUsers();
	}
	
	
	//return single user as path varible  localhost:3000/v1/users/abc@gmailc.om
	@GetMapping("/{email}")
	public User getUser(@PathVariable("email") String email) {
		return this.user_service.getUser(email);
	}
	
	//add user
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		return this.user_service.addUser(user);
	}
	
	
}
