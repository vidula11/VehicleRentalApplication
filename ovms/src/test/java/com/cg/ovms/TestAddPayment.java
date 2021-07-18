package com.cg.ovms;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ovms.dto.PaymentDto;
import com.cg.ovms.entities.Payment;
import com.cg.ovms.exception.BookingIdException;
import com.cg.ovms.exception.ValidatePaymentException;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.IPaymentRepository;
import com.cg.ovms.service.IPaymentService;
import com.cg.ovms.serviceImpl.CPaymentService;

@SpringBootTest
public class TestAddPayment{
	
	@Mock
	private IPaymentRepository prepo;
	@Mock
	private IBookingRepository brepo;
	@InjectMocks
	private IPaymentService pservice=new CPaymentService();
	
	@BeforeEach
	public void berforeEach() {
		when(prepo.findById(1)).thenReturn(Optional.of(new Payment()));
		when(prepo.findById(2)).thenReturn(Optional.empty());
		when(prepo.save(any(Payment.class))).thenReturn(new Payment());
	}
	
	@Test
	public void addPaymentTest1() throws ValidatePaymentException {
		PaymentDto paymentDto =new PaymentDto(1,"offline",LocalDate.of(2021, 05, 30),1,"done");
		assertThrows(ValidatePaymentException.class,()->pservice.addPayment(paymentDto));
	}
	
	@Test
	public void addPaymentTest2() throws ValidatePaymentException {
		PaymentDto paymentDto =new PaymentDto(1,"offline",LocalDate.of(2021, 05, 30),1,"done");
		assertThrows(ValidatePaymentException.class,()->pservice.addPayment(paymentDto));
	}
	
	
	@Test
	public void addPaymentTest3() throws BookingIdException{
		PaymentDto paymentDto =new PaymentDto(2,"cash",LocalDate.of(2021, 05, 30),1,"Done");
		assertThrows(BookingIdException.class,()->pservice.addPayment(paymentDto));
	}
	
	@Test
	public void addPaymentTest4() throws BookingIdException{
		PaymentDto paymentDto =new PaymentDto(1,"cash",LocalDate.of(2021, 05, 30),1,"Done");
		assertThrows(BookingIdException.class,()->pservice.addPayment(paymentDto));
	}
	
}
