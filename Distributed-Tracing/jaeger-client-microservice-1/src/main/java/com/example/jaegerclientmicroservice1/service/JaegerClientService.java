package com.example.jaegerclientmicroservice1.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class JaegerClientService {
    private WebClient webClient;

    public Mono<String> get(Integer id){
        return webClient.get()
                .uri("http://localhost:9091/jaeger/server/" + id)
                .retrieve()
                .bodyToMono(String.class);

    }

}
