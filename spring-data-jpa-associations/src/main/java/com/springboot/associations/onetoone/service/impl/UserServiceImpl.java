package com.springboot.associations.onetoone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springboot.associations.onetoone.model.User;
import com.springboot.associations.onetoone.repository.profileRepository;
import com.springboot.associations.onetoone.repository.userRepository;
import com.springboot.associations.onetoone.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private userRepository userRepository;
	
	@Autowired
	private profileRepository profileRepository;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		return user;
		
	}
	

}
