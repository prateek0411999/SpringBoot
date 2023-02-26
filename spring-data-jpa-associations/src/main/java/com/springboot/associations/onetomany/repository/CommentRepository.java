package com.springboot.associations.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.associations.onetomany.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
