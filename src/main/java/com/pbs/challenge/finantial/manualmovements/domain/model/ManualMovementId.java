package com.pbs.challenge.finantial.manualmovements.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class ManualMovementId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8875743037434280822L;
	
	@Column(name = "DAT_MES", nullable = false,precision = 2, scale = 0)
	private BigDecimal monthOfYear;
	@Column(name = "DAT_ANO", nullable = false, precision = 4, scale = 0)	
	private BigDecimal year;
	@Column(name = "NUM_LANCAMENTO", nullable = false, precision = 18, scale = 0)	
	private BigDecimal number;
	
	@ManyToOne(targetEntity = ProductCosif.class)
	@JoinColumns( 
		value =	{
		@JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUTO", nullable = false),
		@JoinColumn(name = "COD_COSIF", referencedColumnName = "COD_COSIF", nullable = false)
	}, foreignKey = @ForeignKey(name = "FK_PRODUTO_COSIF") )
	private ProductCosif productCosif;

}
