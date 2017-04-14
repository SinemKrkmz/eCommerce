package com.halilkoca.business.repository.customer;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.model.customer.Customer;

public interface CustomerRepository {
	
	Customer findOne(int id_customer) throws SQLException;
	
	Customer findOneByUsername(String username) throws SQLException;
	
	List<Customer> findByName(String firstname) throws SQLException;
	
	void addCustomer(Customer customer) throws SQLException;
	
	void updateCustomer(Customer customer) throws SQLException;
	
	void deleteCustomer(int id_customer) throws SQLException;
	
	List<Customer> findAll() throws SQLException;
	
	boolean checkUsername(String username) throws SQLException;
	
}
