package com.cg.ovms.dto;

import org.springframework.stereotype.Component;

@Component
public class VehicleDto {

	private Integer vehicleId;
	//foreign key
	private Integer DriverId;

	private String vehicleNumber;
	private String type;//car//bus
	private String category; //ac or nonac
	private String description;
	private String location;
	private Integer capacity;
	private Double chargesPerKM;
	private Double fixedCharges;
	
	
	public VehicleDto() {
		super();
	}










	

	public Integer getVehicleId() {
		return vehicleId;
	}












	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}












	public VehicleDto(Integer driverId, String vehicleNumber, String type, String category, String description,
			String location, Integer capacity, Double chargesPerKM, Double fixedCharges) {
		super();
		DriverId = driverId;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.location = location;
		this.capacity = capacity;
		this.chargesPerKM = chargesPerKM;
		this.fixedCharges = fixedCharges;
	}












	public Integer getDriverId() {
		return DriverId;
	}


	public void setDriverId(Integer driverId) {
		DriverId = driverId;
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


	public Double getChargesPerKM() {
		return chargesPerKM;
	}


	public void setChargesPerKM(Double chargesPerKM) {
		this.chargesPerKM = chargesPerKM;
	}


	public Double getFixedCharges() {
		return fixedCharges;
	}


	public void setFixedCharges(Double fixedCharges) {
		this.fixedCharges = fixedCharges;
	}
	
	
	
	
}
