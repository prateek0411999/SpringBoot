package com.springboot.associations.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.associations.onetomany.model.Post;
import com.springboot.associations.onetomany.service.PostService;
import com.springboot.associations.onetoone.model.Profile;

@RequestMapping("/api/posts")
@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	
	@PostMapping("/create")
	public ResponseEntity<Post> createPostRecord(@RequestBody Post post){
		return new ResponseEntity<Post>(postService.createPost(post), HttpStatusCode.valueOf(200));
	}
}
