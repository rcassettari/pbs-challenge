package com.pbs.challenge.finantial.manualmovements.api.assembler.output;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.pbs.challenge.finantial.manualmovements.api.model.output.ProductCosifModelOutput;
import com.pbs.challenge.finantial.manualmovements.domain.model.ProductCosif;

@Mapper(componentModel = "spring")
public interface ProductCosifModelOutputAssembler {

	ProductCosifModelOutputAssembler INSTANCE = Mappers.getMapper(ProductCosifModelOutputAssembler.class);
	
    @Mappings({
        @Mapping(source = "productCosifId.cosifCode", target = "cosifCode")
    })
	ProductCosifModelOutput toOutputModel(ProductCosif productCosif); 

	List<ProductCosifModelOutput> toCollectionOutputModel(Iterable<? extends ProductCosif> productCosifList);
	
}

