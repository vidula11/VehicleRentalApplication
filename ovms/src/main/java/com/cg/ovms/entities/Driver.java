package com.cg.ovms.entities;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="driver")
@Component
public class Driver {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer driverId;
	
	private String firstName;
	private String lastName;	
	private String contactNumber;
	private String email;
	private String address;
	private Double chargesPerDay;
	private String licenseNo;
	
	@OneToOne(mappedBy="driver",fetch = FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private Vehicle vehicle;
	
	public Driver() {
		super();
	}
	



	public Driver(Integer driverId) {
		super();
		this.driverId = driverId;
	}

	public Driver(String firstName, String lastName, String contactNumber, String email, String address,
			Double chargesPerDay, String licenseNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.chargesPerDay = chargesPerDay;
		this.licenseNo = licenseNo;
	}

	public Driver(Integer driverId, String firstName, String lastName, String contactNumber, String email,
			String address, Double chargesPerDay, String licenseNo) {
		super();
		this.driverId = driverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.chargesPerDay = chargesPerDay;
		this.licenseNo = licenseNo;
	}




	public Integer getDriverId() {
		return driverId;
	}




	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
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



/*
	public Vehicle getVehicle() {
		return vehicle;
	}




	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
*/
	public boolean equals(Object obj) {
	      if (obj == this) {
	         return true;
	      }
	      if (!(obj instanceof Driver)) {
	         return false;
	      }
	      Driver driver = (Driver) obj;
	      return driverId.equals(driver.driverId) && Double.compare(chargesPerDay,driver.chargesPerDay) == 0;
	   }

	
	
}
