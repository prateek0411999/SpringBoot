package com.example.jaegerservermicroservice2.controller;

import com.example.jaegerservermicroservice2.service.JaegerServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/jaeger/server")
public class JaegerServerController {
    @Autowired
    private JaegerServerService jaegerServerService;

    @GetMapping("/{id}")
    public Mono<String> get(@PathVariable("id") Integer id){
        return jaegerServerService.get(id);
    }
}
