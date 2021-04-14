package com.ashik.thymeleaf.currencydemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * entity class for holding currency in database
 * 
 * @author Ashik
 *
 */
@Entity
@Table(name="currency")
public class Currency {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="currency_type")
	private String currencyType;
	
	@Column(name="currency_value")
	private double currencyValue;
	// define constructors
	
	public Currency() {
		
	}
	
	public Currency(int currencyId, String currencyType, double currencyValue) {
		this.id = currencyId;
		this.currencyType = currencyType;
		this.currencyValue = currencyValue;
	}


	public Currency(String currencyType) {
		this.currencyType = currencyType;
	}

	// define getter/setter
	
	public double getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(double currencyValue) {
		this.currencyValue = currencyValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}


	@Override
	public String toString() {
		return "Currency [id=" + id + ", currencyType=" + currencyType + "]";
	}
		
}











