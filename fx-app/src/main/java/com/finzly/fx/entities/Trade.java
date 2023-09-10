package com.finzly.fx.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Trade {

	@Id
	private int tradeNo;
	private String name;
	private String currencyPair;
	private double transferAmount;
	private double convertedAmount;

	public Trade() {

	}

	public int getTradeno() {
		return tradeNo;
	}

	public void setTradeno(int tradeno) {
		this.tradeNo = tradeno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	@Override
	public String toString() {
		return "Trade [tradeNo=" + tradeNo + ", name=" + name + ", currencyPair=" + currencyPair + ", transferAmount="
				+ transferAmount + "]";
	}

}
