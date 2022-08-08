package com.pbs.challenge.finantial.manualmovements.domain.service.exceptions;

public class ProductCosifNotFoundOrInactiveException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8900929462581461813L;

	public ProductCosifNotFoundOrInactiveException( String cosifCode, String productCode )
	{
		super("ProductCosif of code [" + cosifCode + "], productCode [" + productCode + "] not found or inactive !" );
	}

	public ProductCosifNotFoundOrInactiveException( String productCode )
	{
		super("ProductCosif for productCode [" + productCode + "] not found or inactive !" );
	}
	
}

