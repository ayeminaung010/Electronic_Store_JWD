package com.ace.ai.web;


public class Student {

	private String name;
	private String phone;
	private String email;
	private int age;
	private String className;
	
	public  Student() {
		
	}

	public Student(String name, String phone, String email, int age, String className) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.className = className;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
}
