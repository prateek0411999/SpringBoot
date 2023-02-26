package com.springboot.associations.onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.associations.onetoone.model.Profile;
import com.springboot.associations.onetoone.model.User;
import com.springboot.associations.onetoone.service.ProfileService;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	// constructor dependency injection
	public ProfileController(ProfileService profileService) {
		super();
		this.profileService = profileService;
	}

	@PostMapping("/create")
	public ResponseEntity<Profile> createProfile(@RequestBody Profile profile){
		return new ResponseEntity<Profile>(profileService.createProfile(profile), HttpStatusCode.valueOf(200));
	}
	
	
}
