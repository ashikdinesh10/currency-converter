package com.ashik.thymeleaf.currencydemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashik.thymeleaf.currencydemo.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
	
	//  method to sort all currencies by type
	public List<Currency> findAllByOrderByLastNameAsc();

	//  method to search currency by type
	public Currency findByNameContainsAllIgnoreCase(
									String currencyName);
	
}
