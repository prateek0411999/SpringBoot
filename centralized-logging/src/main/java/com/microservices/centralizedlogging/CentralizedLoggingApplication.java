package com.microservices.centralizedlogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CentralizedLoggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralizedLoggingApplication.class, args);
	}

	// for centralized logging this is the most popular stack amoung java devs
	//What exactly is the "Elastic Stack"?
	// It’s a fast and highly scalable set of components — Elasticsearch, Kibana, Logstash, and others — that together enable you to securely take data from any source, in any format, and then search, analyze, and visualize it.
	// ELK-> Elastic Search, Logstash, Kibana			(Elastic Stack has created all these tools or plugins)

	// Logstash -> takes that inputs/logs from various sources and exports the data to various targets
	// Elastic Search -> it basically store that logs data in its NoSQL Database so that it can be used by Kibana
	// Kibana -> is a visualization or UI layer, which keeps on fetching the data from elastic search and covert those logs data
			// into charts or diagram to helps in monitoring

	// In a microservice level it is very important to have centralized logging
	// we can't keep going on a particular microservice instance and check it logs
	// whenever there's any issue or something
	// we can simply have a centralized logs
	// so that we can quickly identify where the issue happened
	// resulting in huge time savement.



	// NOTE
	// we need to tell kibana -> from where to fetch the logs
			// as we're using the elastic search to store those logs
		// so kibana should be knowing where the elastic server is running and on which port
			//  RIGHT???
		// so in the bin/kibana.yml file we will uncomment the
			// line 43 and specify the host and port
			//elasticsearch.hosts: ["http://localhost:9200"]
	/// then only we'lll start kibana
	// else how it gonna fetch the logs

}
