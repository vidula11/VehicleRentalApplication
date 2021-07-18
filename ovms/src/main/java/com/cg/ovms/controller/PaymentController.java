package com.cg.ovms.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.dto.PaymentDto;
import com.cg.ovms.dto.SuccessMessageDto;
import com.cg.ovms.entities.Booking;
import com.cg.ovms.exception.BookingIdException;
import com.cg.ovms.exception.PaymentDoneForBookingException;
import com.cg.ovms.exception.PaymentIdException;
import com.cg.ovms.exception.VehicleNotFoundException;
import com.cg.ovms.service.IPaymentService;
import com.cg.ovms.util.RentalConstants;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {

	@Autowired
	private IPaymentService pservice;
	@PostMapping("/add")
	public SuccessMessageDto addPayment(@RequestBody PaymentDto payment) throws BookingIdException, PaymentDoneForBookingException {
		Booking booking=pservice.addPayment(payment);
		return new SuccessMessageDto(RentalConstants.PAYMENT_ADDED+booking);
	}
	@DeleteMapping("/cancel/{pid}")
	public SuccessMessageDto cancelPayment(@PathVariable Integer pid) throws PaymentIdException {
		ResponseEntity<String> resp=pservice.cancelPayment(pid);
		return new SuccessMessageDto(RentalConstants.PAYMENT_REMOVED+resp);
	}
	@GetMapping("/viewByBooking/{bid}")
	public ResponseEntity<?> viewPaymentByBooking(@PathVariable Integer bid) throws BookingIdException, PaymentIdException {
		return pservice.viewPaymentByBooking(bid);
	}
	@GetMapping("/viewByVehicle/{vid}")
	public ResponseEntity<?> viewAllPaymentsByVehicle(@PathVariable Integer vid) throws VehicleNotFoundException, BookingIdException, PaymentIdException {
		return pservice.viewAllPaymentsByVehicle(vid);
	}
	@GetMapping("/calcMonthlyReven/{d1}/{d2}")
	public double calculateMonthlyRevenue(@PathVariable(value="d1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d1, @PathVariable(value="d2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d2) {
		return pservice.calculateMonthlyRevenue(d1, d2);
	}
	@GetMapping("/calcTotalPmntByVehicle/{v}")
	public double calculateTotalPayment(@PathVariable Integer v) {
		return pservice.calculateTotalPayment(v);
	}
	
	}
