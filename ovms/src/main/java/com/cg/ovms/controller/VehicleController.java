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

import com.cg.ovms.dto.SuccessMessageDto;
import com.cg.ovms.dto.VehicleDto;
import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.DriverIdException;
import com.cg.ovms.exception.ValidateVehicleException;
import com.cg.ovms.exception.VehicleIdException;
import com.cg.ovms.service.IVehicleService;
import com.cg.ovms.util.RentalConstants;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {
	@Autowired
	private IVehicleService vehicleService;
	
	@PostMapping("/add")
	public SuccessMessageDto addVehicle(@RequestBody VehicleDto vehicleDto) throws ValidateVehicleException, DriverIdException {
		Vehicle vehicle=vehicleService.addVehicle(vehicleDto);
		return new SuccessMessageDto(RentalConstants.VEHICLE_ADDED+vehicle.getVehicleId());
	}
	
	
	@DeleteMapping("/cancel/{vid}")
	public SuccessMessageDto removeVehicle(@PathVariable Integer vid) throws VehicleIdException {
		vehicleService.removeVehicle(vid);
		return new SuccessMessageDto(RentalConstants.VEHICLE_REMOVED);
	}
	@PutMapping("/update/{vid}")
	public SuccessMessageDto updateVehicle(@RequestBody VehicleDto vehicleDto,@PathVariable Integer vid) throws VehicleIdException, ValidateVehicleException {
			Vehicle vehicle=vehicleService.updateVehicle(vehicleDto,vid);
			return new SuccessMessageDto(RentalConstants.VEHICLE_UPDATED+vehicle.getVehicleId());

	}
	@GetMapping("/view/{vid}")
	public Vehicle viewVehicle(@PathVariable Integer vid) throws VehicleIdException {
		return vehicleService.viewVehicle(vid);
	}
	@GetMapping("/viewall")
	public List<Vehicle> viewVehicle() throws VehicleIdException {
		return vehicleService.viewAllVehicles();
	}
	
	
}
