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

import com.cg.ovms.dto.DriverDto;
import com.cg.ovms.dto.SuccessMessageDto;
import com.cg.ovms.entities.Driver;
import com.cg.ovms.exception.DriverIdException;
import com.cg.ovms.exception.ValidateDriverException;
import com.cg.ovms.service.IDriverService;
import com.cg.ovms.util.RentalConstants;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
	
		@Autowired
		private IDriverService driverService;
		@PostMapping("/add")
		public SuccessMessageDto addDriver(@RequestBody DriverDto driverDto) throws ValidateDriverException
		{
			Driver driver= driverService.addDriver(driverDto);
			return new SuccessMessageDto(RentalConstants.DRIVER_ADDED+ driver.getDriverId());
		}
		
		@DeleteMapping("/remove/{did}")
		public SuccessMessageDto removeAddress(@PathVariable Integer did) throws DriverIdException
		{
			driverService.removeDriver(did);
			return new SuccessMessageDto(RentalConstants.DRIVER_REMOVED);
		}
		
		@PutMapping("/update")
		public SuccessMessageDto updateDriver(@RequestBody DriverDto driverDto)throws DriverIdException, ValidateDriverException {
			Driver driver=driverService.updateDriver(driverDto);
			return new SuccessMessageDto(RentalConstants.DRIVER_UPDATED+driver.getDriverId());
		}
		
		@GetMapping("/view/{did}")
		public Driver viewDriver(@PathVariable Integer did) throws DriverIdException 
		{
			return driverService.viewDriver(did);	
		}
		
		@GetMapping("/viewAll")
		public List<Driver> viewAllDriver() throws DriverIdException{
			return driverService.viewAllDriver();
		}
	}
