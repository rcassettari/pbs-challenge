package com.pbs.challenge.finantial.manualmovements.domain.repository;

import java.util.List;
import java.util.Optional;

import com.pbs.challenge.finantial.manualmovements.domain.model.Product;

public interface ProductRepository {
	
	List<Product> findAllByStatusOrderByDescriptionAsc( char status );
	
	Optional<Product> findProductByCodeAndStatus( String productCode , char status );
}
