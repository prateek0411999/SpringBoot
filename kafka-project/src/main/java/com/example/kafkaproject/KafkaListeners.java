package com.example.kafkaproject;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "kakfatopic1", groupId = "foo")
    void listener(String data){
        System.out.println("Listener Recieved data :) -> "+ data);
    }
}
