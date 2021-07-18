package com.cg.ovms.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.ovms.dto.PaymentDto;
import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Payment;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.BookingIdException;
import com.cg.ovms.exception.PaymentDoneForBookingException;
import com.cg.ovms.exception.PaymentIdException;
import com.cg.ovms.exception.ValidatePaymentException;
import com.cg.ovms.exception.VehicleNotFoundException;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.IPaymentRepository;
import com.cg.ovms.repository.IVehicleRepository;
import com.cg.ovms.service.IPaymentService;
import com.cg.ovms.util.RentalConstants;

@Service
public class CPaymentService implements IPaymentService{

	@Autowired
	private IPaymentRepository prepo;
	@Autowired
	private IBookingRepository brepo;
	@Autowired
	private IVehicleRepository vrepo;
	/*
	@Override
	public Booking addPayment(PaymentDto paymentDto) throws BookingIdException,PaymentDoneForBookingException{
		Optional<Booking> b1 = brepo.findById(paymentDto.getBookingId());
		if(!b1.isPresent())
			throw new BookingIdException(RentalConstants.BOOKING_NOT_FOUND);
		List<Payment> p=prepo.findByBooking(b1.get());
		if(!p.isEmpty())
			throw new PaymentDoneForBookingException(RentalConstants.PAYMENT_DONE_FOR_BOOKING);
		Payment p1=new Payment();
		p1.setPaymentDate(paymentDto.getPaymentDate());
		p1.setPaymentId(paymentDto.getPaymentId());
		p1.setPaymentMode(paymentDto.getPaymentMode());
		p1.setPaymentStatus(paymentDto.getPaymentStatus());
		p1.setBooking(b1.get());
		Payment p2=prepo.save(p1);
		b1.get().setPayment(p2);
		return p2.getBooking();
	}
	*/
	@Override
	public ResponseEntity<String> cancelPayment(Integer pid) throws PaymentIdException {
		Optional<Payment> p1=prepo.findById(pid);
		if(!p1.isPresent())
			throw new PaymentIdException(RentalConstants.PAYMENT_NOT_FOUND);
		prepo.delete(p1.get());
		String response="Payment with id"+pid+"is deleted";
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<?> viewPaymentByBooking(Integer bid) throws BookingIdException, PaymentIdException {
		ResponseEntity<?> resp=null;
		Optional<Booking> b1=brepo.findById(bid);
		if(!b1.isPresent())
			throw new BookingIdException(RentalConstants.BOOKING_NOT_FOUND);
		
			List<Payment> p1=prepo.findByBooking(b1.get());
			if(p1.isEmpty())
				throw new PaymentIdException(RentalConstants.PAYMENT_NOT_FOUND);
			
			resp=new ResponseEntity<List<Payment>>(p1,HttpStatus.OK);		
		return resp;		
}
	@Override
	public ResponseEntity<?> viewAllPaymentsByVehicle(Integer vid) throws VehicleNotFoundException, BookingIdException, PaymentIdException {
		ResponseEntity<?> resp=null;
	
		Optional<Vehicle> v1=vrepo.findById(vid);
		if(!v1.isPresent())
			throw new VehicleNotFoundException(RentalConstants.VEHICLE_NOT_FOUND);
		Optional<Booking> b1=brepo.findByVehicle(v1.get());
		if(!b1.isPresent())
			throw new BookingIdException(RentalConstants.BOOKING_NOT_FOUND);
		
			List<Payment> p1=prepo.findByBooking(b1.get());
			if(p1.isEmpty())
				throw new PaymentIdException(RentalConstants.PAYMENT_NOT_FOUND);
			resp=new ResponseEntity<List<Payment>>(p1,HttpStatus.OK);
			
		return resp;		
	}
	
	public boolean validatePayment(PaymentDto paymentDto) throws ValidatePaymentException{
		
		if(!paymentDto.getPaymentMode().matches("(online|offline)"))
			throw new ValidatePaymentException(RentalConstants.PAYMENT_TYPE_INVALID);
		if(!paymentDto.getPaymentStatus().matches("(Pending|Done)"))
			throw new ValidatePaymentException(RentalConstants.PAYMENT_STATUS_INVALID);

		return true;
		}

	@Override
	public double calculateMonthlyRevenue(LocalDate d1, LocalDate d2) {
		//double d=prepo.getTotalPayment(d1,d2);
		return 0;
	}

	@Override
	public double calculateTotalPayment(Integer v) {
		
		return 0;
	}

	@Override
	public Booking addPayment(PaymentDto paymentDto) throws BookingIdException, PaymentDoneForBookingException {
		// TODO Auto-generated method stub
		return null;
	}
	


}
