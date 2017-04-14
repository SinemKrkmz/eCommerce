package com.halilkoca.model.common;

import com.halilkoca.model.reference.Currency;

public class Country {

	private int id_country;
	private Currency currency;
	private String iso_code;
	private String call_prefix;
	private int active;
	private String name;

	public Country() {
		
	}

	public Country(int id_country, Currency currency, String iso_code, String call_prefix, int active, String name) {
		super();
		this.id_country = id_country;
		this.currency = currency;
		this.iso_code = iso_code;
		this.call_prefix = call_prefix;
		this.active = active;
		this.name = name;
	}

	public int getId_country() {
		return id_country;
	}

	public void setId_country(int id_country) {
		this.id_country = id_country;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getIso_code() {
		return iso_code;
	}

	public void setIso_code(String iso_code) {
		this.iso_code = iso_code;
	}

	public String getCall_prefix() {
		return call_prefix;
	}

	public void setCall_prefix(String call_prefix) {
		this.call_prefix = call_prefix;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}