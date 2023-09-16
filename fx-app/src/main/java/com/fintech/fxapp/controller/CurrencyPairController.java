package com.fintech.fxapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.fxapp.entity.CurrencyPair;
import com.fintech.fxapp.service.CurrencyPairService;

@RestController
public class CurrencyPairController {

	private CurrencyPairService currencyPairService;

	@Autowired
	public CurrencyPairController(CurrencyPairService currencyPairService) {
		super();
		this.currencyPairService = currencyPairService;
	}

	private static final Logger logger = LoggerFactory.getLogger(CurrencyPairController.class);

	@PostMapping("/insert-currency-pair")
	public void insertCurrencyPair(@RequestBody CurrencyPair currencyPair) {
		try {
			if (currencyPair != null) {
				currencyPairService.insertCurrencyPair(currencyPair);
				logger.info("currencyPair inserted Successfully");

			}

		} catch (Exception e) {
			logger.info("currencyPair is null");
		}
	}
}
