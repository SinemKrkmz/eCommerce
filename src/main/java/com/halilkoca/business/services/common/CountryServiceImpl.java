package com.halilkoca.business.services.common;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.business.repository.common.CountryRepositoryImpl;
import com.halilkoca.model.common.Country;

public class CountryServiceImpl implements CountryService{

	CountryRepositoryImpl repository = new CountryRepositoryImpl();
	
	@Override
	public Country getOne(int id_country) throws SQLException {

		return repository.findOne(id_country);
	}

	@Override
	public void addCountry(Country country) throws SQLException {
		repository.addCountry(country);
	}

	@Override
	public void updateCountry(Country country) throws SQLException {
		repository.updateCountry(country);
	}

	@Override
	public void deleteCountry(int id_country) throws SQLException {
		repository.deleteCountry(id_country);
	}

	@Override
	public List<Country> getAll() throws SQLException {
		return repository.findAll();
	}

}
