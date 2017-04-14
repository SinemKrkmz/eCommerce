package com.halilkoca.business.repository.common;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.model.common.District;

public interface DistrictRepository {
	
	District findOne(int id_district) throws SQLException;

	void addDistrict(District district) throws SQLException;

	void updateDistrict(District district) throws SQLException;

	void deleteDistrict(int id_district) throws SQLException;

	List<District> findWithCityAll(int id_city) throws SQLException;
}
