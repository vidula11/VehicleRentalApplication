package com.cg.ovms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ovms.dto.VehicleDto;
import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.DriverIdException;
import com.cg.ovms.exception.ValidateVehicleException;
import com.cg.ovms.exception.VehicleIdException;
import com.cg.ovms.repository.IDriverRepository;
import com.cg.ovms.repository.IVehicleRepository;
import com.cg.ovms.service.IVehicleService;
import com.cg.ovms.util.RentalConstants;

@Service
public class CVehicleService implements IVehicleService{
	@Autowired
	private IVehicleRepository vehicleDao;
	@Autowired 
	private IDriverRepository driverDao;
	
	
	public boolean validateVehicle(VehicleDto vehicleDto) throws ValidateVehicleException{
		if(!vehicleDto.getVehicleNumber().matches("[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}"))
			throw new ValidateVehicleException(RentalConstants.INVALID_VEHICLE_NUMBER);
		if(!vehicleDto.getType().matches("(car|bus)"))
			throw new ValidateVehicleException(RentalConstants.INVALID_VEHICLE_TYPE);
		if(!vehicleDto.getCategory().matches("(AC|NON-AC)"))
			throw new ValidateVehicleException(RentalConstants.INVALID_VEHICLE_CATEGORY);
		if(!vehicleDto.getDescription().matches("[a-zA-Z][a-zA-Z0-9]{1,20}"))
			throw new ValidateVehicleException(RentalConstants.INVALID_VEHICLE_DESCRIPTION);
		if(!vehicleDto.getLocation().matches("[a-zA-Z]{1,15}"))
			throw new ValidateVehicleException(RentalConstants.INVALID_VEHICLE_LOCATION);
		if(!(vehicleDto.getCapacity()>=0))
			throw new ValidateVehicleException(RentalConstants.INVALID_VEHICLE_CAPACITY);
		if(!(vehicleDto.getChargesPerKM()>=0))
			throw new ValidateVehicleException(RentalConstants.INVALID_VEHICLE_CH_KM);
		if(!(vehicleDto.getFixedCharges()>0))
			throw new ValidateVehicleException(RentalConstants.INVALID_VEHICLE_FX_CH);
		
		return true;
		}

	
	
	@Override
	public Vehicle updateVehicle(VehicleDto vehicleDto,Integer vid) throws VehicleIdException, ValidateVehicleException{
		validateVehicle(vehicleDto);
		Optional<Vehicle> optVehicle=vehicleDao.findById(vid);
		if(!optVehicle.isPresent()) 
			throw new VehicleIdException(RentalConstants.VEHICLE_NOT_FOUND);
		
		Vehicle vehicle=optVehicle.get();
		vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
		vehicle.setType(vehicleDto.getType());
		vehicle.setCapacity(vehicleDto.getCapacity());
		vehicle.setCategory(vehicleDto.getCategory());
		vehicle.setDescription(vehicleDto.getDescription());
		vehicle.setLocation(vehicleDto.getLocation());
		vehicle.setChargesPerKM(vehicleDto.getChargesPerKM());
		vehicle.setFixedCharges(vehicleDto.getFixedCharges());
		Vehicle updatedVehicle= vehicleDao.save(vehicle);
		
		return updatedVehicle;
		
	}
	
	@Override
	public Vehicle viewVehicle(Integer vehicleId) throws VehicleIdException  {
	
		Optional<Vehicle> optVehicle=vehicleDao.findById(vehicleId);
		if(!optVehicle.isPresent())
			throw new VehicleIdException(RentalConstants.VEHICLE_NOT_FOUND);
		return optVehicle.get();
	}
	
	@Override
	public boolean removeVehicle(Integer vid) throws VehicleIdException {
		Optional<Vehicle> optVehicle=vehicleDao.findById(vid);
		if(!optVehicle.isPresent())
			throw new VehicleIdException(RentalConstants.VEHICLE_NOT_FOUND);
		vehicleDao.delete(optVehicle.get());
		return true;
		
	}
	
	
	@Override
	public Vehicle addVehicle(VehicleDto vehicleDto) throws ValidateVehicleException, DriverIdException{
		validateVehicle(vehicleDto);
		
		/*Optional<Driver> optDriver=driverDao.findById(vehicleDto.getDriverId());
		if(!optDriver.isPresent())
			throw new DriverIdException(RentalConstants.DRIVER_NOT_FOUND);*/
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
		vehicle.setType(vehicleDto.getType());
		vehicle.setCategory(vehicleDto.getCategory());
		vehicle.setCapacity(vehicleDto.getCapacity());
		vehicle.setDescription(vehicleDto.getDescription());
		vehicle.setLocation(vehicleDto.getLocation());
		vehicle.setChargesPerKM(vehicleDto.getChargesPerKM());
		vehicle.setFixedCharges(vehicleDto.getFixedCharges());
		//vehicle.setDriver(optDriver.get());
		Vehicle savedVehicle=vehicleDao.save(vehicle);
		return savedVehicle;
	}

	@Override
	public List<Vehicle> viewAllVehicles() throws VehicleIdException {
		List<Vehicle> vehicleList=vehicleDao.findAll();
		if(vehicleList.isEmpty())
			throw new VehicleIdException(RentalConstants.VEHICLE_NOT_FOUND);
 		vehicleList.sort((a1,a2)->a1.getLocation().compareTo(a2.getLocation()));
		return vehicleList;
	}


	
	
	


}

