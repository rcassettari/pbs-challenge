package com.pbs.challenge.finantial.manualmovements.api.model.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
public class ProductCosifModelOutput {
	
	private String cosifCode;
	private String classificationCode;

}
