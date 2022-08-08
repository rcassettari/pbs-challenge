package com.pbs.challenge.finantial.manualmovements.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbs.challenge.finantial.manualmovements.domain.model.Product;
import com.pbs.challenge.finantial.manualmovements.domain.repository.ProductRepository;
import com.pbs.challenge.finantial.manualmovements.domain.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository; 
	
	@Override
	public List<Product> findAllActiveOrderByDescription() {
		
		List<Product> activeProductList = productRepository.findAllByStatusOrderByDescriptionAsc('A');
		
		return activeProductList;
	}

}
