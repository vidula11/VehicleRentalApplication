package com.cg.ovms.dto;

import org.springframework.stereotype.Component;

@Component
public class DriverDto {
	
	private Integer DriverId;
	private String firstName;
	private String lastName;	
	private String contactNumber;
	private String email;
	private String address;
	private Double chargesPerDay;
	private String licenseNo;
	
	
	
	public DriverDto() {
		super();
	}
	
	
	
	public DriverDto( String firstName, String lastName, String contactNumber, String email,
			String address, Double chargesPerDay, String licenseNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.chargesPerDay = chargesPerDay;
		this.licenseNo = licenseNo;
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
	public Integer getDriverId() {
		return DriverId;
	}



	public void setDriverId(Integer driverId) {
		DriverId = driverId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getChargesPerDay() {
		return chargesPerDay;
	}
	public void setChargesPerDay(Double chargesPerDay) {
		this.chargesPerDay = chargesPerDay;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	
	


}
