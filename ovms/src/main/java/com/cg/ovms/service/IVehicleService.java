package com.cg.ovms.service;

import java.util.List;
import com.cg.ovms.dto.VehicleDto;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.DriverIdException;
import com.cg.ovms.exception.ValidateVehicleException;
import com.cg.ovms.exception.VehicleIdException;

public interface IVehicleService {
	
	public Vehicle addVehicle(VehicleDto vehicleDto) throws ValidateVehicleException,DriverIdException;
	public boolean removeVehicle(Integer vid)throws VehicleIdException;
	public Vehicle updateVehicle(VehicleDto vehicleDto,Integer vid)throws VehicleIdException,ValidateVehicleException;
	public Vehicle viewVehicle(Integer vid)throws VehicleIdException;
	public List<Vehicle> viewAllVehicles()throws VehicleIdException;



}
