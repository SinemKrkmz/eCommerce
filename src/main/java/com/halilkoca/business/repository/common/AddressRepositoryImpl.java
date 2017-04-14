package com.halilkoca.business.repository.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.halilkoca.business.util.MySQLConnection;
import com.halilkoca.model.catalog.product.manufacturer.Manufacturer;
import com.halilkoca.model.catalog.product.supplier.Supplier;
import com.halilkoca.model.common.Address;
import com.halilkoca.model.common.City;
import com.halilkoca.model.common.Country;
import com.halilkoca.model.common.District;
import com.halilkoca.model.customer.Customer;
import com.mysql.jdbc.PreparedStatement;

public class AddressRepositoryImpl implements AddressRepository{
	
	
	private Address address;
	private Customer customer;
	private Manufacturer manufacturer;
	private Supplier supplier;	
	private Country country;
	private City city;
	private District district;

	// find ONE customer address
	@Override
	public Address findCustomerOne(int id_customer) throws SQLException {
		

		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT * FROM address a "
				+ "LEFT JOIN customer c ON a.id_customer=c.id_customer "
				+ "LEFT JOIN country co ON a.id_country = co.id_country "
				+ "LEFT JOIN city ci ON a.id_city = ci.id_city "
				+ "LEFT JOIN district di ON a.id_district = di.id_district "
				+ "WHERE id_customer = ?";
		PreparedStatement ps = null;

		try {

			
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, id_customer);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				address = new Address();
				customer = new Customer();
				manufacturer = new Manufacturer();
				supplier = new Supplier();
				country = new Country();
				city = new City();
				district = new District();
				
				
				// customer inner join
				customer.setIdCustomer(rs.getInt("c.id_customer"));
				address.setCustomer(customer);
			
				// country inner join
				country.setId_country(rs.getInt("co.id_country"));
				country.setName(rs.getString("co.name"));
				country.setIso_code(rs.getString("co.iso_code"));
				address.setCountry(country);
				
				// city inner join
				city.setId_city(rs.getInt("ci.id_city"));
				city.setName(rs.getString("ci.name"));
				address.setCity(city);
				
				// district inner join
				district.setId_district(rs.getInt("di.id_district"));
				district.setName(rs.getString("di.name"));
				address.setDistrict(district);
				
				
				address.setPostcode(rs.getString("a.postcode"));
				address.setAlias(rs.getString("a.alias"));
				address.setCompany("a.company");
				address.setLastname(rs.getString("a.lastname"));
				address.setFirstname(rs.getString("a.firstname"));
				address.setAddress1(rs.getString("a.address1"));
				address.setAddress2(rs.getString("a.address2"));
				address.setPhone_mobile(rs.getString("a.phone_mobile"));
				address.setDate_updated(rs.getDate("a.date_updated"));
				address.setActive(rs.getInt("a.active"));
				address.setDeleted(rs.getInt("a.deleted"));

			}
			connection.close();
			return address;

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
	public Address findManufacturerOne(int id_manufacturer) throws SQLException {
		
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT * FROM address a "
				+ "LEFT JOIN manufacturer m ON a.id_manufacturer = m.id_manufacturer "				
				+ "LEFT JOIN country co ON a.id_country = co.id_country "
				+ "LEFT JOIN city ci ON a.id_city = ci.id_city "
				+ "LEFT JOIN district di ON a.id_district = di.id_district "
				+ "WHERE id_manufacturer = ?";
		PreparedStatement ps = null;

		try {

			
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, id_manufacturer);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				address = new Address();
				customer = new Customer();
				manufacturer = new Manufacturer();
				supplier = new Supplier();
				country = new Country();
				city = new City();
				district = new District();
				
	
				// manufacturer inner join
				manufacturer.setId_manufacturer(rs.getInt("m.id_manufacturer"));
				address.setManufacturer(manufacturer);					


				// country inner join
				country.setId_country(rs.getInt("co.id_country"));
				country.setName(rs.getString("co.name"));
				country.setIso_code(rs.getString("co.iso_code"));
				address.setCountry(country);
				
				// city inner join
				city.setId_city(rs.getInt("ci.id_city"));
				city.setName(rs.getString("ci.name"));
				address.setCity(city);
				
				// district inner join
				district.setId_district(rs.getInt("di.id_district"));
				district.setName(rs.getString("di.name"));
				address.setDistrict(district);
				
				
				address.setPostcode(rs.getString("a.postcode"));
				address.setAlias(rs.getString("a.alias"));
				address.setCompany("a.company");
				address.setLastname(rs.getString("a.lastname"));
				address.setFirstname(rs.getString("a.firstname"));
				address.setAddress1(rs.getString("a.address1"));
				address.setAddress2(rs.getString("a.address2"));
				address.setPhone_mobile(rs.getString("a.phone_mobile"));
				address.setDate_updated(rs.getDate("a.date_updated"));
				address.setActive(rs.getInt("a.active"));
				address.setDeleted(rs.getInt("a.deleted"));

			}
			connection.close();
			return address;

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
	public Address findSupplierOne(int id_supplier) throws SQLException {
		
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT * FROM address a "
				+ "LEFT JOIN supplier s ON a.id_supplier = s.id_supplier "
				+ "LEFT JOIN country co ON a.id_country = co.id_country "
				+ "LEFT JOIN city ci ON a.id_city = ci.id_city "
				+ "LEFT JOIN district di ON a.id_district = di.id_district "
				+ "WHERE id_supplier = ?";
		PreparedStatement ps = null;

		try {

			
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, id_supplier);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				address = new Address();
				customer = new Customer();
				manufacturer = new Manufacturer();
				supplier = new Supplier();
				country = new Country();
				city = new City();
				district = new District();
			
				//supplier inner join
				supplier.setId_supplier(rs.getInt("s.id_supplier"));
				address.setSupplier(supplier);
				

				// country inner join
				country.setId_country(rs.getInt("co.id_country"));
				country.setName(rs.getString("co.name"));
				country.setIso_code(rs.getString("co.iso_code"));
				address.setCountry(country);
				
				// city inner join
				city.setId_city(rs.getInt("ci.id_city"));
				city.setName(rs.getString("ci.name"));
				address.setCity(city);
				
				// district inner join
				district.setId_district(rs.getInt("di.id_district"));
				district.setName(rs.getString("di.name"));
				address.setDistrict(district);
				
				
				address.setPostcode(rs.getString("a.postcode"));
				address.setAlias(rs.getString("a.alias"));
				address.setCompany("a.company");
				address.setLastname(rs.getString("a.lastname"));
				address.setFirstname(rs.getString("a.firstname"));
				address.setAddress1(rs.getString("a.address1"));
				address.setAddress2(rs.getString("a.address2"));
				address.setPhone_mobile(rs.getString("a.phone_mobile"));
				address.setDate_updated(rs.getDate("a.date_updated"));
				address.setActive(rs.getInt("a.active"));
				address.setDeleted(rs.getInt("a.deleted"));

			}
			connection.close();
			return address;

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
	public void addAddress(Address address) throws SQLException {
		
		Connection connection = null;
		PreparedStatement ps = null;

		String query = "INSERT INTO `address` "
				+ "(`id_customer`, `id_manufacturer`, `id_supplier`, `id_country`, "
				+ "`id_city`, `id_district`, `postcode`, `alias`, `company`, `lastname`, `firstname`, "
				+ "`address1`, `address2`, `phone_mobile`, `date_added`, `date_updated`, `active`, `deleted`) "
				+ "VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, '', '', '', "
				+ "?, ?, CURRENT_TIMESTAMP, ?, ?, ?)";
		
		
		try {
			
			connection = MySQLConnection.getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
			
			ps.setInt(1, address.getCustomer().getIdCustomer());
			ps.setInt(2, address.getManufacturer().getId_manufacturer());
			ps.setInt(3, address.getSupplier().getId_supplier());
			ps.setInt(4, address.getCountry().getId_country());
			ps.setInt(5, address.getCity().getId_city());
			ps.setInt(6, address.getDistrict().getId_district());
			ps.setString(7, address.getPostcode());
			ps.setString(8, address.getAlias());
			ps.setString(9, address.getCompany());
			ps.setString(10, address.getLastname());
			ps.setString(11, address.getFirstname());
			ps.setString(12, address.getAddress1());
			ps.setString(13, address.getAddress2());
			ps.setString(14, address.getPhone_mobile());
			ps.setDate(15, new java.sql.Date(address.getDate_updated().getTime()));
			ps.setInt(16, address.getActive());
			ps.setInt(17, address.getDeleted());
			
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
	public void addAddressFromRegister(Address address) throws SQLException {
		
		Connection connection = null;
		PreparedStatement ps = null;

		String query = "INSERT INTO `address` "
				+ "(`id_customer`, `id_manufacturer`, `id_supplier`, `id_country`, "
				+ "`id_city`, `id_district`, `postcode`, `alias`, `company`, `lastname`, `firstname`, "
				+ "`address1`, `address2`, `phone_mobile`, `date_added`, `date_updated`, `active`, `deleted`) "
				+ "VALUES "
				+ "(?, 0, 0, 1, ?, ?, ?, ?, ?, ?, ?, ?, "
				+ "?, ?, CURRENT_TIMESTAMP, ?, ?, ?)";
		
		
		try {
			
			connection = MySQLConnection.getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
			
			ps.setInt(1, address.getCustomer().getIdCustomer());
			ps.setInt(2, address.getCityValue());
			ps.setInt(3, address.getDistrictValue());
			ps.setString(4, address.getPostcode());
			ps.setString(5, address.getAlias());
			ps.setString(6, address.getCompany());
			ps.setString(7, address.getLastname());
			ps.setString(8, address.getFirstname());
			ps.setString(9, address.getAddress1());
			ps.setString(10, address.getAddress2());
			ps.setString(11, address.getPhone_mobile());
			ps.setDate(12, new java.sql.Date(address.getDate_updated().getTime()));
			ps.setInt(13, address.getActive());
			ps.setInt(14, address.getDeleted());
			
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
	public void updateAddress(Address address) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;

		String query = "UPDATE `address` SET "
				+ "(`id_customer` = ?, `id_manufacturer` = ?, `id_supplier` = ?, `id_country` = ?, "
				+ "`id_city` = ?, `id_district` = ?, `postcode` = ?, `alias` = ?, `company` = ?, "
				+ "`lastname` = ?, `firstname` = ?, `address1` = ?, `address2` = ?, `phone_mobile` = ?, "
				+ "`date_updated` = ?, `active` = ?, `deleted` = ?) "
				+ "WHERE id_address = ?";
		
		try {
			
			connection = MySQLConnection.getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
			
			ps.setInt(1, address.getCustomer().getIdCustomer());
			ps.setInt(2, address.getManufacturer().getId_manufacturer());
			ps.setInt(3, address.getSupplier().getId_supplier());
			ps.setInt(4, address.getCountry().getId_country());
			ps.setInt(5, address.getCity().getId_city());
			ps.setInt(6, address.getDistrict().getId_district());
			ps.setString(7, address.getPostcode());
			ps.setString(8, address.getAlias());
			ps.setString(9, address.getCompany());
			ps.setString(10, address.getLastname());
			ps.setString(11, address.getFirstname());
			ps.setString(12, address.getAddress1());
			ps.setString(13, address.getAddress2());
			ps.setString(14, address.getPhone_mobile());
			ps.setDate(15, new java.sql.Date(address.getDate_updated().getTime()));
			ps.setInt(16, address.getActive());
			ps.setInt(17, address.getDeleted());
			
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
	public void deleteAddress(int id_address) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;

		String query = "UPDATE `address` SET `deleted` = ? WHERE `address`.`id_address` = ? ";
		
		try {
			
			connection = MySQLConnection.getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
			
			ps.setInt(1, 1);
			ps.setInt(2, id_address);
			
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
	public List<Address> findCustomerAll() throws SQLException {
		
		
		List<Address> addresses = new ArrayList<Address>();
		
		ResultSet rs;
		int rows = 0;
		Connection connection = MySQLConnection.getConnection();
		PreparedStatement ps = null;
		try {

			String query = "SELECT COUNT(id_address) FROM address";
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

				String query = "SELECT * FROM address a "
						+ "LEFT JOIN customer c ON a.id_customer=c.id_customer "
						+ "LEFT JOIN country co ON a.id_country = co.id_country "
						+ "LEFT JOIN city ci ON a.id_city = ci.id_city "
						+ "LEFT JOIN district di ON a.id_district = di.id_district "	
						+ "LIMIT " + START + "," + END;
				
				ps = (PreparedStatement) connection.prepareStatement(query);				
				rs = ps.executeQuery();

				while (rs.next()) {
					
					address = new Address();
					customer = new Customer();
					country = new Country();
					city = new City();
					district = new District();
					
					address.setId_address(rs.getInt("id_address"));
					
					// customer inner join
					customer.setIdCustomer(rs.getInt("c.id_customer"));					
					address.setCustomer(customer);

					// country inner join
					country.setId_country(rs.getInt("co.id_country"));
					country.setName(rs.getString("co.name"));
					address.setCountry(country);
					
					// city inner join
					city.setId_city(rs.getInt("ci.id_city"));
					city.setName(rs.getString("ci.name"));
					address.setCity(city);
					
					// district inner join
					district.setId_district(rs.getInt("di.id_district"));
					district.setName(rs.getString("di.name"));
					address.setDistrict(district);
					
					
					address.setPostcode(rs.getString("postcode"));
					address.setAlias(rs.getString("alias"));
					address.setCompany("company");
					address.setLastname(rs.getString("lastname"));
					address.setFirstname(rs.getString("firstname"));
					address.setAddress1(rs.getString("a.address1"));
					address.setAddress2(rs.getString("a.address2"));					
					address.setPhone_mobile(rs.getString("phone_mobile"));
					address.setDate_updated(rs.getDate("date_updated"));
					address.setActive(rs.getInt("active"));
					address.setDeleted(rs.getInt("deleted"));
					
					addresses.add(address);
				}

			}
			rs.close();
			connection.close();

			return addresses;

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
	public List<Address> findManufacturerAll() throws SQLException {
		
		
		List<Address> addresses = new ArrayList<Address>();
		
		ResultSet rs;
		int rows = 0;
		Connection connection = MySQLConnection.getConnection();
		PreparedStatement ps = null;
		try {

			String query = "SELECT COUNT(id_address) FROM address";
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

				String query = "SELECT * FROM adress a "
						+ "LEFT JOIN manufacturer m ON a.id_manufacturer = m.id_manufacturer "
						+ "LEFT JOIN country co ON a.id_country = co.id_country "
						+ "LEFT JOIN city ci ON a.id_city = ci.id_city "
						+ "LEFT JOIN district di ON a.id_district = di.id_district "	
						+ "LIMIT " + START + "," + END;
				
				ps = (PreparedStatement) connection.prepareStatement(query);				
				rs = ps.executeQuery();

				while (rs.next()) {
					
					address = new Address();
					manufacturer = new Manufacturer();					
					country = new Country();
					city = new City();
					district = new District();
					
					address.setId_address(rs.getInt("id_address"));
				
					// manufacturer inner join
					manufacturer.setId_manufacturer(rs.getInt("m.id_manufacturer"));
					address.setSupplier(supplier);					
				
					// country inner join
					country.setId_country(rs.getInt("co.id_country"));
					country.setName(rs.getString("co.name"));
					address.setCountry(country);
					
					// city inner join
					city.setId_city(rs.getInt("ci.id_city"));
					city.setName(rs.getString("ci.name"));
					address.setCity(city);
					
					// district inner join
					district.setId_district(rs.getInt("di.id_district"));
					district.setName(rs.getString("di.name"));
					address.setDistrict(district);
					
					
					address.setPostcode(rs.getString("postcode"));
					address.setAlias(rs.getString("alias"));
					address.setCompany("company");
					address.setLastname(rs.getString("lastname"));
					address.setFirstname(rs.getString("firstname"));
					address.setAddress1(rs.getString("a.address1"));
					address.setAddress2(rs.getString("a.address2"));					
					address.setPhone_mobile(rs.getString("phone_mobile"));
					address.setDate_updated(rs.getDate("date_updated"));
					address.setActive(rs.getInt("active"));
					address.setDeleted(rs.getInt("deleted"));
					
					addresses.add(address);
				}

			}
			rs.close();
			connection.close();

			return addresses;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}	finally{

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
	public List<Address> findSupplierAll() throws SQLException {
		
		
		List<Address> addresses = new ArrayList<Address>();

		ResultSet rs;
		int rows = 0;
		Connection connection = MySQLConnection.getConnection();
		PreparedStatement ps = null;
		try {

			String query = "SELECT COUNT(id_address) FROM address";
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

				String query = "SELECT * FROM adress a "
						+ "LEFT JOIN supplier s ON a.id_supplier = s.id_supplier "
						+ "LEFT JOIN country co ON a.id_country = co.id_country "
						+ "LEFT JOIN city ci ON a.id_city = ci.id_city "
						+ "LEFT JOIN district di ON a.id_district = di.id_district "	
						+ "LIMIT " + START + "," + END;
				
				ps = (PreparedStatement) connection.prepareStatement(query);				
				rs = ps.executeQuery();

				while (rs.next()) {
					address = new Address();					
					supplier = new Supplier();
					country = new Country();
					city = new City();
					district = new District();
					
					address.setId_address(rs.getInt("id_address"));			
				
					//supplier inner join
					supplier.setId_supplier(rs.getInt("s.id_supplier"));

					// country inner join
					country.setId_country(rs.getInt("co.id_country"));
					country.setName(rs.getString("co.name"));
					address.setCountry(country);
					
					// city inner join
					city.setId_city(rs.getInt("ci.id_city"));
					city.setName(rs.getString("ci.name"));
					address.setCity(city);
					
					// district inner join
					district.setId_district(rs.getInt("di.id_district"));
					district.setName(rs.getString("di.name"));
					address.setDistrict(district);
					
					
					address.setPostcode(rs.getString("postcode"));
					address.setAlias(rs.getString("alias"));
					address.setCompany("company");
					address.setLastname(rs.getString("lastname"));
					address.setFirstname(rs.getString("firstname"));
					address.setAddress1(rs.getString("a.address1"));
					address.setAddress2(rs.getString("a.address2"));					
					address.setPhone_mobile(rs.getString("phone_mobile"));
					address.setDate_updated(rs.getDate("date_updated"));
					address.setActive(rs.getInt("active"));
					address.setDeleted(rs.getInt("deleted"));
					
					addresses.add(address);
				}

			}
			rs.close();
			connection.close();

			return addresses;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}	finally{

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
//		List<Address> addresss = new ArrayList<>();
//		AddressRepositoryImpl addr = new AddressRepositoryImpl();
//		addresss  = addr.findCustomerAll();
//		for (Address address : addresss) {
//			
//			System.out.println(address.getActive() + " "+ address.getAddress1());
//		}	
	}


}
