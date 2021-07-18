package com.cg.ovms;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.BookingIdException;
import com.cg.ovms.exception.PaymentIdException;
import com.cg.ovms.exception.VehicleNotFoundException;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.IPaymentRepository;
import com.cg.ovms.repository.IVehicleRepository;
import com.cg.ovms.service.IPaymentService;
import com.cg.ovms.serviceImpl.CPaymentService;

@SpringBootTest
public class TestViewPaymentByVehicle {

	@Mock
	private IPaymentRepository prepo;
	@Mock
	private IBookingRepository brepo;
	@Mock
	private IVehicleRepository vrepo;
	
	
	@InjectMocks
	private IPaymentService pservice=new CPaymentService();
		
	@BeforeEach
	protected void beforeEach() {
		when(vrepo.findById(1)).thenReturn(Optional.of(new Vehicle()));
		when(vrepo.findById(2)).thenReturn(Optional.empty());
		when(vrepo.findById(3)).thenReturn(Optional.of(new Vehicle()));
	}
	
	

	@Test
	protected void testViewPaymentByVehicle1() throws VehicleNotFoundException, BookingIdException, PaymentIdException {
		assertThrows(BookingIdException.class,()->pservice.viewAllPaymentsByVehicle(1));
	}
	@Test
	protected void testViewPaymentByVehicle2() throws VehicleNotFoundException, BookingIdException, PaymentIdException {
		assertThrows(VehicleNotFoundException.class,()->pservice.viewAllPaymentsByVehicle(2));
	}
	@Test
	protected void testViewPaymentByVehicle3() throws VehicleNotFoundException, BookingIdException, PaymentIdException {
		assertThrows(BookingIdException.class,()->pservice.viewAllPaymentsByVehicle(3));
	}
	
}