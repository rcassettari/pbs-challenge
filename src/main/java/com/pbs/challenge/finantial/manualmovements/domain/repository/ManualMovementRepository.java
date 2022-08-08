package com.pbs.challenge.finantial.manualmovements.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.pbs.challenge.finantial.manualmovements.domain.model.ManualMovement;

public interface ManualMovementRepository {
	
	ManualMovement save(ManualMovement manualMovement);

	List<ManualMovement> findAllOrderByYearMonthOfYearNumberAsc();
	
	BigDecimal findMaxNoteNumberByYearMonthOfYear( BigDecimal year, BigDecimal monthOfYear );
	
}

