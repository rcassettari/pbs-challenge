package com.pbs.challenge.finantial.manualmovements.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import javax.persistence.Column;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table( name = "PRODUTO")
public class Product {
	
	@EqualsAndHashCode.Include
    @Id
    @Column(name = "COD_PRODUTO", length = 4, nullable = false)
	private String code;
    @Column(name = "DES_PRODUTO", length = 30, nullable = true)
	private String description;
    @Column(name = "STA_STATUS", length = 1, nullable = true )
	private char status;

}

