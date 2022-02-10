package com.sip.prj2.entities;

public class Provider {

	private String name;
	private String adress;
	private String email;
	
	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Provider(String name, String adress, String email) {
		super();
		this.name = name;
		this.adress = adress;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
