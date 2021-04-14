package com.ashik.thymeleaf.currencydemo.service;

import java.util.List;

import com.ashik.thymeleaf.currencydemo.entity.Currency;

/**
 * this is the interface for service layer
 * @author Ashik
 *
 */
public interface CurrencyService {

	//returns all the currencies in the database
	public List<Currency> findAll();
	
	//searches for a particular currency to be converted
	public Currency searchBy(String currencyName);
		
}
