package com.ace.ai.web;

public class Computer {
	private int id;
	private int product_id;
	private int type_computer_id;
	private String modelName;
	private String makeName;
	private String speed;
	private String ram;
	private String hd;
	private String price;
	private String computer_type;
	
	public String getComputer_type() {
		return computer_type;
	}
	public void setComputer_type(String computer_type) {
		this.computer_type = computer_type;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getMakeName() {
		return makeName;
	}
	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getType_computer_id() {
		return type_computer_id;
	}
	public void setType_computer_id(int type_computer_id) {
		this.type_computer_id = type_computer_id;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getHd() {
		return hd;
	}
	public void setHd(String hd) {
		this.hd = hd;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
