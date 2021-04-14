package com.ashik.thymeleaf.currencydemo.controller;

import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashik.thymeleaf.currencydemo.entity.Currency;
import com.ashik.thymeleaf.currencydemo.exception.CurrencyResponseException;
import com.ashik.thymeleaf.currencydemo.exchanges.CurrencyRequest;
import com.ashik.thymeleaf.currencydemo.exchanges.CurrencyResponse;
import com.ashik.thymeleaf.currencydemo.service.CurrencyService;

/**
 * Controller class
 * implements API endpoints
 * 
 * 
 * @author Ashik
 *
 */

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;
	
	/**
	 * this method lists all currencies in the HTML page. fetches data from database
	 * @param theModel
	 * @return
	 */
	@GetMapping("/list")
	public String listCurrencies(Model theModel) {
		
		// get currencies from db
		List<Currency> currencyList = currencyService.findAll();
		
		// add to the spring model
		theModel.addAttribute("currencies", currencyList);
		
		return "currencies/list-currencies";
	}
	
	/**
	 * searches for the currency to be converted
	 * @param currencyName
	 * @param theModel
	 * @return
	 */
	@GetMapping("/search")
	public String search(@RequestParam("currencyName") String currencyName,
						 Model theModel) {
		
		if (currencyName.trim().isEmpty()) {
			return "redirect:currencies/list-currencies";
		}
		else {
			// else, search by currencyname
			Currency theCurrency =
							currencyService.searchBy(currencyName);
			
			// add to the spring model
			theModel.addAttribute("currency", currencyName);
			
			// send to list-currencies
			return "currencies/list-currencies";
		}
		
	}
	
	/**
	 * this method does the transaction by taking input currency from the user.
	 * outputs response object according to the transaction status.
	 * Keeps tracks of transaction with time stamp
	 * @param currencyRequest
	 * @return
	 */
	@PostMapping("/submit")
	public ResponseEntity<CurrencyResponse> getCurrencyResponse(@RequestBody @Valid CurrencyRequest currencyRequest) {
		
		String currencyName = currencyRequest.getCurrencyName();
		if(currencyName == null || currencyName.equals("")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		double currencyValue = currencyService.searchBy(currencyName.trim()).getCurrencyValue();
		try {
			return ResponseEntity.ok().body(new CurrencyResponse(currencyValue, LocalTime.now()));
		} catch(CurrencyResponseException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CurrencyResponse(currencyValue, LocalTime.now()));
		}
	}
	
	
}


















