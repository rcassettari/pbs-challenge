package com.pbs.challenge.finantial.manualmovements.api.controller.exceptionhandler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pbs.challenge.finantial.manualmovements.api.controller.exceptions.StandardError;
import com.pbs.challenge.finantial.manualmovements.domain.service.exceptions.ProductCosifNotFoundOrInactiveException;
import com.pbs.challenge.finantial.manualmovements.domain.service.exceptions.ProductNotFoundOrInactiveException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ProductCosifNotFoundOrInactiveException.class)
	public ResponseEntity<StandardError> productCosifNotFoundOrInactiveException(ProductCosifNotFoundOrInactiveException ex, HttpServletRequest request)
	{
		StandardError standardError = buildStandardError(ex, HttpStatus.BAD_REQUEST, request );
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
	}
	
	@ExceptionHandler(ProductNotFoundOrInactiveException.class)
	public ResponseEntity<StandardError> productNotFoundOrInactiveException(ProductNotFoundOrInactiveException ex, HttpServletRequest request)
	{
		StandardError standardError = buildStandardError(ex, HttpStatus.BAD_REQUEST, request );
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
	}
	
	private StandardError buildStandardError(Exception ex, HttpStatus httpStatus, HttpServletRequest request)
	{
		StandardError standardError = StandardError.builder()
			.timestamp(Instant.now())	
			.status(httpStatus.value())
			.error(httpStatus.getReasonPhrase())
			.message(ex.getMessage())
			.path(request.getRequestURI())
			.build();
		
		return standardError;
	}
	
}
