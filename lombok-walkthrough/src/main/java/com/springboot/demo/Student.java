package com.springboot.demo;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
//@AllArgsConstructor
//@EqualsAndHashCode
// Rather than writing these 4 annotations
// we can simply do @Data annotation that is one and the same thing

@Data
public class Student {
	private long id;
	private String firstName;
	private String lastName;
	
	// instead of creating a boilerplate code again and again
	// for getter & setters ....
	// we can use LOMBOK
	// that provides us with set of Annotations
	// that can add the funcationality
}
