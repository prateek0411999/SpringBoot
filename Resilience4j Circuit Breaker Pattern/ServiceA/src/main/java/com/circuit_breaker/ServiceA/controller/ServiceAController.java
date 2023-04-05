package com.circuit_breaker.ServiceA.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
    private static final String SERVICE_A = "serviceA";
    @GetMapping
    @CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceAFallback")
    public String serviceA(){
        // call the serviceB
        return  restTemplate.getForObject(BASE_URL + "/api/b", String.class);

    }



    public String serviceAFallback(Exception e){
        return "this is a fallback method for Service A";

    }
}
