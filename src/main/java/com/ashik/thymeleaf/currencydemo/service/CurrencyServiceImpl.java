package com.ashik.thymeleaf.currencydemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashik.thymeleaf.currencydemo.dao.CurrencyRepository;
import com.ashik.thymeleaf.currencydemo.entity.Currency;

/**
 * this class acts as a service layer in respect to MVCS architecture
 * 
 * @author Ashik
 *
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

	private CurrencyRepository employeeRepository;
	
	@Autowired
	public CurrencyServiceImpl(CurrencyRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Currency> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Currency searchBy(String currencyName) {
		return employeeRepository.findByNameContainsAllIgnoreCase(currencyName);
	}
	
}






