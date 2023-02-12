package com.springboot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


//In Spring Security 5.7.0-M2 we deprecated the WebSecurityConfigurerAdapter, as we encourage users to move towards a component-based security configuration.
// earlier we used to extend this class with that
// and override its already implemented methods

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// we can configure the user data required for basic authentication
	// using the userDetailsService 
	// and usin the appropiate methods
			// withUsername, password, roles, build (to build the object)
			// we can also use passwordEncoder to encode the password first and then save it in securityContext
		// we can then save them in memory
		// by creating a new InMemoryUserDetailsManager object and passing it the user objects that we've created
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		// this is where weca
		UserDetails admin = User.withUsername("prateek")
				.password(encoder.encode("pass"))
				.roles("ADMIN")
				.build();
		
		UserDetails user = User.withUsername("sharma")
				.password(encoder.encode("shaaa"))
				.roles("USER")
				.build();
		
		// add these user to in-memory user details manager
		return new InMemoryUserDetailsManager(admin, user);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	// this is the filter and we're defining the security mechanism that we wanted to use
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// this is where we define which type to authentication we're going to use
				// WHAT ALL ROUTES WE WANT TO PERMITT WITHOUT AUTHENTTICATION (PUBLIC APIS)
		
		
		
		
//		http.csrf().disable()
//			.authorizeHttpRequests()
//			.anyRequest()
//			.authenticated()
//			.and()
//			.httpBasic();
		
		
		// we can use request matcher with permit In place of any request 
		// to allow for public api's and much more 
		
		
		
		http.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/v1/users/all")
			.permitAll()
			.and()
			.httpBasic();
			
		
		return http.build();
	}
}
