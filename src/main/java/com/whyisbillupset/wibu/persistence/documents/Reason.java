package com.whyisbillupset.wibu.persistence.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Reason {
	
	@Id
	private String id;
	private String text;
	private Date enteredOn;
	
	public Reason(String text) {
		this.text = text;
		this.enteredOn = new Date();
	}
}
