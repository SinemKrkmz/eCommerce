package com.halilkoca.business.services.gender;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.business.repository.gender.GenderRepositoryImpl;
import com.halilkoca.model.gender.Gender;

public class GenderServiceImpl implements GenderService{
	
	private GenderRepositoryImpl repository;

	
	public List<Gender> getAll() throws SQLException {
		repository = new GenderRepositoryImpl();
		return repository.findAll();
	}
	
	public static void main(String[] args){
		
	}

}
