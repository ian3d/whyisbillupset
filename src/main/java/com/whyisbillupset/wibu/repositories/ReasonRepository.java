package com.whyisbillupset.wibu.repositories;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.whyisbillupset.wibu.persistence.documents.Reason;

public interface ReasonRepository extends MongoRepository<Reason, String> {
	
	@Query(value="{}")
	@Aggregation("{ $sample: { size: 1 } }")
	Reason findRandom();
}
