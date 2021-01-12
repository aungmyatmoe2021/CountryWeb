package com.countryweb.model;

public class Country {
	private int countryID;
	private int countryCode;
	private String countryShortName;
	private String countryFullName;
	
	public Country() {
		super();
		this.countryID = 0;
		this.countryCode = 0;
		this.countryShortName = "";
		this.countryFullName = "";
	}
	
	public Country(int countryID, int countryCode, String countryShortName, String countryFullName) {
		super();
		this.countryID = countryID;
		this.countryCode = countryCode;
		this.countryShortName = countryShortName;
		this.countryFullName = countryFullName;
	}

	public int getCountryID() {
		return countryID;
	}

	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryShortName() {
		return countryShortName;
	}

	public void setCountryShortName(String countryShortName) {
		this.countryShortName = countryShortName;
	}

	public String getCountryFullName() {
		return countryFullName;
	}

	public void setCountryFullName(String countryFullName) {
		this.countryFullName = countryFullName;
	}
}
