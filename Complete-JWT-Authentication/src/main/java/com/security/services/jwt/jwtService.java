package com.security.services.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/// this jwtService will do everything for us related to jwt
// fetching information from the token
// creating new token for a user
// and all other things



@Service
public class jwtService {
	
	@Value("jwt.secret")
	private static String SECRET_KEY; 


	private Claims extractAllClaims(String token) {
		// claims are nothing but the payload part in the token
		// we're just using Jwts class from io.jsonwebtoken
		// and using its method to get all the payload data
		// by providing the secret key that we used to create
		return Jwts.parserBuilder()
				.setSigningKey(getSecretKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	// creating a generic method to extract a single claim 
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private SecretKey getSecretKey() {
		// TODO Auto-generated method stub
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	
	
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	
	
	// generateTOken
	public String generateToken(
			Map<String, Object> extraClaims,
			UserDetails userDetails
			) {
		// compact method is the one that will generate the return the token
		return Jwts.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 24) ))
				.signWith(getSecretKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	// generating token by passing only userDetails
	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}
	
	
	// Validating a token
	
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return username.equals(userDetails.getUsername()) && !isTokenExired(token) ; 
	}

	private boolean isTokenExired(String token) {
		// get teh expiration date and check it is less that the current datetime if yes that token is expired
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		
		return extractClaim(token, Claims::getExpiration);
	}
	


}
