package com.cg.ovms.service;

import java.util.List;
import com.cg.ovms.dto.BookingDto;
import com.cg.ovms.entities.Booking;
import com.cg.ovms.exception.BookingAlreadyExistsException;
import com.cg.ovms.exception.BookingDateException;
import com.cg.ovms.exception.BookingIdException;
import com.cg.ovms.exception.CustomerIdException;
import com.cg.ovms.exception.ValidateBookingException;
import com.cg.ovms.exception.VehicleNotFoundException;


public interface IBookingService {

	public Booking addBooking(BookingDto bookingDto)throws BookingAlreadyExistsException,CustomerIdException,VehicleNotFoundException,ValidateBookingException,BookingDateException;
	
	public boolean cancelBooking(Integer bookingId)throws BookingIdException;
	public Booking updateBooking(BookingDto bookingDto)throws BookingIdException,CustomerIdException,VehicleNotFoundException;
	public Booking viewBooking(Integer bookingId)throws BookingIdException;
	public List<Booking> viewAllBooking()throws BookingIdException;
	public List<Booking> viewAllBookingByVehicle(Integer vehicleId);

}
