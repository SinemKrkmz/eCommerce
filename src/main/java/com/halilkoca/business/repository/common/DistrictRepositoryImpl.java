package com.halilkoca.business.repository.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.halilkoca.business.util.MySQLConnection;
import com.halilkoca.model.common.City;
import com.halilkoca.model.common.District;
import com.mysql.jdbc.PreparedStatement;

public class DistrictRepositoryImpl implements DistrictRepository{
	
	private District district;
	private City city;

	@Override
	public District findOne(int id_district) throws SQLException {

		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT * FROM district di "
				+ "LEFT JOIN city ci ON di.id_city=co.id_city"
				+ "WHERE id_district = ?";
		PreparedStatement ps = null;

		try {

			
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, id_district);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				district = new District();
				district.setName(rs.getString("name"));
				
				city = new City();
				city.setId_city(rs.getInt("id_city"));
				city.setName(rs.getString("ci.name"));
				district.setCity(city);				

			}
			connection.close();
			return district;

		} catch (SQLException ex) {

			ex.printStackTrace();

		}finally{

			if (ps != null) {
				ps.close();
			}

			if (connection != null) {
				connection.close();
			}
		}		
		
		return null;
	}

	@Override
	public void addDistrict(District district) throws SQLException {
		System.out.println("İlçe ekleme işlemi yapılamadı.");
	}

	@Override
	public void updateDistrict(District district) throws SQLException {
		System.out.println("İlçe güncelleme işlemi yapılamadı.");
	}

	@Override
	public void deleteDistrict(int id_district) throws SQLException {
		System.out.println("İlçe silme işlemi yapılamadı.");
	}

	@Override
	public List<District> findWithCityAll(int id_city) throws SQLException {

		List<District> districts = new ArrayList<District>();
		
		ResultSet rs;
		int rows = 0;
		Connection connection = MySQLConnection.getConnection();
		PreparedStatement ps = null;
		try {

			String query = "SELECT COUNT(id_district) FROM district WHERE id_city=" + id_city;
			ps = (PreparedStatement) connection.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				rows = rs.getInt(1);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		int START = 0;
		int END = 0;

		try {

			rs = null;
			
			for (int i = 1; i <= rows; i++) {

				START = END;
				END = i * 100;

				String query = "SELECT * FROM district di "
						+ "LEFT JOIN city ci ON di.id_city=ci.id_city "
						+ "WHERE di.id_city=? "
						+ "LIMIT " + START + "," + END;
				
				ps = (PreparedStatement) connection.prepareStatement(query);
				ps.setInt(1, id_city);
				rs = ps.executeQuery();

				while (rs.next()) {
					
					district = new District();
					
					district.setId_district(rs.getInt("id_district"));
					district.setName(rs.getString("name"));
					
					// city inner join
					city = new City();
					city.setId_city(rs.getInt("id_city"));
					city.setName(rs.getString("ci.name"));
					district.setCity(city);
					
					districts.add(district);
				}

			}
			rs.close();
			connection.close();

			return districts;

		} catch (SQLException ex) {
			
			ex.printStackTrace();
			
		}finally{

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
//		List<District> districts = new ArrayList<>();
//		DistrictRepositoryImpl dist = new DistrictRepositoryImpl();
//		districts = dist.findWithCityAll(48);
//		
//		for (District district : districts) {
//			System.out.println(district.getId_district() + " \t" + district.getName() + " \t" + district.getCity().getName());
//			
//		}
		
		
	}
	

}
