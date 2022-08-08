package com.pbs.challenge.finantial.manualmovements.api.assembler.input;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.pbs.challenge.finantial.manualmovements.api.model.input.ManualMovementInput;
import com.pbs.challenge.finantial.manualmovements.domain.model.ManualMovement;

@Mapper(componentModel = "spring")
public interface ManualMovementModelInputAssembler {
	
	ManualMovementModelInputAssembler INSTANCE = Mappers.getMapper(ManualMovementModelInputAssembler.class);

    @Mappings({
        @Mapping(source = "monthOfYear", target = "manualMovementId.monthOfYear"),
        @Mapping(source = "year", target = "manualMovementId.year"),   
        @Mapping(source = "cosifCode", target = "manualMovementId.productCosif.productCosifId.cosifCode"), 
        @Mapping(source = "productCode", target = "manualMovementId.productCosif.productCosifId.product.code")
    })
    ManualMovement toDomainModel( ManualMovementInput manualMovementInput );

	List<ManualMovementInput> toCollectionInputModel(Iterable<? extends ManualMovement> manualMovementList );
}

