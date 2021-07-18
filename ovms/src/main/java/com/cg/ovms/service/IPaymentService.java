package com.cg.ovms.service;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;

import com.cg.ovms.dto.PaymentDto;
import com.cg.ovms.entities.Booking;
import com.cg.ovms.exception.BookingIdException;
import com.cg.ovms.exception.PaymentDoneForBookingException;
import com.cg.ovms.exception.PaymentIdException;
import com.cg.ovms.exception.VehicleNotFoundException;

public interface IPaymentService {

	public Booking addPayment(PaymentDto paymentDto) throws BookingIdException, PaymentDoneForBookingException;
	public ResponseEntity<String> cancelPayment(Integer pid) throws PaymentIdException;
	public ResponseEntity<?> viewPaymentByBooking(Integer bid) throws BookingIdException, PaymentIdException;
	public ResponseEntity<?> viewAllPaymentsByVehicle(Integer vid) throws VehicleNotFoundException, BookingIdException, PaymentIdException;
	public double calculateMonthlyRevenue(LocalDate d1,LocalDate d2);
	public double calculateTotalPayment(Integer v);
	
}
 