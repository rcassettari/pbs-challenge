package com.pbs.challenge.finantial.manualmovements.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table( name = "PRODUTO_COSIF" )
public class ProductCosif {

	@EqualsAndHashCode.Include
	@EmbeddedId
	ProductCosifId productCosifId;
	
    @Column(name = "COD_CLASSIFICACAO", length = 6, nullable = true )
	private String classificationCode;
    @Column(name = "STA_STATUS", length = 1,nullable = true )
	private char status;
	
}

