package com.halilkoca.model.common;

public class City {

	private int id_city;
	private Country country;
	private String name;
	private String license_plate_no;

	public City() {
		
	}

	public City(int id_city, Country country, String city_name, String license_plate_no) {
		super();
		this.id_city = id_city;
		this.country = country;
		this.name = city_name;
		this.license_plate_no = license_plate_no;
	}

	public int getId_city() {
		return id_city;
	}

	public void setId_city(int id_city) {
		this.id_city = id_city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicense_plate_no() {
		return license_plate_no;
	}

	public void setLicense_plate_no(String license_plate_no) {
		this.license_plate_no = license_plate_no;
	}

}
