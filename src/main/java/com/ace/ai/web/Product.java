package com.ace.ai.web;

public class Product {
	private int id;
	private int maker_id;
	private String make;
	private String model;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getMaker_id() {
		return maker_id;
	}
	public void setMaker_id(int maker_id) {
		this.maker_id = maker_id;
	}
}
