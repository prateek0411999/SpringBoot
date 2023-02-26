package com.microservice.services.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.microservice.models.Contact;
import com.microservice.services.ContactService;

@Service
public class ContactServiceImple implements ContactService{
	
	// fake contact list
	List<Contact> list = List.of(
			new Contact(1L, "prateekshrmprateek@gmail.com", "prateek", 1311L),
			new Contact(2L, "adfasdfasdf@gmail.com", "asdfsadf", 1400L),
			new Contact(3L, "rohan@gmail.com", "sheeeesh", 1311L)
			);

	@Override
	public List<Contact> getContactsOfUser(Long user_id) {
		// TODO Auto-generated method stub
		return list.stream().filter(contact -> contact.getUser_id().equals(user_id)).collect(Collectors.toList());
	}

}
