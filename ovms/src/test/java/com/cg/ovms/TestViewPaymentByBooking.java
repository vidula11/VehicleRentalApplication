package com.cg.ovms;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.exception.BookingIdException;
import com.cg.ovms.exception.PaymentIdException;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.IPaymentRepository;
import com.cg.ovms.service.IPaymentService;
import com.cg.ovms.serviceImpl.CPaymentService;

@SpringBootTest
public class TestViewPaymentByBooking {

	@Mock
	private IPaymentRepository prepo;
	@Mock
	private IBookingRepository brepo;
	@InjectMocks
	private IPaymentService pservice=new CPaymentService();
		
	@BeforeEach
	protected void beforeEach() {
		when(brepo.findById(1)).thenReturn(Optional.of(new Booking()));
		when(brepo.findById(2)).thenReturn(Optional.empty());
	}
	
	

	@Test
	protected void testViewPaymentByBooking1() throws BookingIdException, PaymentIdException {
		assertThrows(PaymentIdException.class,()->pservice.viewPaymentByBooking(1));
	}
	@Test
	protected void testViewPaymentByBooking2() throws BookingIdException, PaymentIdException {
		assertThrows(BookingIdException.class,()->pservice.viewPaymentByBooking(2));
	}
}
