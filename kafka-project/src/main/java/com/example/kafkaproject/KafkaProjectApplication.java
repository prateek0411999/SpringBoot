package com.example.kafkaproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProjectApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {
			for (int i = 0; i < 1000; i++) {
				kafkaTemplate.send("kafkatopic1", "Hello Kakfa :) " + i);
			}


		};
	}
}
//	Apache Kafka® is an event streaming platform. What does that mean?
//	Kafka combines three key capabilities so you can implement your use cases for event streaming end-to-end with a single battle-tested solution:
//
//	To publish (write) and subscribe to (read) streams of events, including continuous import/export of your data from other systems.
//	To store streams of events durably and reliably for as long as you want.
//	To process streams of events as they occur or retrospectively.


	// 3 main components hh
			// Producers
			// Cluster
			// Consumers


//	Producers are those client applications that publish (write) events to Kafka, and consumers are those that subscribe to (read and process) these events. In Kafka, producers and consumers are fully decoupled and agnostic of each other, which is a key design element to achieve the high scalability that Kafka is known for. For example, producers never need to wait for consumers. Kafka provides various guarantees such as the ability to process events exactly-once.
//	Events are organized and durably stored in topics. Very simplified, a topic is similar to a folder in a filesystem, and the events are the files in that folder



	               // WHERE CAN KAFKA BE USED
//	Activity tracking. This was the original use case for Kafka. ...
//	Real-time data processing. Many systems require data to be processed as soon as it becomes available. ...
//	Messaging. ...
//	Operational Metrics/KPIs. ...
//	Log Aggregation. ...





		// IN SIMPLER TERMS
	//  producers data bhejte rehte hh continously to kafka Cluster
			// DATA kuch bhi ho skta hh -> Real time swiggy track location dikhta hh toh uske coordinates ka data stream kr skte hh aur implement kr skte hh Tracking on google map
			// ab DATA cluster m jaa rha, ese hi kahi bhi todhi chala jeyga?
			// grouping bhi toh honi chahiye, taki ek cheez ka data ek sath rahe
			// and that is called a Topic
			//   (A cluster can have many topics)
			// (in our example lets say the Topic we created in Kafka Broker is LIVE-DELIVERY-TRACKING)
			// toh apne ko agar coordinates ka data stream krna / frontend ko dena hh toh
			// ese hi todhi bhej denge, ek folder/topic hoga na jisme hmm bhejte rahega so that it can keep those logs
			// vo ek log in the TOPIC is called as an EVENT
			// ek event hua -> coordinates aaye
			// apne TOPIC m daal diye, ese hi ek k baad ek event queue m lagte jaate hh TOPIC m
	// now the clusters have the topics in which CONSUMERS can actually look and get the data
// Consumers topic k events ko dekh k use kr skta hh vo data
// as data pura sequence m rehta hh toh Kakfa is much more better than Rabbit MQ



// PRODUCER ek microservice bhi ho skti hh jo notifications throw krti rehti ho
// aur CONSUMER ek microservice ho skti hh jo vo notifications ko use kr rhi ho


