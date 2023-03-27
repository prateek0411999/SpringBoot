package com.circuit_breaker.ServiceB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/b")
public class ServiceBController {
    @GetMapping
    public String serviceB(){
        return "Service B is called from Service A";
    }
}
