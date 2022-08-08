package com.pbs.challenge.finantial.manualmovements.domain.service;

import java.util.List;

import com.pbs.challenge.finantial.manualmovements.domain.model.ProductCosif;
import com.pbs.challenge.finantial.manualmovements.domain.service.exceptions.ProductCosifNotFoundOrInactiveException;

public interface ProductCosifService {
	
	List<ProductCosif> findAllActiveByProduct( String productCode ) throws ProductCosifNotFoundOrInactiveException;

}
