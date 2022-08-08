package com.pbs.challenge.finantial.manualmovements.domain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbs.challenge.finantial.manualmovements.domain.model.Product;
import com.pbs.challenge.finantial.manualmovements.domain.model.ProductCosif;
import com.pbs.challenge.finantial.manualmovements.domain.repository.ProductCosifRepository;
import com.pbs.challenge.finantial.manualmovements.domain.repository.ProductRepository;
import com.pbs.challenge.finantial.manualmovements.domain.service.ProductCosifService;
import com.pbs.challenge.finantial.manualmovements.domain.service.exceptions.ProductCosifNotFoundOrInactiveException;

@Service
public class ProductCosifServiceImpl implements ProductCosifService {

	@Autowired
	private ProductRepository productRepository; 
	
	@Autowired
	private ProductCosifRepository productCosifRepository; 
	
	@Override
	public List<ProductCosif> findAllActiveByProduct(String productCode) throws ProductCosifNotFoundOrInactiveException {
		
		List<ProductCosif> productCosifList = new ArrayList<>();
		
		Optional<Product> productOptional = productRepository.
					findProductByCodeAndStatus(productCode, 'A');
		
		if(productOptional.isPresent())
		{
			Product currentProduct = productOptional.get();
			productCosifList = productCosifRepository.findAllByProductAndStatusOrderByCosifCodeAsc(currentProduct, 'A');
		}
		else
			throw new ProductCosifNotFoundOrInactiveException(productCode);
		
		return productCosifList;
	}

}
