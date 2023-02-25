package com.microservice.services;

import java.util.List;

import com.microservice.models.Contact;

public interface ContactService {
	
	public List<Contact> getContactsOfUser(Long user_id);
}
