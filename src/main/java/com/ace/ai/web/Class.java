package com.ace.ai.web;

public class Class {
	private String course;
	private String instructorNameString;
	private String date;
	
	public Class(String course, String instructorNameString, String date) {
		super();
		this.course = course;
		this.instructorNameString = instructorNameString;
		this.date = date;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getInstructorNameString() {
		return instructorNameString;
	}
	public void setInstructorNameString(String instructorNameString) {
		this.instructorNameString = instructorNameString;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
