package com.springboot.associations.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.associations.onetomany.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
