package com.springboot.associations.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.associations.onetoone.model.Profile;

public interface profileRepository extends JpaRepository<Profile, Long> {

}
