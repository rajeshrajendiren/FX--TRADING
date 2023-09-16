package com.fintech.fxapp.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.fxapp.entity.CurrencyPair;
import com.fintech.fxapp.exception.CurrencyPairNullReferenceException;

@Repository
public class CurrencyPairDao {

	private SessionFactory sessionFactory;

	@Autowired
	public CurrencyPairDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void insertCurrencyPair(CurrencyPair currencyPair) {

		Session session = sessionFactory.openSession();
		session.save(currencyPair);
		session.beginTransaction().commit();
		session.close();

	}

}
