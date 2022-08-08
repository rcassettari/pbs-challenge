package com.pbs.challenge.finantial.manualmovements.api.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManualMovementInput {

	@NotNull
    @DecimalMin(value = "1")
	@DecimalMax(value = "12")
	private BigDecimal monthOfYear;
	@NotNull
    @DecimalMin(value = "1")
	@DecimalMax(value = "9999")
    @Digits(integer=4, fraction=0)	
	private BigDecimal year;
	@NotEmpty
	@NotBlank
	@Size( min = 11, max = 11 )	
	private String cosifCode;
	@NotEmpty
	@NotBlank
	@Size( min = 4, max = 4 )
	private String productCode;
	@NotNull
    @Digits(integer=16, fraction=2)		
	private BigDecimal value;
	@NotEmpty
	@NotBlank
	@Size( min = 10, max = 50 )
	private String description;
	
}
