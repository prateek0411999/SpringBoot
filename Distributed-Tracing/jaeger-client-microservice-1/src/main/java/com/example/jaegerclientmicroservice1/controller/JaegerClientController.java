package com.example.jaegerclientmicroservice1.controller;

import com.example.jaegerclientmicroservice1.service.JaegerClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/jaeger/client")
public class JaegerClientController {
    @Autowired
    private JaegerClientService jaegerClientService;

    @GetMapping("/{id}")
    public Mono<String> get(@PathVariable("id") Integer id){
        return jaegerClientService.get(id);
    }
}
