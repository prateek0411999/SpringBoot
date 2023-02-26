package com.springboot.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.security.models.*;


@Service
public class UserService {
	List<User> list =  new ArrayList<>();

	public UserService() {
		list.add(new User("adf", "pass", "adfasdf@gmail.com"));
	}
	
	// get all users
	public List<User> getAllUsers(){
		return this.list;
	}
	
	// get single user
	public User getUser(String email) {
		return this.list.stream().filter((user) -> user.getEmail().equals(email)).findAny().orElse(null);
	}
	
	// add new user
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
    
}
