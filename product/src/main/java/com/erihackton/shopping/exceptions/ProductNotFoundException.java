package com.erihackton.shopping.exceptions;

/**
*  the global Exception class handles  error
*/

public class ProductNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException(String message) {
		super(message);
	}

}
