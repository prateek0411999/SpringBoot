package com.example.kafkaproject.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    //Configuring producer
    // kafka provides us with the producer factory that takes in the kafka broker configuration (which is running on localhost:9092)
    // as producer should know  where to send the DATA and to which topic it needs to send
//     we need to configure producer factory that needs the configuration of the kafka broker
//            like where it is running,
//             Key serialiazer
//             value serializer
//     these informations should be supplied to producer factory in a  map Data Structure

    @Bean
    public ProducerFactory<String, String> producerFactory(){
        Map<String, Object> configuration = new HashMap<>();
        configuration.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configuration.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configuration.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configuration);
    }
    // Finally we've the producer config which allows us to create kafka producers
    // now we need a way to send messages
    // and this is possible with
    // KAFKA TEMPLATE -> we can initialize it by passing our producer factory to it
    @Bean
    public KafkaTemplate<String,String> kafkaTemplate(ProducerFactory<String, String> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }

    // Now how can we use this kafka template to send message to a topic

}
