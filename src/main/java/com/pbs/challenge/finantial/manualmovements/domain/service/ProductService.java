package com.pbs.challenge.finantial.manualmovements.domain.service;

import java.util.List;

import com.pbs.challenge.finantial.manualmovements.domain.model.Product;

public interface ProductService {

	List<Product> findAllActiveOrderByDescription();
	
}
