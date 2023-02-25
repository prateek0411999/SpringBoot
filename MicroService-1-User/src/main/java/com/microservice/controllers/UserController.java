package com.microservice.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.models.Contact;
import com.microservice.models.User;
import com.microservice.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{user_id}")
	public User getUser(@PathVariable("user_id") Long user_id) {
		System.out.print("here we wanted that the contacts data associated with that user should also as json");
		// so here we'll be  calling the  microservice Contact project and get the contacts
		// save it to our user and then send it
		// we're doing it synchronously but we most of the time do this async
		
		
		//return this.userService.getUser(user_id);
		

		User user =  this.userService.getUser(user_id);
		//we'll call the api of different project using RestTemplate provided by spring 
		// http://localhost:8083/api/v1/contact/user/1311
		
		List contacts =  this.restTemplate.getForObject("http://localhost:8083/api/v1/contact/user/" + user.getId(), List.class);
	
		user.setContacts(contacts);
		
		// now there's one more problem the user here we've provided to rest client is hard coded
		// this issue can be solved using Eureka (which is also a microservice that we use as service registry)
		return user;
	}
	
}
