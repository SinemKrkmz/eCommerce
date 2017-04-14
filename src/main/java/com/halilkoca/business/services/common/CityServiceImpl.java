package com.halilkoca.business.services.common;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.business.repository.common.CityRepositoryImpl;
import com.halilkoca.model.common.City;


public class CityServiceImpl  implements CityService{

	CityRepositoryImpl repository = new CityRepositoryImpl();
	
	@Override
	public City getOne(int id_city) throws SQLException {
		return repository.findOne(id_city);
	}

	@Override
	public void addCity(City city) throws SQLException {
		repository.addCity(city);
	}

	@Override
	public void updateCity(City city) throws SQLException {
		repository.updateCity(city);
	}

	@Override
	public void deleteCity(int id_city) throws SQLException {
		repository.deleteCity(id_city);
	}

	@Override
	public List<City> getWithCountryAll(int id_country) throws SQLException {
		return repository.findWithCountryAll(id_country);
	}


}
