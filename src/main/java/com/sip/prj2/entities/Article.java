package com.sip.prj2.entities;

public class Article {

	private String label;
	private String price;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(String label, String price) {
		super();
		this.label = label;
		this.price = price;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
