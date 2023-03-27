package com.circuit_breaker.ServiceA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/a")
public class ServiceAController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:9001";
    @GetMapping
    public String serviceA(){
        // call the serviceB
        return  restTemplate.getForObject(BASE_URL + "/api/b", String.class);

    }
}
