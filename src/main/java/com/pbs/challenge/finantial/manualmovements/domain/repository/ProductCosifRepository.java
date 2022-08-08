package com.pbs.challenge.finantial.manualmovements.domain.repository;

import java.util.List;
import java.util.Optional;

import com.pbs.challenge.finantial.manualmovements.domain.model.Product;
import com.pbs.challenge.finantial.manualmovements.domain.model.ProductCosif;

public interface ProductCosifRepository {

	List<ProductCosif> findAllByProductAndStatusOrderByCosifCodeAsc( Product product, char status  );
	
	Optional<ProductCosif> findByProductCodeAndCosifCodedAndStatus( String productCode, String cosifCode, char status  );
}
