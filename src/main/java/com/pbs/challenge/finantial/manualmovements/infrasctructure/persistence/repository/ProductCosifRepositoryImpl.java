package com.pbs.challenge.finantial.manualmovements.infrasctructure.persistence.repository;

import com.pbs.challenge.finantial.manualmovements.domain.model.Product;
import com.pbs.challenge.finantial.manualmovements.domain.model.ProductCosif;
import com.pbs.challenge.finantial.manualmovements.domain.model.ProductCosifId;
import com.pbs.challenge.finantial.manualmovements.domain.repository.ProductCosifRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCosifRepositoryImpl extends ProductCosifRepository, JpaRepository<ProductCosif, ProductCosifId> {
	
	@Query(" from ProductCosif where productCosifId.product = :product and status = :status "
			+ "order by productCosifId.cosifCode , classificationCode asc ")
	List<ProductCosif> findAllByProductAndStatusOrderByCosifCodeAsc( @Param("product") Product product, @Param("status") char status  );

	@Query(" from ProductCosif where productCosifId.product.code = :productCode and "
			+ " productCosifId.cosifCode = :cosifCode and "	
			+ " status = :status  ")
	Optional<ProductCosif> findByProductCodeAndCosifCodedAndStatus( @Param("productCode") String productCode, @Param("cosifCode") String cosifCode, @Param("status") char status  );

	
}