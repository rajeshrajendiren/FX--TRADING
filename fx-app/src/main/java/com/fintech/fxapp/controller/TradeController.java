package com.fintech.fxapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.fxapp.entity.Trade;
import com.fintech.fxapp.service.TradeService;

@RestController
@RequestMapping("/api")
public class TradeController {

	TradeService tradeService;
	@Autowired
	public TradeController(TradeService tradeService) {
		this.tradeService=tradeService;
	}
	

	@PostMapping("/booktrade")
	public String createTrade(@RequestBody Trade trade) {
		return tradeService.bookTrade(trade);
	}

	@GetMapping("/showalltrade")
	public List<Trade[]> getTrade() {
		return tradeService.printTrades();
	}

}
