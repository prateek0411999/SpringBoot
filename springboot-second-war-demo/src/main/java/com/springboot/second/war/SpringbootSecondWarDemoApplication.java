package com.springboot.second.war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootSecondWarDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecondWarDemoApplication.class, args);
	
		// 1st thing whenever we choose to package our spring boot application as WAR file
		// then there will be 2 differences
			//1. ServletInitializer.java file
			// 2. in POM.XML file
					// packaging will be war
					//<packaging>war</packaging>
					// and
					// there will be scope provided tomcat server dependency
		
		// now we need war file of this project
		// that we can get by making a build of ths app 
		// using the mvnw package, java -jar command
		// or simple by rightclicking on project and hit to Maven Build from the RUN option
		// and going in target directory to get the same
		
		// copy that war file in the webapps folder of tomcat directory (that we just downloaded and unzipped)
		// go to bin and search for start up (windows batch file)
		// 
	}
	// for now we'll add a REST POINT here only
	@GetMapping("/greeting")
	public String greeting() {
		return "Spring Boot DEPLOYMENT IN AN EXTERNAL TOMCAT SERVER ";
	}

}
