package com.ashik.thymeleaf.currencydemo.exception;

/**
 * Custom exception in case of invalid response
 * 
 * @author Ashik
 *
 */
public class CurrencyResponseException extends RuntimeException{
	
	public CurrencyResponseException() {
		
	}
	
	CurrencyResponseException(String message) {
		super(message);
	}

}
