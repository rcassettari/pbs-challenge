package com.pbs.challenge.finantial.manualmovements.infrasctructure.persistence.repository;

import com.pbs.challenge.finantial.manualmovements.domain.model.Product;
import com.pbs.challenge.finantial.manualmovements.domain.repository.ProductRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryImpl extends ProductRepository,JpaRepository<Product, String> {
	
	
}