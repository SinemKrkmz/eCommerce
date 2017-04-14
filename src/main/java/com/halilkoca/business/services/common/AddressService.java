package com.halilkoca.business.services.common;

import java.sql.SQLException;
import java.util.List;

import com.halilkoca.model.common.Address;

public interface AddressService {

	public Address getCustomerById(int id_customer) throws SQLException;

	public Address getManufacturerById(int id_manufacturer) throws SQLException;

	public Address getSupplierById(int id_supplier) throws SQLException;

	public void addAddress(Address address) throws SQLException;
	
	public void addAddressFromRegister(Address address) throws SQLException;

	public void updateAddress(Address address) throws SQLException;

	public void deleteAddress(int id_address) throws SQLException;

	List<Address> getCustomerAll() throws SQLException;

	List<Address> getManufacturerAll() throws SQLException;

	List<Address> getSupplierAll() throws SQLException;

}
