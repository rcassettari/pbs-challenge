package com.pbs.challenge.finantial.manualmovements.api.assembler.output;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pbs.challenge.finantial.manualmovements.api.model.output.ProductModelOutput;
import com.pbs.challenge.finantial.manualmovements.domain.model.Product;

@Mapper(componentModel = "spring")
public interface ProductModelOutputAssembler {

	ProductModelOutputAssembler INSTANCE = Mappers.getMapper(ProductModelOutputAssembler.class);
	
	ProductModelOutput toOutputModel(Product product); 

	List<ProductModelOutput> toCollectionOutputModel(Iterable<? extends Product> productList);
	
}



