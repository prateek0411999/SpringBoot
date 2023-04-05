package com.example.jaegerservermicroservice2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class JaegerServerService {
    @Autowired
    private WebClient webClient;

    public Mono<String> get(Integer id){
        return webClient.get()
                .uri("http://numbersapi.com/" + id)
                .retrieve()
                .bodyToMono(String.class);

    }
}
