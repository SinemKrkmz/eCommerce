package com.halilkoca.business.repository.common;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.model.common.Country;

public interface CountryRepository {

	Country findOne(int id_country) throws SQLException;

	void addCountry(Country country) throws SQLException;

	void updateCountry(Country country) throws SQLException;

	void deleteCountry(int id_country) throws SQLException;
	
	List<Country> findAll() throws SQLException;

}
