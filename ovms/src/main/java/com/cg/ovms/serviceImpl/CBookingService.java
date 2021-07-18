package com.cg.ovms.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ovms.dto.BookingDto;
import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;

import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.BookingAlreadyExistsException;
import com.cg.ovms.exception.BookingDateException;
import com.cg.ovms.exception.BookingIdException;
import com.cg.ovms.exception.CustomerIdException;

import com.cg.ovms.exception.ValidateBookingException;
import com.cg.ovms.exception.VehicleNotFoundException;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.ICustomerRepository;
import com.cg.ovms.repository.IVehicleRepository;
import com.cg.ovms.service.IBookingService;
import com.cg.ovms.util.RentalConstants;
@Transactional
@Service
public class CBookingService implements IBookingService{

	@Autowired
	private IBookingRepository bookingDao;
	@Autowired
	private ICustomerRepository customerDao;
	@Autowired
	private IVehicleRepository vehicleDao;
	
	
	
	public boolean validateBooking(BookingDto bookingDto) throws ValidateBookingException{
	//	if(!bookingDto.getBookingDate().matches(LocalDate.now()))
	//		throw new ValidateBookingException(RentalConstants.FIRST_NAME_CANNOT_BE_EMPTY);
	//	if(!bookingDto.getBookedTillDate().matches())
	//		throw new ValidateBookingException(RentalConstants.LAST_NAME_CANNOT_BE_EMPTY);
		
		/*
		if(!bookingDto.getBookingDescription().matches("[a-zA-Z0-9 ]{1,30}"))
			throw new ValidateBookingException(RentalConstants.BOOKING_DESC_MSG);
		*/
		if(bookingDto.getDistance()<=0)
			throw new ValidateBookingException(RentalConstants.DISTANCE_CANNOT_BE_ZERO);
		
		return true;
		}
	
	
	@Override
	public Booking updateBooking(BookingDto bookingDto) throws BookingIdException, CustomerIdException, VehicleNotFoundException {
		Optional<Booking> optBooking=bookingDao.findById(bookingDto.getBookingId());
		if(!optBooking.isPresent())
			throw new BookingIdException(RentalConstants.BOOKING_NOT_FOUND);
		
		Optional<Customer> optCustomer=customerDao.findById(bookingDto.getCustomerId());
		if(!optCustomer.isPresent())
			throw new CustomerIdException(RentalConstants.CUSTOMER_NOT_FOUND);
		
		Optional<Vehicle> optVehicle=vehicleDao.findById(bookingDto.getVehicleId());
		if(!optVehicle.isPresent())
			throw new VehicleNotFoundException(RentalConstants.VEHICLE_NOT_FOUND);

		Booking booking=optBooking.get();
		Customer customer=optCustomer.get();
		Vehicle vehicle=optVehicle.get();
		booking.setBookingDate(bookingDto.getBookingDate());
		booking.setBookedTillDate(bookingDto.getBookedTillDate());
		booking.setBookingDescription(bookingDto.getBookingDescription());
		//booking.setTotalCost(bookingDto.getTotalCost());
		booking.setDistance(bookingDto.getDistance());
		booking.setCustomer(customer);
		booking.setVehicle(vehicle);
		
		Booking updatedBooking=bookingDao.save(booking);
		
		return updatedBooking;
	}
	
	@Override
	public boolean cancelBooking(Integer bookingId)throws BookingIdException {
		Optional<Booking> optBooking=bookingDao.findById(bookingId);
		if(!optBooking.isPresent())
			throw new BookingIdException(RentalConstants.BOOKING_NOT_FOUND);
		bookingDao.delete(optBooking.get());
		return true;
	}
	
	@Override
	public List<Booking> viewAllBooking() throws BookingIdException {
		List<Booking> bookingList=bookingDao.findAll();
		if(bookingList.isEmpty())
			throw new BookingIdException(RentalConstants.BOOKING_NOT_FOUND);
		return bookingList;
	}
	
	@Override
	public Booking viewBooking(Integer bookingId) throws BookingIdException {
		Optional<Booking> optBooking=bookingDao.findById(bookingId);
		if(!optBooking.isPresent())
			throw new BookingIdException(RentalConstants.BOOKING_NOT_FOUND);
		return optBooking.get();
	}
	
	@Override

	public Booking addBooking(BookingDto bookingDto) throws BookingAlreadyExistsException, CustomerIdException, VehicleNotFoundException,  ValidateBookingException, BookingDateException {
		validateBooking(bookingDto);
		//Optional<Booking> optBooking=bookingDao.findById(bookingDto.getBookingId());
		//if(optBooking.isPresent())
		//	throw new BookingAlreadyExistsException(RentalConstants.BOOKING_ALREADY_EXISTS);
		Optional<Customer> optCustomer=customerDao.findById(bookingDto.getCustomerId());
		if(!optCustomer.isPresent())
			throw new CustomerIdException(RentalConstants.CUSTOMER_NOT_FOUND);
		
		Optional<Vehicle> optVehicle=vehicleDao.findById(bookingDto.getVehicleId());
		if(!optVehicle.isPresent())
			throw new VehicleNotFoundException(RentalConstants.VEHICLE_NOT_FOUND);
	if(bookingDto.getBookingDate().isBefore(LocalDate.now()))
			throw new BookingDateException(RentalConstants.BOOKING_DATE_INVALID);
	
		
		//Optional<Payment> optPayment=paymentDao.findById(bookingDto.getPayment().getPaymentId());
		//if(optPayment.isPresent())
			//throw new PaymentIdException(RentalConstants.PAYMENT_ALREADY_EXISTS);
		Booking booking=new Booking();
		booking.setBookingDate(LocalDate.now());
		booking.setBookedTillDate(bookingDto.getBookedTillDate());
		booking.setBookingDescription(bookingDto.getBookingDescription());
		booking.setTotalCost(optVehicle.get().getChargesPerKM()*bookingDto.getDistance()+optVehicle.get().getFixedCharges());
		booking.setDistance(bookingDto.getDistance());
		//booking.getCustomer().setCustomerId(bookingDto.getCustomerId());
		//booking.getVehicle().setVehicleId(bookingDto.getVehicleId());
		booking.setCustomer(optCustomer.get());
		//optVehicle.setBookedStatus(true);
		booking.setVehicle(optVehicle.get());
		
		Booking savedBooking=bookingDao.save(booking);
		return savedBooking;
	}
	
	
	@Override
	public List<Booking> viewAllBookingByVehicle(Integer vehicleId) {
		return null;
	}
	
}
	