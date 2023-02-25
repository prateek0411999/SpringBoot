package com.microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.models.Contact;
import com.microservice.services.ContactService;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/user/{user_id}")
	public List<Contact> getContacts(@PathVariable("user_id") Long user_id){
		return contactService.getContactsOfUser(user_id);
		
	}
}
