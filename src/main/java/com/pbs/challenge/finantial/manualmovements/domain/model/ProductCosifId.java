package com.pbs.challenge.finantial.manualmovements.domain.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class ProductCosifId implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6228593627879839627L;
	
	@ManyToOne
	@JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUTO", nullable = false,
			foreignKey = @ForeignKey(name = "FK_PRODUTO"))
	private Product product;
	
	@Column(name = "COD_COSIF", length = 11, nullable = false)
	private String cosifCode;
	
	public ProductCosifId(Product product, String cosifCode )
	{
		this.product = product;
		this.cosifCode = cosifCode;
	}
	
}
