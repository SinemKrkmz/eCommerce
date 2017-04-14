package com.halilkoca.business.services.customer;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.model.customer.Customer;

public interface CustomerService {
	
	public Customer getById(int id_customer) throws SQLException;
	
	public Customer getByUsername(String username) throws SQLException;

	public void addCustomer(Customer customer) throws SQLException;

	public void updateCustomer(Customer customer) throws SQLException;
	
	public List<Customer> getByName(String username) throws SQLException;
	
	public List<Customer> getAll() throws SQLException;

}
