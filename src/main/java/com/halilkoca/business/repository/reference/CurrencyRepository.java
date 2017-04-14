package com.halilkoca.business.repository.reference;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.model.reference.Currency;

public interface CurrencyRepository {
	
	Currency findOne(int id_currency) throws SQLException;
	
	List<Currency> findAll() throws SQLException;

}
