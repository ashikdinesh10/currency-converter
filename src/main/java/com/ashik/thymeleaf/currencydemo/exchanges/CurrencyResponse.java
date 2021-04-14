package com.ashik.thymeleaf.currencydemo.exchanges;

import java.time.LocalTime;

/**
 * This is the response class for the completed transaction
 * 
 * @author Ashik
 *
 */
public class CurrencyResponse {

	private double convertedValue;
	
	private LocalTime timeStamp;
	
	public CurrencyResponse() {
		
	}

	public CurrencyResponse(double convertedValue, LocalTime timeStamp) {
		this.convertedValue = convertedValue;
		this.timeStamp = timeStamp;
	}

	public double getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(double convertedValue) {
		this.convertedValue = convertedValue;
	}

	public LocalTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
