package com.halilkoca.model.reference;

public class Currency {

	private int id_currency;
	private String name;
	private String iso_code;
	private double conversion_rate;
	private int active;

	public Currency() {
		
	}

	public Currency(int id_currency, String name, String iso_code, double conversion_rate, int active) {
		super();
		this.id_currency = id_currency;
		this.name = name;
		this.iso_code = iso_code;
		this.conversion_rate = conversion_rate;
		this.active = active;
	}

	public int getId_currency() {
		return id_currency;
	}

	public void setId_currency(int id_currency) {
		this.id_currency = id_currency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIso_code() {
		return iso_code;
	}

	public void setIso_code(String iso_code) {
		this.iso_code = iso_code;
	}

	public double getConversion_rate() {
		return conversion_rate;
	}

	public void setConversion_rate(double conversion_rate) {
		this.conversion_rate = conversion_rate;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}