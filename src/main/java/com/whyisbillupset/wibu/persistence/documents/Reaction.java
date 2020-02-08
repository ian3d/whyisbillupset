package com.whyisbillupset.wibu.persistence.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Reaction {

	@Id
	private String id;
	private String reasonId;
	private boolean liked;
	private Date date;
	
	public Reaction(String reasonId, boolean liked) {
		this.reasonId = reasonId;
		this.liked = liked;
		this.date = new Date();
	}
}
