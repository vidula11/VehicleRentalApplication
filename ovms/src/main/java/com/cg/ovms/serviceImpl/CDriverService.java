package com.cg.ovms.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ovms.dto.DriverDto;
import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Driver;
import com.cg.ovms.exception.BookingIdException;
import com.cg.ovms.exception.DriverIdException;
import com.cg.ovms.exception.ValidateDriverException;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.IDriverRepository;
import com.cg.ovms.service.IDriverService;
import com.cg.ovms.util.RentalConstants;

@Service
public class CDriverService implements IDriverService{

	@Autowired
	private IDriverRepository driverDao;
	@Autowired
	private IBookingRepository bookingDao;
	
	
	@Override
	public Driver viewDriver(Integer driverId) throws DriverIdException{
		Optional<Driver> optDriver=driverDao.findById(driverId);
		if(!optDriver.isPresent())
			throw new DriverIdException(RentalConstants.DRIVER_NOT_FOUND);
		return optDriver.get();
	}
	
	@Override
	public boolean removeDriver(Integer driverId) throws DriverIdException {
		Optional<Driver> optDriver=driverDao.findById(driverId);
		if(!optDriver.isPresent())
			throw new DriverIdException(RentalConstants.DRIVER_NOT_FOUND);
		driverDao.delete(optDriver.get());
		return true;
	}
	
	@Override
	public Driver updateDriver(DriverDto driverDto) throws DriverIdException, ValidateDriverException{
		validateDriver(driverDto);
		Optional<Driver> optDriver=driverDao.findById(driverDto.getDriverId());
		if(!optDriver.isPresent()) 
			throw new DriverIdException(RentalConstants.DRIVER_NOT_FOUND);
		Driver driver=optDriver.get();
		driver.setFirstName(driverDto.getFirstName());
		driver.setLastName(driverDto.getLastName());
		driver.setContactNumber(driverDto.getContactNumber());
		driver.setEmail(driverDto.getEmail());
		driver.setAddress(driverDto.getAddress());
		driver.setChargesPerDay(driverDto.getChargesPerDay());
		driver.setLicenseNo(driverDto.getLicenseNo());
		Driver updatedDriver= driverDao.save(driver);
		return updatedDriver;
	}

	@Override
	public boolean cancelBooking(Integer driverId) throws DriverIdException, BookingIdException {
		Optional<Driver> optDriver=driverDao.findById(driverId);
		if(!optDriver.isPresent())
			throw new DriverIdException(RentalConstants.DRIVER_NOT_FOUND);
		Optional<Booking> optBooking=bookingDao.findById(driverId);
		if(!optBooking.isPresent())
			throw new BookingIdException(RentalConstants.BOOKING_NOT_FOUND);
		Driver d1=driverDao.findById(driverId).get();
		driverDao.delete(d1);
		bookingDao.delete(optBooking.get());
		return true;
	}
	

	@Override
	public Driver addDriver(DriverDto driverDto) throws ValidateDriverException {
		validateDriver(driverDto);
		Driver driver=new Driver();
		driver.setFirstName(driverDto.getFirstName());
		driver.setLastName(driverDto.getLastName());
		driver.setContactNumber(driverDto.getContactNumber());
		driver.setEmail(driverDto.getEmail());
		driver.setAddress(driverDto.getAddress());
		driver.setChargesPerDay(driverDto.getChargesPerDay());
		driver.setLicenseNo(driverDto.getLicenseNo());
		Driver savedDriver= driverDao.save(driver);
			
		return savedDriver;
		
	}
	
	public boolean validateDriver(DriverDto driverDto) throws ValidateDriverException{
		if(!driverDto.getFirstName().matches("[a-zA-Z]{1,15}"))
			throw new ValidateDriverException(RentalConstants.FIRST_NAME_CANNOT_BE_EMPTY);
		if(!driverDto.getLastName().matches("[a-zA-Z]{1,15}"))
			throw new ValidateDriverException(RentalConstants.LAST_NAME_CANNOT_BE_EMPTY);
		if(!driverDto.getContactNumber().matches("[6-9][0-9]{9}"))
			throw new ValidateDriverException(RentalConstants.MOBILE_CANNOT_BE_EMPTY);
		if(!driverDto.getEmail().matches("[a-zA-Z0-9]+@[a-z.]+"))
			throw new ValidateDriverException(RentalConstants.EMAIL_CANNOT_BE_EMPTY);
		if(!driverDto.getAddress().matches("[a-zA-Z0-9_.,]{1,40}"))
			throw new ValidateDriverException(RentalConstants.ADDRESS_CANNOT_BE_EMPTY);
		if(!driverDto.getLicenseNo().matches("[A-Z0-9]{1,10}"))
			throw new ValidateDriverException(RentalConstants.INVALID_LICENSENO);
		if(driverDto.getChargesPerDay()<=0.0)
		throw new ValidateDriverException(RentalConstants.CHARGES_PER_DAY_NUM);
		return true;
		}
	
	@Override
	public List<Driver> viewAllDriver() throws DriverIdException {
		List<Driver> driverlist=driverDao.findAll();
		if(driverlist.isEmpty())
			throw new DriverIdException(RentalConstants.DRIVER_NOT_FOUND);
		//sorted based on First Name
		driverlist.sort((a1,a2)->a1.getFirstName().compareTo(a2.getFirstName()));
		return driverlist;
	}
	
	
	
}
