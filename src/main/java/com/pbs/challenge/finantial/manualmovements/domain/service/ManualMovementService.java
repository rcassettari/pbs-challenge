package com.pbs.challenge.finantial.manualmovements.domain.service;

import java.util.List;

import com.pbs.challenge.finantial.manualmovements.domain.model.ManualMovement;
import com.pbs.challenge.finantial.manualmovements.domain.service.exceptions.ProductCosifNotFoundOrInactiveException;
import com.pbs.challenge.finantial.manualmovements.domain.service.exceptions.ProductNotFoundOrInactiveException;

public interface ManualMovementService {

	List<ManualMovement> findAllOrderByYearMonthOfYearNumber();
	
	ManualMovement save( ManualMovement manualMovement) throws ProductCosifNotFoundOrInactiveException, ProductNotFoundOrInactiveException;
}
