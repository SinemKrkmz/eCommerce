package com.halilkoca.business.services.gender;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.model.gender.Gender;

public interface GenderService {
	
	List<Gender> getAll() throws SQLException;
	
	

}
