package com.halilkoca.business.repository.reference;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.halilkoca.business.util.MySQLConnection;
import com.halilkoca.model.reference.Currency;
import com.mysql.jdbc.PreparedStatement;

public class CurrencyRepositoryImpl implements CurrencyRepository{
	
	private Currency currency;	
	List<Currency> currencies;

	@Override
	public Currency findOne(int id_currency) throws SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT * FROM currency"
				+ "WHERE id_currency = ?";
		PreparedStatement ps = null;

		try {

			
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, id_currency);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				currency = new Currency();
				currency.setName(rs.getString("name"));
				currency.setIso_code(rs.getString("iso_code"));
				currency.setConversion_rate(rs.getDouble("conversion_rate"));
				currency.setActive(rs.getInt("active"));

			}
			connection.close();
			return currency;

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
	public List<Currency> findAll() throws SQLException {
		currencies = new ArrayList<Currency>();
		
		ResultSet rs;
		int rows = 0;
		Connection connection = MySQLConnection.getConnection();
		PreparedStatement ps = null;
		try {

			String query = "SELECT COUNT(id_currency) FROM currencies";
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

				String query = "SELECT * FROM currency "
						+ "LIMIT " + START + "," + END;
				
				ps = (PreparedStatement) connection.prepareStatement(query);				
				rs = ps.executeQuery();

				while (rs.next()) {
					
					currency = new Currency();
					currency.setId_currency(rs.getInt("id_currency"));
					currency.setName(rs.getString("name"));
					currency.setIso_code(rs.getString("iso_code"));
					currency.setConversion_rate(rs.getDouble("conversion_rate"));
					currency.setActive(rs.getInt("active")); 
					
					currencies.add(currency);
				}

			}
			rs.close();
			connection.close();

			return currencies;

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

}
