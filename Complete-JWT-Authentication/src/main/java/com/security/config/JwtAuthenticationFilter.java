package com.security.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.services.jwt.jwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

//now to make this class a filter 
	// implemting filter (implements Filter)
// as we want this filter to be active for every single request
// so we'll extend it to  OncePerRequestFilter
// this OncePerRequestFilter already implements this filter so no need


// we also need to make this a bean so that we can inject it at 
// so for that we can add @component, @service, @repository or @bean annotion anything that we want

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final jwtService jwtService;
	
	private final UserDetailsService userDetailsService;
	
	// after extending we need to implement the unimplemented methods
	// i.e. doFilterInternal
	// and here we have request, response and filterchain itself already provided
	
	// FilterChain -> Contains the list of all the filters that we need to execute 
	
	
	// abhi yeh filter sabse phele aayega (sabse aage khada hh yeh filter as we'll use addFilterBefore action)
	// so request sabse phele yaha hi aayegi
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String authorizationHeader = request.getHeader("Authorization");
		final String jwt;
		final String userEmail;
		// STEP-1 Whether the request contains the jwt token or not
		
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			// if the header itself is null & we'll make the control go ahead to next filter in the filter chain
			filterChain.doFilter(request, response);
			return;
		}
		
		// when the authorizationHeader is present
		// STEP-2 GET THE jwt token   (getting the string value from the 7th index i.e. after Bearer )
		jwt = authorizationHeader.substring(7);
		
		// now we need to extract the email from that jwt payload so that we can check it from database whether that user exists or not
		// to do so (EXtract the userEmail from jwt token)
		// we need a class that can decode this token
		userEmail = jwtService.extractUsername(jwt);
		
		// now in this case we'll be storing the information of the users who are logging in
		// inside the SecurityContextHolder 
		// so that next time when request comes we don't need to call the jwt service and userDetailsService to go the db fetch user details and all\
		// but in the most of places we actually do this thing only to check for user everytime  (we don't store the authenticated user information)
		
		
		// now we'll check userEmail should not be null and must not be present in SecurityContextHolder
		if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			//get the userDetails from the database
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
			if(jwtService.isTokenValid(jwt, userDetails)) {
				//update the security context and send the request to dispacther servlet
				
				// create the object of usernamePasswordAuthenticationToken & pass userDetails as params
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				// added details of our request
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				//update the security context holder
				SecurityContextHolder.getContext().setAuthentication(authToken);
				
			}
		
		}
		// pass the hand to the next filter
		filterChain.doFilter(request, response);
		
		
		
	}

}
