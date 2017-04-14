package com.halilkoca.business.repository.customer;

import java.util.ArrayList;
import java.util.List;

import com.halilkoca.business.util.MySQLConnection;
import com.halilkoca.model.customer.Customer;
import com.halilkoca.model.gender.Gender;
import com.mysql.jdbc.PreparedStatement;


import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CustomerRepository {

	
	public Customer findOne(int id_customer) throws SQLException {

		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT * FROM customer c INNER JOIN gender g ON c.id_gender=g.id_gender WHERE id_customer=?";
		PreparedStatement ps = null;

		try {
			Customer customer = null;
			Gender gender = null;
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, id_customer);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				customer = new Customer();
				gender = new Gender();

				customer.setFirstName(rs.getString("firstname"));
				customer.setLastName(rs.getString("lastname"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setCompany(rs.getString("company"));
				customer.setBirthday(rs.getDate("birthday"));
				customer.setNewsletter(rs.getInt("newsletter"));
				customer.setIpRegistrationNewsletter(rs.getString("ip_registration_newsletter"));
				customer.setWebsite(rs.getString("website"));
				customer.setOutstandingAllowAmount(rs.getDouble("outstanding_allow_amount"));
				customer.setShowPublicPrices(rs.getInt("show_public_prices"));
				customer.setMaxPaymentDays(rs.getInt("max_payment_days"));
				customer.setSecureKey(rs.getString("secure_key"));
				customer.setNote(rs.getString("note"));
				customer.setActive(rs.getInt("active"));
				customer.setIsGuest(rs.getInt("isguest"));
				customer.setDateAdded(rs.getDate("date_added"));
				customer.setDateUpdated(rs.getDate("date_updated"));
				customer.setPhoneMobile(rs.getString("phonemobile"));

				// inner join
				gender.setName(rs.getString("g.name"));
				gender.setId_gender(rs.getInt("g.id_gender"));
				customer.setGender(gender);

			}
			connection.close();
			return customer;

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

	
	public List<Customer> findByName(String firstname) throws SQLException {

		List<Customer> customers = new ArrayList<Customer>();
		Gender gender = new Gender();
		ResultSet rs;
		int rows = 0;
		Connection connection = MySQLConnection.getConnection();
		PreparedStatement ps = null;
		try {

			String query = "SELECT COUNT(firstname) FROM customer";
			ps = (PreparedStatement) connection.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				rows = rs.getInt(1);
			}

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

		int START = 0;
		int END = 0;

		try {

			rs = null;
			for (int i = 1; i <= rows; i++) {

				START = END;
				END = i * 100;

				String query = "SELECT * FROM customer c " + "INNER JOIN gender g ON c.id_gender=g.id_gender "
						+ "WHERE firstname=? " + "LIMIT " + START + "," + END;
				ps = (PreparedStatement) connection.prepareStatement(query);
				ps.setString(1, firstname);
				rs = ps.executeQuery();

				while (rs.next()) {
					Customer customer = new Customer();
					gender = new Gender();

					customer.setFirstName(rs.getString("firstname"));
					customer.setLastName(rs.getString("lastname"));
					customer.setEmail(rs.getString("email"));
					customer.setUsername(rs.getString("username"));
					customer.setCompany(rs.getString("company"));
					customer.setBirthday(rs.getDate("birthday"));
					customer.setPhoneMobile(rs.getString("phonemobile"));
					customer.setNewsletter(rs.getInt("newsletter"));
					customer.setIpRegistrationNewsletter(rs.getString("ip_registration_newsletter"));
					customer.setWebsite(rs.getString("website"));
					customer.setOutstandingAllowAmount(rs.getDouble("outstanding_allow_amount"));
					customer.setShowPublicPrices(rs.getInt("show_public_prices"));
					customer.setMaxPaymentDays(rs.getInt("max_payment_days"));
					customer.setSecureKey(rs.getString("secure_key"));
					customer.setNote(rs.getString("note"));
					customer.setActive(rs.getInt("active"));
					customer.setIsGuest(rs.getInt("isguest"));
					customer.setDateAdded(rs.getDate("date_added"));
					customer.setDateUpdated(rs.getDate("date_updated"));

					// inner join
					customer.setGender(gender);
					gender.setName(rs.getString("g.name"));
					gender.setId_gender(rs.getInt("g.id_gender"));

					customers.add(customer);
				}

			}
			rs.close();
			connection.close();

			return customers;

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
	


	@Override
	public Customer findOneByUsername(String username) throws SQLException {
		
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT id_customer FROM customer WHERE username=?";
		PreparedStatement ps = null;

		try {
			Customer customer = null;
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				customer = new Customer();
				customer.setIdCustomer(rs.getInt("id_customer"));

			}
			connection.close();
			return customer;

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
	
	
	
	public void addCustomer(Customer customer) throws SQLException{
		
		
		
		Connection connection = null;
		PreparedStatement ps = null;

		String query = "INSERT INTO `customer` (`id_gender`, `username`, `firstname`, "
				+ "`lastname`, `email`, `password`, `last_pass_generated`, `company`, `birthday`, "
				+ "`phonemobile`, `newsletter`, `ip_registration_newsletter`, `newsletter_date_add`, "
				+ "`website`, `outstanding_allow_amount`, `show_public_prices`, `max_payment_days`, "
				+ "`secure_key`, `note`, `active`, `isguest`, `deleted`, `date_added`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, ?, ?, ?, "
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			connection = MySQLConnection.getConnection();
					

			ps = (PreparedStatement) connection.prepareStatement(query);
			
			ps.setInt(1, customer.getGender().getId_gender());
			ps.setString(2, customer.getUsername());
			ps.setString(3, customer.getFirstName());
			ps.setString(4, customer.getLastName());
			ps.setString(5, customer.getEmail());
			ps.setString(6, customer.getPassword());
			ps.setString(7, customer.getCompany());
			ps.setDate(8, new java.sql.Date(customer.getBirthday().getTime()));
			ps.setString(9, customer.getPhoneMobile());
			ps.setInt(10, customer.getNewsletter());
			ps.setString(11, customer.getIpRegistrationNewsletter());
			ps.setDate(12, new java.sql.Date(customer.getNewsletterDateAdd().getTime()));
			ps.setString(13, customer.getWebsite());
			ps.setDouble(14, customer.getOutstandingAllowAmount());
			ps.setInt(15, customer.getShowPublicPrices());
			ps.setInt(16, customer.getMaxPaymentDays());
			ps.setString(17, customer.getSecureKey());
			ps.setString(18, customer.getNote());
			ps.setInt(19, customer.getActive());
			ps.setInt(20, customer.getActive());
			ps.setInt(21, customer.getDeleted());
			ps.setDate(22, new java.sql.Date(customer.getDateAdded().getTime()));
			
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

	
	public void updateCustomer(Customer customer) throws SQLException {

		Connection connection = null;
		PreparedStatement ps = null;

		String query = "UPDATE `customer` SET(`id_gender` = ?, `username` = ?, `firstname` = ?, "
				+ "`lastname` = ?, `email` = ?, `password` = ?, `company` = ?, `birthday` = ?, `phonemobile` = ?, "
				+ "`newsletter` = ?, `ip_registration_newsletter` = ?, `newsletter_date_add` = ?, "
				+ "`website` = ?, `outstanding_allow_amount` = ?, `show_public_prices` = ?, `max_payment_days` = ?, "
				+ "`secure_key` = ?, `note` = ?, `active` = ?, `isguest` = ?, `deleted` = ?, `date_added` = ?) WHERE id_customer= ?";
		
		try {
			
			connection = MySQLConnection.getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
			
			ps.setInt(1, customer.getGender().getId_gender());
			ps.setString(2, customer.getUsername());
			ps.setString(3, customer.getFirstName());
			ps.setString(4, customer.getLastName());
			ps.setString(5, customer.getEmail());
			ps.setString(6, customer.getPassword());
			ps.setString(7, customer.getCompany());
			ps.setDate(8, (java.sql.Date) customer.getBirthday());
			ps.setString(9, customer.getPhoneMobile());
			ps.setInt(10, customer.getNewsletter());
			ps.setString(11, customer.getIpRegistrationNewsletter());
			ps.setDate(12, (java.sql.Date) customer.getNewsletterDateAdd());
			ps.setString(13, customer.getWebsite());
			ps.setDouble(14, customer.getOutstandingAllowAmount());
			ps.setInt(15, customer.getShowPublicPrices());
			ps.setInt(16, customer.getMaxPaymentDays());
			ps.setString(17, customer.getSecureKey());
			ps.setString(18, customer.getNote());
			ps.setInt(19, customer.getActive());
			ps.setInt(20, customer.getIsGuest());
			ps.setInt(21, customer.getDeleted());
			ps.setDate(22, (java.sql.Date) customer.getDateAdded());
			ps.setInt(23, customer.getIdCustomer());
			
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

	
	public void deleteCustomer(int id_customer) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;

		String query = "UPDATE `customer` SET `deleted` = ? WHERE `customer`.`id_customer` = ? ";
		
		try {
			
			connection = MySQLConnection.getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
			
			ps.setInt(1, 1);
			ps.setInt(2, id_customer);
			
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

	
	public List<Customer> findAll() throws SQLException {
		List<Customer> customers = new ArrayList<Customer>();
		Gender gender = new Gender();
		ResultSet rs;
		int rows = 0;
		Connection connection = MySQLConnection.getConnection();
		PreparedStatement ps = null;
		try {

			String query = "SELECT COUNT(firstname) FROM customer";
			ps = (PreparedStatement) connection.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				rows = rs.getInt(1);
			}
//			System.out.println(rows);

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

				String query = "SELECT * FROM customer c " + "INNER JOIN gender g ON c.id_gender=g.id_gender "
						+ "LIMIT " + START + "," + END;
				ps = (PreparedStatement) connection.prepareStatement(query);				
				rs = ps.executeQuery();

				while (rs.next()) {
					Customer customer = new Customer();
					gender = new Gender();

					customer.setIdCustomer(rs.getInt("id_customer"));
					customer.setFirstName(rs.getString("firstname"));
					customer.setLastName(rs.getString("lastname"));
					customer.setEmail(rs.getString("email"));
					customer.setUsername(rs.getString("username"));
					customer.setCompany(rs.getString("company"));
					customer.setBirthday(rs.getDate("birthday"));
					customer.setPhoneMobile(rs.getString("phonemobile"));
					customer.setNewsletter(rs.getInt("newsletter"));
					customer.setIpRegistrationNewsletter(rs.getString("ip_registration_newsletter"));
					customer.setWebsite(rs.getString("website"));
					customer.setOutstandingAllowAmount(rs.getDouble("outstanding_allow_amount"));
					customer.setShowPublicPrices(rs.getInt("show_public_prices"));
					customer.setMaxPaymentDays(rs.getInt("max_payment_days"));
					customer.setSecureKey(rs.getString("secure_key"));
					customer.setNote(rs.getString("note"));
					customer.setActive(rs.getInt("active"));
					customer.setIsGuest(rs.getInt("isguest"));
					customer.setDateAdded(rs.getDate("date_added"));
					customer.setDateUpdated(rs.getDate("date_updated"));

					// inner join
					customer.setGender(gender);
					gender.setName(rs.getString("g.name"));
					gender.setId_gender(rs.getInt("g.id_gender"));

					customers.add(customer);
				}

			}
			rs.close();
			connection.close();

			return customers;

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
	
	@Override
	public boolean checkUsername(String username) throws SQLException {
				
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT username FROM customer WHERE username=?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, username);
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		}
		
		return false;
	}	
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException, SQLException {
		CustomerRepositoryImpl cus = new CustomerRepositoryImpl();
		// System.out.println(cus.findOne(2).getGender().getName());
		// System.out.println(cus.findOne(2).getGender().getId_gender());
		// System.out.println(cus.findOne(2).getFirstName());

		// List<Customer> cust = cus.findByName("halil");
		// for (Customer customer : cust) {
		// System.out.println(customer.getFirstName());
		// System.out.println(customer.getLastName());
		// System.out.println(customer.getEmail());
		// System.out.println(customer.getGender().getName());
		// }
		
//		for (Customer cust : cus.findAll()) {
//			System.out.println(cust.getFirstName());
//		}
		
//		System.out.println(cus.checkUsername("fat"));

	}





}
