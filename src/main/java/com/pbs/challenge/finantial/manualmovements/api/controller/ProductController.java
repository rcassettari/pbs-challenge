package com.pbs.challenge.finantial.manualmovements.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbs.challenge.finantial.manualmovements.api.model.output.ProductModelOutput;

@RestController
public interface ProductController {

	@GetMapping
	List<ProductModelOutput> listAllActive();

}
