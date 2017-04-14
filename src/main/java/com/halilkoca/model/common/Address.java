package com.halilkoca.model.common;

import java.util.Date;

import com.halilkoca.model.catalog.product.manufacturer.Manufacturer;
import com.halilkoca.model.catalog.product.supplier.Supplier;
import com.halilkoca.model.customer.Customer;

public class Address {
	
	private int id_address;
	private Customer customer;	
	private Manufacturer manufacturer;
	private Supplier supplier;
	private Country country;
	private City city;
	private District district;
	
	private int countryValue;
	private int cityValue;
	private int districtValue;
	
	private String address1;
	private String address2;	
	private String postcode;
	private String alias;
	private String company;
	private String lastname;
	private String firstname;
	private String phone_mobile;
	private Date date_updated;
	private int active;
	private int deleted;
	
	public Address() {
		super();
	}

	public Address(Customer customer, Country country, City city, District district, 
			String address1, String address2, String postcode,
			String alias, String company, String lastname, String firstname,
			String phone_mobile, Date date_updated, int active,	int deleted) {
		this.customer = customer;
		this.country = country;
		this.city = city;
		this.district = district;
		this.address1 = address1;
		this.address2 = address2;
		this.postcode = postcode;
		this.alias = alias;
		this.company = company;
		this.lastname = lastname;
		this.firstname = firstname;
		this.phone_mobile = phone_mobile;
		this.date_updated = date_updated;
		this.active = active;
		this.deleted = deleted;
	}
	public Address(Manufacturer manufacturer,
			Country country, City city, District district, String address1, String address2, String postcode,
			String alias, String company, String lastname, String firstname,
			String phone_mobile, Date date_updated, int active,	int deleted) {
		this.manufacturer = manufacturer;
		this.country = country;
		this.city = city;
		this.district = district;
		this.address1 = address1;
		this.address2 = address2;
		this.postcode = postcode;
		this.alias = alias;
		this.company = company;
		this.lastname = lastname;
		this.firstname = firstname;
		this.phone_mobile = phone_mobile;
		this.date_updated = date_updated;
		this.active = active;
		this.deleted = deleted;
	}
	
	public Address(Supplier supplier,
			Country country, City city, District district, String address1, String address2, String postcode,
			String alias, String company, String lastname, String firstname,
			String phone_mobile, Date date_updated, int active,	int deleted) {
		this.supplier = supplier;
		this.country = country;
		this.city = city;
		this.district = district;
		this.address1 = address1;
		this.address2 = address2;
		this.postcode = postcode;
		this.alias = alias;
		this.company = company;
		this.lastname = lastname;
		this.firstname = firstname;
		this.phone_mobile = phone_mobile;
		this.date_updated = date_updated;
		this.active = active;
		this.deleted = deleted;
	}

	public Address(Customer customer, int cityValue, int districtValue,
			String address1, String address2, String postcode, String alias, String company, String lastname,
			String firstname, String phone_mobile, Date date_updated, int active, int deleted) {
		this.customer = customer;
		this.cityValue = cityValue;
		this.districtValue = districtValue;
		this.address1 = address1;
		this.address2 = address2;
		this.postcode = postcode;
		this.alias = alias;
		this.company = company;
		this.lastname = lastname;
		this.firstname = firstname;
		this.phone_mobile = phone_mobile;
		this.date_updated = date_updated;
		this.active = active;
		this.deleted = deleted;
	}

	public int getId_address() {
		return id_address;
	}

	public void setId_address(int id_address) {
		this.id_address = id_address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public int getCountryValue() {
		return countryValue;
	}

	public void setCountryValue(int countryValue) {
		this.countryValue = countryValue;
	}

	public int getCityValue() {
		return cityValue;
	}

	public void setCityValue(int cityValue) {
		this.cityValue = cityValue;
	}

	public int getDistrictValue() {
		return districtValue;
	}

	public void setDistrictValue(int districtValue) {
		this.districtValue = districtValue;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPhone_mobile() {
		return phone_mobile;
	}

	public void setPhone_mobile(String phone_mobile) {
		this.phone_mobile = phone_mobile;
	}

	public Date getDate_updated() {
		return date_updated;
	}

	public void setDate_updated(Date date_updated) {
		this.date_updated = date_updated;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
	
	
	
	

}