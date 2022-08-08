package com.pbs.challenge.finantial.manualmovements.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table( name = "MOVIMENTO_MANUAL" )
public class ManualMovement {

	@EqualsAndHashCode.Include
	@EmbeddedId
	private ManualMovementId manualMovementId;
   
	@Column(name = "DES_DESCRICAO", length = 50, nullable = false)
	private String description;
	@Column(name = "DAT_MOVIMENTO", nullable = false)	
	private LocalDateTime datetime;
	@Column(name = "COD_USUARIO", length = 15, nullable = false)
	private String userCode;
	@Column(name = "VAL_VALOR", precision = 18, scale = 2, nullable = false)	
	private BigDecimal value;
	
	
}
