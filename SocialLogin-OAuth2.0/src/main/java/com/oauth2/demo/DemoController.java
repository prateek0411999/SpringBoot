package com.oauth2.demo;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {
	
	@GetMapping
	public ResponseEntity<String> hello(){
		return ResponseEntity.ok("hello from secured end point");
	}
	
	@GetMapping("/data")
	public Map<String, Object> currentUser(OAuth2AuthenticationToken token){
		return token.getPrincipal().getAttributes();
	}

}
