package com.halilkoca.business.repository.common;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.model.common.City;

public interface CityRepository {

	City findOne(int id_city) throws SQLException;

	void addCity(City city) throws SQLException;

	void updateCity(City city) throws SQLException;

	void deleteCity(int id_city) throws SQLException;

	List<City> findWithCountryAll(int id_country) throws SQLException;

}
