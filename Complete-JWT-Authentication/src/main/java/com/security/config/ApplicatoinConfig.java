package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicatoinConfig {
	
	private  UserRepository repository;

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				// get the userdetails from our created users table in our database
				return repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
			}
		};
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		// is the data access object which is responsible to fetch the user details and encode password and so on.
		// we have many authentication providers
		// we need to specify 2 properties
				//1. userDetailsService
				//2. which password Encoder to use
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		
		// which password encoder to user
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
		
//		Spring Security provides a number of AuthenticationProvider implementations,
//
//		Dao AuthenticationProvider
//		Cas AuthenticationProvider
//		X509  AuthenticationProvider
//		Jaas AuthenticationProvider
//		Ldap AuthenticationProvider
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}
