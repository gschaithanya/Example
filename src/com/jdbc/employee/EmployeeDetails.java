package com.jdbc.employee;

public class EmployeeDetails {
	private String employeeName;
	private String address;
	private String designation;
	private String contactNumber;
	private String email;
	private Double annulaCtc;
	private float yearsOfExperience;
	private String bloodGroup;
	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDetails(String employeeName, String address, String designation, String contactNumber, String email,
			Double annulaCtc, float yearOfExperience, String bloodGroup) {
		super();
		this.employeeName = employeeName;
		this.address = address;
		this.designation = designation;
		this.contactNumber = contactNumber;
		this.email = email;
		this.annulaCtc = annulaCtc;
		this.yearsOfExperience = yearOfExperience;
		this.bloodGroup = bloodGroup;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		designation = designation;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getAnnulaCtc() {
		return annulaCtc;
	}
	public void setAnnulaCtc(Double annulaCtc) {
		this.annulaCtc = annulaCtc;
	}
	public float getYearOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(float string) {
		this.yearsOfExperience = string;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [employeeName=" + employeeName + ", address=" + address + ", designation=" + designation
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", annulaCtc=" + annulaCtc
				+ ", yearOfExperience=" + yearsOfExperience + ", bloodGroup=" + bloodGroup + "]";
	}
	
	

}
