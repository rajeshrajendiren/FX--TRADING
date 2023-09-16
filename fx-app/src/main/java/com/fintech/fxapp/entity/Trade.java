package com.fintech.fxapp.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trade")
public class Trade {
	@Id
	@Column(name="TradeNo")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int tradeNo;
	@Column(name="CurrencyPair")
	private String currencyPair;
	@Column(name="CustomerName")
	private String name;
	@Column(name="Amount")
	private double convertedAmount;
	private double transferAmount;
	
	public Trade() {

	}



	public Trade(int tradeNo, String currencyPair, String name,  double transferAmount) {
		super();
		this.tradeNo = tradeNo;
		this.currencyPair = currencyPair;
		this.name = name;
		this.convertedAmount = convertedAmount;
		this.transferAmount = transferAmount;
	}



	public long getTradeno() {
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