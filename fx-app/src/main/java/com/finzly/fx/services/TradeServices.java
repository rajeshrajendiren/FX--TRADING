package com.finzly.fx.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.finzly.fx.entities.Trade;

@Service
public class TradeServices {
	private List<Trade> tradelist = new ArrayList<>();
	private double usdInr = 66;
	private int tradeId = 1;

	public double currencyConvert(double amount) {
		return amount * usdInr;

	}

	public boolean isValidName(String name) {
		if (name.matches("^[a-zA-Z\\s]+$")) {
			return true;
		}
		return false;
	}

	public boolean isValidCurrency(double currency) {
		if (currency > 0) {
			return true;
		}
		return false;
	}

	public boolean isValidCurrencyPair(String currencypair) {
		if (currencypair.equalsIgnoreCase("usdinr")) {
			return true;
		}
		return false;
	}

	public String bookTrade(Trade trade) {
		System.out.println("service called");

		if (isValidName(trade.getName()) && isValidCurrency(trade.getTransferAmount())
				&& isValidCurrencyPair(trade.getCurrencyPair())) {
			trade.setTradeno(tradeId++);
			System.out.println(trade.toString());
			trade.setConvertedAmount(currencyConvert(trade.getTransferAmount()));
			tradelist.add(trade);
			return "Trade for USDINR booked with rate " + usdInr + "," + " The amount of Rs "
					+ trade.getConvertedAmount() + " will be transfered within 2 working days to " + trade.getName();

		} else {
			return "invalid input";
		}

	}

	public List<Trade> printTrade() {

		return tradelist;
	}

}
