package com.pbs.challenge.finantial.manualmovements.api.model.output;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManualMovementOutput {

	private BigDecimal monthOfYear;
	private BigDecimal year;
	
	@JsonProperty("product")
	ProductModelOutput productModelOutput;
	
	private BigDecimal noteNumber;
	private BigDecimal value;
	private String description;
	
}

