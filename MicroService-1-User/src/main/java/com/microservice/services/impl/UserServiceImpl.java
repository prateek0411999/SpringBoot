package com.microservice.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.models.User;
import com.microservice.services.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	// Fake User list
	List<User> list = List.of(
			new User(1311L, "prateek", "9087934532", null),
			new User(1400L, "manik", "9222222232", null),
			new User(1500L, "ankit", "9033333332", null)
			);

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return list.stream().filter(user -> user.getId().equals(id)).findAny().orElse(null);
	}
	
	
}
