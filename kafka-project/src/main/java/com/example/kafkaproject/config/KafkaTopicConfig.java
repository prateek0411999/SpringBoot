package com.example.kafkaproject.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

// this class will be responsible for creating topics
@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic kafkaProjectTopic(){
        return TopicBuilder.name("kafkatopic1").build();
    }
}
