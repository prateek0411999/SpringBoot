package com.springboot.associations.onetoone.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "users")
public class User {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="first_name", length = 10, nullable = false )
	private String firstName;
	
	@Column(name="email", unique = true)
	private String email;
	
	
	// Join Column signifies that profile_id column will be created for this table only
	// if we specify mappedBy attribute in @onetoone then it signifies user_id column will be created in profile entity and there will be no profile_id column in users table
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_id")
	private Profile profile;
	
}
