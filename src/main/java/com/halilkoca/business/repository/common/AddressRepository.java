package com.halilkoca.business.repository.common;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.model.common.Address;

public interface AddressRepository {

	Address findCustomerOne(int id_customer) throws SQLException;

	Address findManufacturerOne(int id_manufacturer) throws SQLException;

	Address findSupplierOne(int id_supplier) throws SQLException;

	void addAddress(Address address) throws SQLException;
	
	void addAddressFromRegister(Address address) throws SQLException;

	void updateAddress(Address address) throws SQLException;

	void deleteAddress(int id_address) throws SQLException;

	List<Address> findCustomerAll() throws SQLException;

	List<Address> findManufacturerAll() throws SQLException;

	List<Address> findSupplierAll() throws SQLException;

}
