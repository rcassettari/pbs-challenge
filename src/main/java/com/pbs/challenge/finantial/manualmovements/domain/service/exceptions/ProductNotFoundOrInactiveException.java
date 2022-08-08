package com.pbs.challenge.finantial.manualmovements.domain.service.exceptions;

public class ProductNotFoundOrInactiveException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4049534450383110894L;

	public ProductNotFoundOrInactiveException( String productCode )
	{
		super("Product of code [" + productCode + "] not found or inactive !" );
	}
}

