package com.springboot.associations.onetoone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.associations.onetoone.model.Profile;
import com.springboot.associations.onetoone.repository.profileRepository;
import com.springboot.associations.onetoone.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private profileRepository profileRepository;

	@Override
	public Profile createProfile(Profile profile) {
		// TODO Auto-generated method stub
		profileRepository.save(profile);
		return profile;
	}
	
}
