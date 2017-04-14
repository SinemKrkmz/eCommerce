package com.halilkoca.model.catalog.product.supplier;

import java.util.Date;

public class Supplier {

	private int id_supplier;
	private String name;
	private Date date_add;
	private Date date_updated;
	private String description;
	private String meta_title;
	private String meta_keywords;
	private String meta_description;
	private int active;

	public Supplier() {
		
	}

	public Supplier(int id_supplier, String name, Date date_add, Date date_updated, String description,
			String meta_title, String meta_keywords, String meta_description, int active) {
		this.id_supplier = id_supplier;
		this.name = name;
		this.date_add = date_add;
		this.date_updated = date_updated;
		this.description = description;
		this.meta_title = meta_title;
		this.meta_keywords = meta_keywords;
		this.meta_description = meta_description;
		this.active = active;
	}

	public int getId_supplier() {
		return id_supplier;
	}

	public void setId_supplier(int id_supplier) {
		this.id_supplier = id_supplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate_add() {
		return date_add;
	}

	public void setDate_add(Date date_add) {
		this.date_add = date_add;
	}

	public Date getDate_updated() {
		return date_updated;
	}

	public void setDate_updated(Date date_updated) {
		this.date_updated = date_updated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeta_title() {
		return meta_title;
	}

	public void setMeta_title(String meta_title) {
		this.meta_title = meta_title;
	}

	public String getMeta_keywords() {
		return meta_keywords;
	}

	public void setMeta_keywords(String meta_keywords) {
		this.meta_keywords = meta_keywords;
	}

	public String getMeta_description() {
		return meta_description;
	}

	public void setMeta_description(String meta_description) {
		this.meta_description = meta_description;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
