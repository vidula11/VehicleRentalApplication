package com.cg.ovms.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ovms.dto.BookingDto;
import com.cg.ovms.dto.SuccessMessageDto;
import com.cg.ovms.entities.Booking;
import com.cg.ovms.exception.BookingAlreadyExistsException;
import com.cg.ovms.exception.BookingDateException;
import com.cg.ovms.exception.BookingIdException;
import com.cg.ovms.exception.CustomerIdException;
import com.cg.ovms.exception.ValidateBookingException;
import com.cg.ovms.exception.VehicleNotFoundException;
import com.cg.ovms.service.IBookingService;
import com.cg.ovms.util.RentalConstants;

@RestController
@RequestMapping("/booking")
@CrossOrigin("http://localhost:4200")
public class BookingController {

	@Autowired
	private IBookingService bookingService;
	
	@PostMapping("/add")
	public SuccessMessageDto addBooking(@RequestBody BookingDto bookingDto) throws BookingAlreadyExistsException, CustomerIdException, VehicleNotFoundException,  ValidateBookingException, BookingDateException {
		Booking booking=bookingService.addBooking(bookingDto);
		return new SuccessMessageDto(RentalConstants.BOOKING_ADDED+booking.getBookingId());
	}
	
	@DeleteMapping("/cancel/{bid}")
	public SuccessMessageDto cancelBooking(@PathVariable Integer bid) throws BookingIdException {
		 bookingService.cancelBooking(bid);
		 return new SuccessMessageDto(RentalConstants.BOOKING_REMOVED);
	}
	
	@PutMapping("/update")
	public SuccessMessageDto updateBooking(@RequestBody BookingDto bookingDto) throws BookingIdException, CustomerIdException, VehicleNotFoundException {
		Booking booking= bookingService.updateBooking(bookingDto);
		return new SuccessMessageDto(RentalConstants.BOOKING_UPDATED+booking.getBookingId());
	}
	
	@GetMapping("/view/{bid}")
	public Booking viewBooking(@PathVariable Integer bookingId) throws BookingIdException {
		return bookingService.viewBooking(bookingId);
	}
	
	@GetMapping("/viewAll")
	public List<Booking> viewAllBooking() throws BookingIdException {
		return bookingService.viewAllBooking();
	}
	/*
	 * 
	@GetMapping("/viewAllByDate/{date}")
	public List<Booking> viewAllBookingByDate(@PathVariable LocalDate bookingDate) {
		return bservice.viewAllBookingByDate(bookingDate);
	}
	@GetMapping("/viewAllByVehicle/{vid}")
	public ResponseEntity<?> viewAllBookingByVehicle(@PathVariable Integer vid) {
		return bservice.viewAllBookingByVehicle(vid);
	}
	*/
		
}

