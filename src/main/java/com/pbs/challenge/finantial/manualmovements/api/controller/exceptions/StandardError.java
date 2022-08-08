package com.pbs.challenge.finantial.manualmovements.api.controller.exceptions;

import java.io.Serializable;
import java.time.Instant;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8381076278016077024L;
	
	private Instant timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

}
