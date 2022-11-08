package com.luv2code.springdemo.mvc;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favLang;
	private String[] operationSystems;
	

	
	public String[] getOperationSystems() {
		return operationSystems;
	}
	public void setOperationSystems(String[] operationSystems) {
		this.operationSystems = operationSystems;
	}
	public String getFavLang() {
		return favLang;
	}
	public void setFavLang(String favLang) {
		this.favLang = favLang;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
