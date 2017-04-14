package com.halilkoca.business.services.reference;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.model.reference.Currency;

public interface CurrencyService {
	
	Currency getOne(int id_currency) throws SQLException;

	List<Currency> getAll() throws SQLException;

}
