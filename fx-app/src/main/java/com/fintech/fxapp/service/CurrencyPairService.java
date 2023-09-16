package com.fintech.fxapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.fxapp.Dao.CurrencyPairDao;
import com.fintech.fxapp.entity.CurrencyPair;
@Service
public class CurrencyPairService {
	@Autowired
	private  CurrencyPairDao currencyPairDao;

	public  void insertCurrencyPair(CurrencyPair currencyPair) {
		// TODO Auto-generated method stub
		currencyPairDao.insertCurrencyPair(currencyPair);
	}

	
}
