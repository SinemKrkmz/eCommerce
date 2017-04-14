package com.halilkoca.business.services.common;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.business.repository.common.AddressRepositoryImpl;
import com.halilkoca.model.common.Address;

public class AddressServiceImpl implements AddressService {

	private AddressRepositoryImpl repository = new AddressRepositoryImpl();

	@Override
	public Address getCustomerById(int id_customer) throws SQLException {
		return repository.findCustomerOne(id_customer);
	}

	@Override
	public Address getManufacturerById(int id_manufacturer) throws SQLException {
		return repository.findManufacturerOne(id_manufacturer);
	}

	@Override
	public Address getSupplierById(int id_supplier) throws SQLException {
		return repository.findSupplierOne(id_supplier);
	}

	@Override
	public void addAddress(Address address) throws SQLException {
		repository.addAddress(address);
	}
	
	@Override
	public void addAddressFromRegister(Address address) throws SQLException {
		repository.addAddressFromRegister(address);
	}
	
	@Override
	public void updateAddress(Address address) throws SQLException {
		repository.updateAddress(address);
	}

	@Override
	public void deleteAddress(int id_address) throws SQLException {
		repository.deleteAddress(id_address);
	}

	@Override
	public List<Address> getCustomerAll() throws SQLException {
		return repository.findCustomerAll();
	}

	@Override
	public List<Address> getManufacturerAll() throws SQLException {
		return repository.findManufacturerAll();
	}

	@Override
	public List<Address> getSupplierAll() throws SQLException {
		return repository.findSupplierAll();
	}



}
