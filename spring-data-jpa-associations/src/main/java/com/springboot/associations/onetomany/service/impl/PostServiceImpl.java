package com.springboot.associations.onetomany.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.associations.onetomany.model.Comment;
import com.springboot.associations.onetomany.model.Post;
import com.springboot.associations.onetomany.repository.CommentRepository;
import com.springboot.associations.onetomany.repository.PostRepository;
import com.springboot.associations.onetomany.service.PostService;


@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public Post createPost(Post post) {
		// TODO Auto-generated method stub
//		List<Comment> comments = post.getComments();
//		commentRepository.saveAll(comments);
		Post saved_post = postRepository.save(post);
		List<Comment> comments = saved_post.getComments();
		for(Comment c : comments) {
			c.setPost(saved_post);
			commentRepository.save(c);
		}
		
		return saved_post;
	}

}
