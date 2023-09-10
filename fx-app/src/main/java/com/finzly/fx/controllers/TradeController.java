package com.finzly.fx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fx.entities.Trade;
import com.finzly.fx.services.TradeServices;

@RestController
@RequestMapping("/api")
public class TradeController {

	@Autowired
	TradeServices services;

	// to create a trade
	@PostMapping("/booktrade")
	public String createTrade(@RequestBody Trade trade) {
		//
		String tr = services.bookTrade(trade);

		return tr;
	}

	@GetMapping("/showalltrade")
	public List<Trade> getTrade() {
		return services.printTrade();
	}

}