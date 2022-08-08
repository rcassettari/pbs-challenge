package com.pbs.challenge.finantial.manualmovements.api.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbs.challenge.finantial.manualmovements.api.assembler.output.ProductModelOutputAssembler;
import com.pbs.challenge.finantial.manualmovements.api.controller.ProductController;
import com.pbs.challenge.finantial.manualmovements.api.model.output.ProductModelOutput;
import com.pbs.challenge.finantial.manualmovements.domain.model.Product;
import com.pbs.challenge.finantial.manualmovements.domain.service.ProductService;

@RestController
@RequestMapping(path = "/v1/product")
public class ProductControllerImpl implements ProductController {

	@Autowired
	private ProductService productService; 

	@Autowired
	private ProductModelOutputAssembler productModelAssembler;
	
	@GetMapping("/allactive")
	@CrossOrigin(origins = "*")	
	public List<ProductModelOutput> listAllActive() {
	
		List<Product> productList = productService.findAllActiveOrderByDescription();
		
		List<ProductModelOutput> productModelOutputList = productModelAssembler.toCollectionOutputModel(productList);
		
		return productModelOutputList;
	}

}
