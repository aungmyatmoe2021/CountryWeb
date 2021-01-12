package com.countryweb.model;

public class Employee {
	private int empNo;
	private String birthDate;
	private String firstName;
	private String lastName;
	private char gender;
	private String hireDate;
	
	public Employee() {
		super();
		this.empNo = 0;
		this.birthDate = "0000-00-00";
		this.firstName = "";
		this.lastName = "";
		this.gender = '-';
		this.hireDate = "0000-00-00";
	}
	
	public Employee(int empNo, String birthDate, String firstName, String lastName, char gender, String hireDate) {
		super();
		this.empNo = empNo;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.hireDate = hireDate;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
}
