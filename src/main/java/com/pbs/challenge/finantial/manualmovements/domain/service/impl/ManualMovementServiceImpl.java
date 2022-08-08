package com.pbs.challenge.finantial.manualmovements.domain.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pbs.challenge.finantial.manualmovements.domain.model.ManualMovement;
import com.pbs.challenge.finantial.manualmovements.domain.model.Product;
import com.pbs.challenge.finantial.manualmovements.domain.model.ProductCosif;
import com.pbs.challenge.finantial.manualmovements.domain.repository.ManualMovementRepository;
import com.pbs.challenge.finantial.manualmovements.domain.repository.ProductCosifRepository;
import com.pbs.challenge.finantial.manualmovements.domain.repository.ProductRepository;
import com.pbs.challenge.finantial.manualmovements.domain.service.ManualMovementService;
import com.pbs.challenge.finantial.manualmovements.domain.service.exceptions.ProductCosifNotFoundOrInactiveException;
import com.pbs.challenge.finantial.manualmovements.domain.service.exceptions.ProductNotFoundOrInactiveException;

@Service
public class ManualMovementServiceImpl implements ManualMovementService {

	@Autowired
	private ManualMovementRepository manualMovementRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductCosifRepository productCosifRepository;
	
	@Override
	public List<ManualMovement> findAllOrderByYearMonthOfYearNumber() {
		
		List<ManualMovement> manualMovementList = manualMovementRepository.findAllOrderByYearMonthOfYearNumberAsc();
		
		return manualMovementList;
	}

	@Override
	@Transactional
	public ManualMovement save(ManualMovement manualMovement) throws ProductCosifNotFoundOrInactiveException, ProductNotFoundOrInactiveException {
		
		Product productOfMovement;
		
		if( manualMovement == null )
			throw new IllegalArgumentException("Manual Movement cannot be null !");

		if(manualMovement.getManualMovementId().getProductCosif().getProductCosifId() == null)
			throw new IllegalArgumentException("ManualMovement.manualMovementId.productCosif.productCosifId cannot be null !");
		
		if(manualMovement.getManualMovementId().getProductCosif().getProductCosifId().getProduct() == null)
			throw new IllegalArgumentException("ManualMovement.manualMovementId.productCosif.productCosifId.product cannot be null !");
		
		String cosifCode = manualMovement.getManualMovementId().getProductCosif().getProductCosifId().getCosifCode();
		String productCode = manualMovement.getManualMovementId().getProductCosif().getProductCosifId().getProduct().getCode();
		
		Optional<Product> productOptional = productRepository.findProductByCodeAndStatus(productCode, 'A');

		productOfMovement = productOptional.orElseThrow(
													()->new ProductNotFoundOrInactiveException(productCode)
												);

		Optional<ProductCosif> productCosifOptional = productCosifRepository.findByProductCodeAndCosifCodedAndStatus(  productCode, cosifCode, 'A' );

		productCosifOptional.orElseThrow(
						() -> new ProductCosifNotFoundOrInactiveException(cosifCode, productCode)
					);
		
		BigDecimal year = manualMovement.getManualMovementId().getYear();
		BigDecimal monthOfYear = manualMovement.getManualMovementId().getMonthOfYear();
		
		BigDecimal maxNumberIncremented = manualMovementRepository.findMaxNoteNumberByYearMonthOfYear(year, monthOfYear);
		
		if(maxNumberIncremented != null)
			manualMovement.getManualMovementId().setNumber(maxNumberIncremented);
		else
			manualMovement.getManualMovementId().setNumber(new BigDecimal(1));
		
		manualMovement.setDatetime( LocalDateTime.now() );
		manualMovement.setUserCode("TESTE");
		
		ManualMovement manualMovementReturned = manualMovementRepository.save(manualMovement);
		
		manualMovementReturned.getManualMovementId().getProductCosif().getProductCosifId().setProduct(productOfMovement);
		
		return manualMovementReturned;
	}

}
