package com.pbs.challenge.finantial.manualmovements.api.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbs.challenge.finantial.manualmovements.api.assembler.output.ProductCosifModelOutputAssembler;
import com.pbs.challenge.finantial.manualmovements.api.controller.ProductCosifController;
import com.pbs.challenge.finantial.manualmovements.api.model.output.ProductCosifModelOutput;
import com.pbs.challenge.finantial.manualmovements.domain.model.ProductCosif;
import com.pbs.challenge.finantial.manualmovements.domain.service.ProductCosifService;

@RestController
@RequestMapping(path = "/v1/productcosif")
public class ProductCosifControllerImpl implements ProductCosifController {

	@Autowired
	private ProductCosifService productCosifService;
	
	@Autowired
	private ProductCosifModelOutputAssembler productCosifModelAssembler;
	
	@GetMapping("/allactive/product/{productCode:[a-fA-F0-9]{4}}")
	@CrossOrigin(origins = "*")	
	public ResponseEntity<List<ProductCosifModelOutput>> listAllActiveByCode( @PathVariable("productCode") String productCode) throws Exception {

		List<ProductCosif> productCosifList = productCosifService.
												findAllActiveByProduct(productCode);
		
		List<ProductCosifModelOutput> productCosifModelList = productCosifModelAssembler.toCollectionOutputModel(productCosifList);	
		
		return ResponseEntity.ok(productCosifModelList);
	}
	
}
