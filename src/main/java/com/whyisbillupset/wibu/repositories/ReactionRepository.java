package com.whyisbillupset.wibu.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.whyisbillupset.wibu.persistence.documents.Reaction;

public interface ReactionRepository extends MongoRepository<Reaction, String> {
	
}
