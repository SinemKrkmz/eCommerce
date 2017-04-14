package com.halilkoca.model.common;

public class District {

	private int id_district;
	private City city;
	private String name;

	public District() {
		
	}

	public District(int id_district, City city, String name) {
		super();
		this.id_district = id_district;
		this.city = city;
		this.name = name;
	}

	public int getId_district() {
		return id_district;
	}

	public void setId_district(int id_district) {
		this.id_district = id_district;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
