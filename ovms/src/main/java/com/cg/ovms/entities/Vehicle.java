package com.cg.ovms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="vehicle")
@Component
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  Integer vehicleId;
	

	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="driverId")
	private Driver driver;
	
	private String vehicleNumber;
	private String type;//car//bus
	private String category; //ac or nonac
	private String description;
	private String location;
	private Integer capacity;
	private Double chargesPerKM;
	private Double fixedCharges;
	private boolean bookedStatus;
	//1 customer makes a request - request status=1
	//2 admin will be able to see the vehicles with requeststatus=1
	//3 if admin accepts request status=2, if rejects request status=0
	@JsonIgnore
	
	@OneToOne(mappedBy="vehicle",fetch = FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private Booking booking;
	
	public Vehicle() {
		super();
		
	}
	public Vehicle(Integer vehicleId) {
		super();
		this.vehicleId = vehicleId;
	}
	public Vehicle(/*Driver driver,*/ String vehicleNumber, String type, String category, String description,
			String location, Integer capacity, Double chargesPerKM, Double fixedCharges) {
		super();
		//this.driver = driver;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.location = location;
		this.capacity = capacity;
		this.chargesPerKM = chargesPerKM;
		this.fixedCharges = fixedCharges;
	}
	public Vehicle(Integer vehicleId /*, Driver driver*/, String vehicleNumber, String type, String category,
			String description, String location, Integer capacity, Double chargesPerKM, Double fixedCharges) {
		super();
		this.vehicleId = vehicleId;
		//this.driver = driver;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.location = location;
		this.capacity = capacity;
		this.chargesPerKM = chargesPerKM;
		this.fixedCharges = fixedCharges;
	}
	
	
	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public double getChargesPerKM() {
		return chargesPerKM;
	}

	public void setChargesPerKM(double chargesPerKM) {
		this.chargesPerKM = chargesPerKM;
	}

	public double getFixedCharges() {
		return fixedCharges;
	}

	public void setFixedCharges(double fixedCharges) {
		this.fixedCharges = fixedCharges;
	}
	
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	public boolean equals(Object obj) {
	      if (obj == this) {
	         return true;
	      }
	      if (!(obj instanceof Vehicle)) {
	         return false;
	      }
	      Vehicle vehicle = (Vehicle) obj;
	      return vehicleId.equals(vehicle.vehicleId) && Double.compare(chargesPerKM,vehicle.chargesPerKM) == 0;
	   }
	
	
}
