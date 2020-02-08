package com.whyisbillupset.wibu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whyisbillupset.wibu.persistence.documents.Reaction;
import com.whyisbillupset.wibu.persistence.request.ReactionRequest;
import com.whyisbillupset.wibu.repositories.ReactionRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/reaction")
@CrossOrigin(value = "http://localhost:4200")
@Slf4j
public class ReactionController {

	@Autowired
	ReactionRepository reactionRepository;
	
	@PostMapping("add")
	public Reaction addReaction(@RequestBody ReactionRequest request) {
		log.debug("Adding new reaction reason[{}], liked[{}]", request.getReasonId(), request.isLiked());
		return reactionRepository.save(new Reaction( request.getReasonId(), request.isLiked()));
	}
	
	@PutMapping("update")
	public Reaction updateReaction(@RequestParam String reactionId, 
									@RequestParam boolean liked) {
		log.debug("Updating reaction [{}] to liked[{}]", reactionId, liked);
		Reaction reaction = reactionRepository.findById(reactionId)
				.orElseThrow();
		reaction.setLiked(liked);
		return reactionRepository.save(reaction);
	}
	
//	@GetMapping("id")
//	public List<Reaction> getReactionsByReasonId(@RequestBody String reasonId) {
//		log.debug("Request for reactions of reason [{}]", reasonId);
//		return //TODO: method with join
//	}
}
