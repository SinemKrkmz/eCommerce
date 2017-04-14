package com.halilkoca.business.services.reference;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.business.repository.reference.CurrencyRepositoryImpl;
import com.halilkoca.model.reference.Currency;

public class CurrencyServiceImpl implements CurrencyService{

	private CurrencyRepositoryImpl repository;
	
	@Override
	public Currency getOne(int id_currency) throws SQLException {
		return repository.findOne(id_currency);
	}

	@Override
	public List<Currency> getAll() throws SQLException {
		return repository.findAll();
	}

}
