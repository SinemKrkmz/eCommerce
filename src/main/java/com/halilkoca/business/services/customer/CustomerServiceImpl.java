package com.halilkoca.business.services.customer;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.business.repository.customer.CustomerRepository;
import com.halilkoca.business.repository.customer.CustomerRepositoryImpl;
import com.halilkoca.model.customer.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepositoryImpl repository = new CustomerRepositoryImpl();

	
	public Customer getById(int id_customer) throws SQLException {
		return repository.findOne(id_customer);
	}
	
	@Override
	public Customer getByUsername(String username) throws SQLException {
		return repository.findOneByUsername(username);
	}
	
	public void addCustomer(Customer customer) throws SQLException {	
		repository.addCustomer(customer);
	}

	
	public void updateCustomer(Customer customer) throws SQLException {
		repository.updateCustomer(customer);
	}

	
	public List<Customer> getByName(String username) throws SQLException {
		return repository.findByName(username);
	}

	
	public List<Customer> getAll() throws SQLException {
		return repository.findAll();
	}

}
