package com.whyisbillupset.wibu.persistence.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class ReactionRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String reasonId;
	private boolean liked;
	
}
