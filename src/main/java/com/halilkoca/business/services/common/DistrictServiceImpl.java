package com.halilkoca.business.services.common;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.business.repository.common.DistrictRepositoryImpl;
import com.halilkoca.model.common.District;

public class DistrictServiceImpl implements DistrictService{

	DistrictRepositoryImpl repository = new DistrictRepositoryImpl();
	
	@Override
	public District getOne(int id_district) throws SQLException {
		return repository.findOne(id_district);
	}

	@Override
	public void addDistrict(District district) throws SQLException {
		repository.addDistrict(district);
	}

	@Override
	public void updateDistrict(District district) throws SQLException {
		repository.updateDistrict(district);
	}

	@Override
	public void deleteDistrict(int id_district) throws SQLException {
		repository.deleteDistrict(id_district);
	}

	@Override
	public List<District> getWithCityAll(int id_city) throws SQLException {
		return repository.findWithCityAll(id_city);
	}

}
