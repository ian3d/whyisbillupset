package com.whyisbillupset.wibu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoDatabase;

@Configuration
public class MongoConfig {
	
	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create("mongodb://localhost");
	}
	
	@Bean
	public MongoDatabase mongoDatabase(MongoClient mongoClient) {
		return mongoClient.getDatabase("wibu");
	}
}
