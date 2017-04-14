package com.halilkoca.business.services.common;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.model.common.Country;

public interface CountryService {
	
	Country getOne(int id_country) throws SQLException;

	void addCountry(Country country) throws SQLException;

	void updateCountry(Country country) throws SQLException;

	void deleteCountry(int id_country) throws SQLException;
	
	List<Country> getAll() throws SQLException;

}
