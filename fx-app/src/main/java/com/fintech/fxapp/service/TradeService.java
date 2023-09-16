package com.fintech.fxapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.fxapp.Dao.TradeDao;
import com.fintech.fxapp.entity.Trade;
import com.fintech.fxapp.exception.InvalidInputException;

@Service
public class TradeService {

	private TradeDao tradeDao;

	@Autowired
	public TradeService(TradeDao tradeDao) {
		super();
		this.tradeDao = tradeDao;
	}

	public double currencyConvert(String currencyPairName, double amount) {

		double rate = tradeDao.getCurrencyPairRate(currencyPairName);
		if (rate > 0) {
			return amount * rate;
		} else {
			return 0;
		}

	}

	public boolean isValidName(String name) {
		if (name != null) {
			return name.matches("^[a-zA-Z\\s]+$");
		}
		return false;
	}

	public boolean isValidCurrency(double currency) {
		if (currency > 0) {
			return true;
		}
		return false;
	}

	public boolean isValidCurrencyPair(String currencyPairName) {
		if (currencyPairName.equalsIgnoreCase("usdinr")) {
			return true;
		}
		return false;
	}

	public String bookTrade(Trade trade) {

		if (isValidTrade(trade)) {
			double transferAmount = trade.getTransferAmount();
			String currencyPairName = trade.getCurrencyPair();
			double convertedAmount = currencyConvert(currencyPairName, transferAmount);

			trade.setConvertedAmount(convertedAmount);
			tradeDao.bookTrade(trade);

			return "Trade for " + currencyPairName + " has been booked with rate "+tradeDao.getCurrencyPairRate(currencyPairName)+"." +"The amount of Rs " +currencyPairName.substring(currencyPairName.length()-3)+ trade.getConvertedAmount()
					+ " will be transferred within 2 working days to " + trade.getName();
		} else {
			throw new InvalidInputException();
		}
	}

	private boolean isValidTrade(Trade trade) {

		return isValidName(trade.getName()) && isValidCurrency(trade.getTransferAmount())
				&& isValidCurrencyPair(trade.getCurrencyPair());
	}

	public List<Trade[]> printTrades() {

		return tradeDao.printTrades();
	}

}