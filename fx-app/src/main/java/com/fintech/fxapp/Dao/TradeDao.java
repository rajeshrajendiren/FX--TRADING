package com.fintech.fxapp.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fintech.fxapp.entity.CurrencyPair;
import com.fintech.fxapp.entity.Trade;

@Repository
public class TradeDao {

	SessionFactory sessionFactory;

	@Autowired
	public TradeDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	public double getCurrencyPairRate(String currencyPairName) {
		Session session = sessionFactory.openSession();

		Criteria getCurrency = session.createCriteria(CurrencyPair.class);
		getCurrency.add(Restrictions.eq("currencyType", currencyPairName));
		CurrencyPair currency = (CurrencyPair) getCurrency.uniqueResult();
		double rate = currency.getExchangeRate();
		session.close();
		return rate;

	}

	public void bookTrade(Trade trade) {
		Session session = sessionFactory.openSession();

		session.save(trade);
		session.beginTransaction().commit();
		session.close();
	}

	public List<Trade[]> printTrades() {
		Session session = sessionFactory.openSession();
		NativeQuery<Trade[]> trades = session.createSQLQuery("SELECT trade_no,currency_pair,customer_name,amount from trade");
		return trades.list();

	}

	public boolean getCurrencyPairType(String currencyPairName) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CurrencyPair.class);
		criteria.add(Restrictions.eq("currencyType", currencyPairName));
		List<CurrencyPair> results = criteria.list();

		if (results != null) {
			return true;
		} else {

			return false;
		}

	}

}
