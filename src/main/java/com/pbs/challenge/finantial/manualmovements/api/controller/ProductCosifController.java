package com.pbs.challenge.finantial.manualmovements.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbs.challenge.finantial.manualmovements.api.model.output.ProductCosifModelOutput;

@RestController
public interface ProductCosifController {
	
	@GetMapping
	ResponseEntity<List<ProductCosifModelOutput>> listAllActiveByCode( String productCode ) throws Exception;

}

