package com.pbs.challenge.finantial.manualmovements.api.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.pbs.challenge.finantial.manualmovements.api.assembler.input.ManualMovementModelInputAssembler;
import com.pbs.challenge.finantial.manualmovements.api.assembler.output.ManualMovementModelOutputAssembler;
import com.pbs.challenge.finantial.manualmovements.api.controller.ManualMovementController;
import com.pbs.challenge.finantial.manualmovements.api.model.input.ManualMovementInput;
import com.pbs.challenge.finantial.manualmovements.api.model.output.ManualMovementOutput;
import com.pbs.challenge.finantial.manualmovements.domain.model.ManualMovement;
import com.pbs.challenge.finantial.manualmovements.domain.service.ManualMovementService;

@RestController
@RequestMapping(path = "/v1/manualmovement")
public class ManualMovementControllerImpl implements ManualMovementController {

	@Autowired
	private ManualMovementService manualMovementService;
	
	@Autowired
	private ManualMovementModelOutputAssembler manualMovementModelOutputAssembler; 
	
	@Autowired
	private ManualMovementModelInputAssembler manualMovementModelInputAssembler;
	
	@GetMapping
	@CrossOrigin(origins = "*")
	public List<ManualMovementOutput> findAllOrderByYearMonthOfYearNumber() {
		
		List<ManualMovement> manualMovementList = manualMovementService
													.findAllOrderByYearMonthOfYearNumber();
		
		List<ManualMovementOutput> manualMovementOutputList = manualMovementModelOutputAssembler.toCollectionOutputModel(manualMovementList);
		
		return manualMovementOutputList;
	}

	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	@CrossOrigin(origins = "*")	
	public ManualMovementOutput save( @Valid @RequestBody ManualMovementInput manualMovementInput) throws Exception {
		
		ManualMovement manualMovementConverted = manualMovementModelInputAssembler.toDomainModel(manualMovementInput);
		
		ManualMovement manualMovementCreated;
		
		manualMovementCreated = manualMovementService.save(manualMovementConverted);
		
		ManualMovementOutput manualMovementOutput = manualMovementModelOutputAssembler.toOutputModel(manualMovementCreated);
		
		return manualMovementOutput;
	}

}
