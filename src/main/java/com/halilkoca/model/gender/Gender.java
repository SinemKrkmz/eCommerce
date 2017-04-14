package com.halilkoca.model.gender;

public class Gender {

	private int id_gender;
	private String name;


	public Gender() {
		super();
	}

	public Gender(int id_gender, String name) {
		super();
		this.id_gender = id_gender;
		this.name = name;
	}

	public int getId_gender() {
		return id_gender;
	}

	public void setId_gender(int id_gender) {
		this.id_gender = id_gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
