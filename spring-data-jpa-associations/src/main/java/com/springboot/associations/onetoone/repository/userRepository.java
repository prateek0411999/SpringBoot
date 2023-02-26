package com.springboot.associations.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.associations.onetoone.model.User;

public interface userRepository extends JpaRepository<User, Long> {

}
