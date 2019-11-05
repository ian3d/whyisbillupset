package com.whyisbillupset.wibu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whyisbillupset.wibu.persistence.documents.Reason;
import com.whyisbillupset.wibu.repositories.ReasonRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reason")
@CrossOrigin(value = "http://localhost:4200")
@Slf4j
public class ReasonsController {
	
	@Autowired
	ReasonRepository reasonRepository;
	
	@GetMapping
	public Mono<Reason> getRandomReason() {
		log.debug("Random reason requested");
		return reasonRepository.findRandom();
	}
	
	@PostMapping
	public Mono<Reason> addReason(@RequestBody String reason) {
		return reasonRepository.save(new Reason(reason));
	}
}
