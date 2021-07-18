package com.cg.ovms.dto;

import java.time.LocalDate;


public class BookingDto {
	
	//foreign key 1
	private Integer customerId;
	//foreign key 2
	private Integer vehicleId;
	//foreign key 3
	
	//primary key
	private Integer bookingId;
	
	private LocalDate bookingDate;
	private LocalDate bookedTillDate;
	private String bookingDescription;
	private Double distance;
	
	
	
	public BookingDto(Integer customerId, Integer vehicleId, Integer bookingId, LocalDate bookingDate,
			LocalDate bookedTillDate, String bookingDescription, Double distance) {
		super();
		this.customerId = customerId;
		this.vehicleId = vehicleId;
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookedTillDate = bookedTillDate;
		this.bookingDescription = bookingDescription;
		this.distance = distance;
	}
		
	
	
	
	public BookingDto() {
		super();
	}




	public BookingDto(Integer customerId, Integer vehicleId, LocalDate bookingDate, LocalDate bookedTillDate,
			String bookingDescription, Double distance) {
		super();
		this.customerId = customerId;
		this.vehicleId = vehicleId;
		this.bookingDate = bookingDate;
		this.bookedTillDate = bookedTillDate;
		this.bookingDescription = bookingDescription;
		this.distance = distance;
	}




	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDate getBookedTillDate() {
		return bookedTillDate;
	}
	public void setBookedTillDate(LocalDate bookedTillDate) {
		this.bookedTillDate = bookedTillDate;
	}
	public String getBookingDescription() {
		return bookingDescription;
	}
	public void setBookingDescription(String bookingDescription) {
		this.bookingDescription = bookingDescription;
	}
	
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	

}
