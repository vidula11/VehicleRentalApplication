package com.cg.ovms.service;

import java.util.List;
import com.cg.ovms.dto.DriverDto;
import com.cg.ovms.entities.Driver;
import com.cg.ovms.exception.BookingIdException;
import com.cg.ovms.exception.DriverIdException;
import com.cg.ovms.exception.ValidateDriverException;

public interface IDriverService {

	public Driver addDriver(DriverDto driverDto)throws ValidateDriverException;
	public  boolean removeDriver(Integer driverId)throws DriverIdException;
	public Driver updateDriver(DriverDto driverDto)throws DriverIdException,ValidateDriverException;
	public Driver viewDriver(Integer driverId)throws DriverIdException;
	public boolean cancelBooking(Integer did)throws DriverIdException,BookingIdException; 
	public List<Driver> viewAllDriver() throws DriverIdException ;
}

