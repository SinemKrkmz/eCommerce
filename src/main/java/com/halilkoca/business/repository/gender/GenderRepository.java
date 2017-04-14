package com.halilkoca.business.repository.gender;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.model.gender.Gender;

public interface GenderRepository {
	
	List<Gender> findAll() throws SQLException;
	
}
