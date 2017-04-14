package com.halilkoca.business.repository.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.halilkoca.business.util.MySQLConnection;
import com.halilkoca.model.common.Country;
import com.halilkoca.model.reference.Currency;
import com.mysql.jdbc.PreparedStatement;

public class CountryRepositoryImpl implements CountryRepository{
	
	private Country country;
	private Currency currency;


	@Override
	public Country findOne(int id_country) throws SQLException {
		
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT * FROM country co "
				+ "LEFT JOIN currency cu ON co.id_country=cu.id_country"
				+ "WHERE id_country = ?";
		PreparedStatement ps = null;

		try {

			
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, id_country);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				country = new Country();
				
				country.setName(rs.getString("name"));
				country.setIso_code(rs.getString("iso_code"));
				country.setCall_prefix(rs.getString("call_prefix"));
				country.setActive(rs.getInt("active"));
				
				// currency inner join
				currency = new Currency();
				currency.setName(rs.getString("cu.name"));
				currency.setIso_code(rs.getString("iso_code"));
				currency.setConversion_rate(rs.getDouble("conversion_rate"));
				currency.setActive(rs.getInt("active"));
				country.setCurrency(currency);
				

			}
			connection.close();
			return country;

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
	public void addCountry(Country country) throws SQLException {
		
		Connection connection = null;
		PreparedStatement ps = null;

		String query = "INSERT INTO `country` "
				+ "(`id_currency`, `name`, `iso_code`, `call_prefix`, `active`) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		
		try {
			
			connection = MySQLConnection.getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
		
			ps.setInt(1, country.getCurrency().getId_currency());
			ps.setString(2, country.getName());
			ps.setString(3, country.getIso_code());
			ps.setString(4, country.getCall_prefix());
			ps.setInt(5, country.getActive());
			
			
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
	public void updateCountry(Country country) throws SQLException {
		
		Connection connection = null;
		PreparedStatement ps = null;

		String query = "UPDATE `country` SET "
				+ "`id_currency` = ?, `name` = ?, `iso_code` = ?, "
				+ "`call_prefix` = ?, `active` = ? "
				+ "WHERE `country`.`id_country` = ?";
		
		
		try {
			
			connection = MySQLConnection.getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
		
			ps.setInt(1, country.getCurrency().getId_currency());
			ps.setString(2, country.getName());
			ps.setString(3, country.getIso_code());
			ps.setString(4, country.getCall_prefix());
			ps.setInt(5, country.getActive());
			
			ps.setInt(6, country.getId_country());
			
			
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
	public void deleteCountry(int id_country) throws SQLException {
		
		Connection connection = null;
		PreparedStatement ps = null;

		String query = "UPDATE `country` SET `deleted` = ? WHERE `country`.`id_country` = ? ";
		
		try {
			
			connection = MySQLConnection.getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
			
			ps.setInt(1, 1);
			ps.setInt(2, id_country);
			
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
	public List<Country> findAll() throws SQLException {

		List<Country> countries = new ArrayList<Country>();
		
		ResultSet rs;
		int rows = 0;
		Connection connection = MySQLConnection.getConnection();
		PreparedStatement ps = null;
		try {

			String query = "SELECT COUNT(id_country) FROM country";
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

				String query = "SELECT * FROM country co "
						+ "LEFT JOIN currency cu ON co.id_country=co.id_country "	
						+ "LIMIT " + START + "," + END;
				
				ps = (PreparedStatement) connection.prepareStatement(query);				
				rs = ps.executeQuery();

				while (rs.next()) {
					
					country = new Country();
					country.setId_country(rs.getInt("id_country"));
					country.setName(rs.getString("name"));
					country.setIso_code(rs.getString("iso_code"));
					
					// currency inner join
					currency = new Currency();
					currency.setId_currency(rs.getInt("id_currency"));					
					country.setCurrency(currency);
					
					countries.add(country);
				}

			}
			rs.close();
			connection.close();

			return countries;

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
//		List<Country> districts = new ArrayList<>();
//		CountryRepositoryImpl dist = new CountryRepositoryImpl();
//		districts = dist.findAll();
//		
//		for (Country country : districts) {
//			System.out.println(country.getId_country() + " " + country.getName());
//		}
		
	}	

}
