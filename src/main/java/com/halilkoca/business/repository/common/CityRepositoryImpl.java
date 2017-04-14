package com.halilkoca.business.repository.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.halilkoca.business.util.MySQLConnection;
import com.halilkoca.model.common.City;
import com.halilkoca.model.common.Country;
import com.mysql.jdbc.PreparedStatement;

public class CityRepositoryImpl implements CityRepository{
	
	private City city;
	private Country country;

	@Override
	public City findOne(int id_city) throws SQLException {
		
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT * FROM city ci "
				+ "LEFT JOIN country co ON ci.id_country=co.id_country"
				+ "WHERE id_city = ?";
		PreparedStatement ps = null;

		try {

			
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, id_city);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				city = new City();
				city.setId_city(rs.getInt("id_city"));
				city.setName(rs.getString("name"));
				city.setLicense_plate_no(rs.getString("licence_plate_no"));
				
				country = new Country();
				country.setId_country(rs.getInt("id_country"));
				country.setName(rs.getString("ci.name"));
				city.setCountry(country);

			}
			connection.close();
			return city;

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
	public void addCity(City city) throws SQLException {
		
		Connection connection = null;
		PreparedStatement ps = null;

		String query = "INSERT INTO `city` "
				+ "(`id_country`, `name`, `license_plate_no`) "
				+ "VALUES "
				+ "(?, ?, ?)";
		
		
		try {
			
			connection = MySQLConnection.getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
			
			ps.setInt(1, city.getCountry().getId_country());
			ps.setString(2, city.getName());
			ps.setString(3, city.getLicense_plate_no());
			
			
			ps.executeUpdate();
			connection.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{

			if (ps != null) {
				ps.close();
			}

			if (connection != null) {
				connection.close();
			}
		}
		
	}

	@Override
	public void updateCity(City city) throws SQLException {

		Connection connection = null;
		PreparedStatement ps = null;

		String query = "UPDATE `city` "
				+ "SET `id_country` = ?, `name` = ?, "
				+ "`license_plate_no` = ? "
				+ "WHERE `city`.`id_city` = ?";
		
		
		try {
			
			connection = MySQLConnection.getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
			
			ps.setInt(1, city.getCountry().getId_country());
			ps.setString(2, city.getName());
			ps.setString(3, city.getLicense_plate_no());
			ps.setInt(4, city.getId_city());			
			
			ps.executeUpdate();
			connection.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{

			if (ps != null) {
				ps.close();
			}

			if (connection != null) {
				connection.close();
			}
		}
		
	}

	@Override
	public void deleteCity(int id_city) throws SQLException {
		System.out.println("Silme işlemi yapılmamaktadır.");
	}

	@Override
	public List<City> findWithCountryAll(int id_country) throws SQLException {
		
		List<City> cities = new ArrayList<City>();
		
		ResultSet rs;
		int rows = 0;
		Connection connection = MySQLConnection.getConnection();
		PreparedStatement ps = null;
		try {

			String query = "SELECT COUNT(id_city) FROM city WHERE id_country=" + id_country;
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

				String query = "SELECT * FROM city ci "
						+ "LEFT JOIN country co ON co.id_country=ci.id_country "
						+ "WHERE co.id_country=? "
						+ "LIMIT " + START + "," + END;
				
				ps = (PreparedStatement) connection.prepareStatement(query);
				ps.setInt(1, id_country);
				rs = ps.executeQuery();

				while (rs.next()) {
					
					city = new City();
					city.setId_city(rs.getInt("id_city"));
					city.setName(rs.getString("name"));
					city.setLicense_plate_no(rs.getString("license_plate_no"));
					
					country = new Country();
					country.setId_country(rs.getInt("id_country"));
					country.setName(rs.getString("co.name"));
					city.setCountry(country);
					
					cities.add(city);
				}

			}
			rs.close();
			connection.close();

			return cities;

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
//		List<City> cities = new ArrayList<>();
//		CityRepositoryImpl dist = new CityRepositoryImpl();
//		cities = dist.findWithCountryAll(1);
//		
//		for (City city : cities) {
//			System.out.println(city.getId_city() + " " + city.getName() + " " + city.getCountry().getName());
//		}
//		
	}	

}
