package com.pbs.challenge.finantial.manualmovements.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbs.challenge.finantial.manualmovements.api.model.input.ManualMovementInput;
import com.pbs.challenge.finantial.manualmovements.api.model.output.ManualMovementOutput;

@RestController
public interface ManualMovementController {

	@GetMapping
	List<ManualMovementOutput> findAllOrderByYearMonthOfYearNumber();

	@PostMapping
	ManualMovementOutput save(ManualMovementInput manualMovementInput) throws Exception;
	
}
