package com.halilkoca.business.repository.gender;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.halilkoca.business.util.MySQLConnection;
import com.halilkoca.model.gender.Gender;
import com.mysql.jdbc.PreparedStatement;

public class GenderRepositoryImpl implements GenderRepository{

	public List<Gender> findAll() throws SQLException {
		List<Gender> genders;
		Gender gender;
		ResultSet rs;
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			genders = new ArrayList<Gender>();
			connection = MySQLConnection.getConnection();
			String query = "SELECT * FROM gender";
			ps = (PreparedStatement) connection.prepareStatement(query);				
			rs = ps.executeQuery();
			
			while (rs.next()) {
				gender = new Gender();
				gender.setId_gender(rs.getInt("id_gender"));
				gender.setName(rs.getString("name"));
				genders.add(gender);
			}


			rs.close();
			connection.close();

			return genders;

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally{

			if (ps != null) {
				ps.close();
			}

			if (connection != null) {
				connection.close();
			}
		}

		return null;
	}
	
	public static void main(String[] args) throws SQLException{
		
//		GenderRepositoryImpl gender = new GenderRepositoryImpl();
//		for (Gender gende : gender.findAll()) {
//			System.out.println(gende.getId_gender());
//			System.out.println(gende.getName());
//		}
//		
//		String e = "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92";
//		System.out.println(e.length());
		
	}

}
