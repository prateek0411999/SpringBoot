package com.springboot.associations.onetomany.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "status")
	private Status status; 
	
	
	//if we only write onetoMany annotation and does define anythinng on address side
	// then a new table will be created as post_comments (to manage one to many relationship)
	// but we wanted to have the comment table to only have post_id 
	// so for that we need to use @ManytoOne annotation there
	// and here we need to use mapped_by(and specify the variable defined in comment i.e. post)  so that spring wont create any foriegn key here or new table for us
	
	@OneToMany(mappedBy = "post")
	private List<Comment> comments;
	
}
