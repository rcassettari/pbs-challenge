package com.pbs.challenge.finantial.manualmovements.api.assembler.output;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.pbs.challenge.finantial.manualmovements.api.model.output.ManualMovementOutput;
import com.pbs.challenge.finantial.manualmovements.domain.model.ManualMovement;

@Mapper(componentModel = "spring")
public interface ManualMovementModelOutputAssembler {
	
	ManualMovementModelOutputAssembler INSTANCE = Mappers.getMapper(ManualMovementModelOutputAssembler.class);
    
    @Mappings({
        @Mapping(source = "manualMovementId.monthOfYear", target = "monthOfYear"),
        @Mapping(source = "manualMovementId.year", target = "year"),   
        @Mapping(source = "manualMovementId.productCosif.productCosifId.product.code", target = "productModelOutput.code"),
        @Mapping(source = "manualMovementId.productCosif.productCosifId.product.description", target = "productModelOutput.description"),          
        @Mapping(source = "manualMovementId.number", target = "noteNumber") 
    })    
	ManualMovementOutput toOutputModel(ManualMovement manualMovement); 

	List<ManualMovementOutput> toCollectionOutputModel(Iterable<? extends ManualMovement> manualMovementList );
}

