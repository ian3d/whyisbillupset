package com.whyisbillupset.wibu.repositories;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.whyisbillupset.wibu.persistence.documents.Reason;

import reactor.core.publisher.Mono;

public interface ReasonRepository extends ReactiveMongoRepository<Reason, String> {
	
	@Query(value="{}")
	@Aggregation("{ $sample: { size: 1 } }")
	Mono<Reason> findRandom();
}
