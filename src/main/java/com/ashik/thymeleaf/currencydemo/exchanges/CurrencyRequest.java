package com.ashik.thymeleaf.currencydemo.exchanges;

import javax.validation.constraints.NotNull;

/**
 * POJO class for currencyRequest
 * 
 * @author Ashik
 *
 */
public class CurrencyRequest {
	
	@NotNull
	private int currencyId;
	
	@NotNull
	private String currencyType;

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyName() {
		return currencyType;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyType = currencyName;
	}
	
	

}
