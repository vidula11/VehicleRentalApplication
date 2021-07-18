package com.cg.ovms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ovms.dto.DriverDto;
import com.cg.ovms.dto.VehicleDto;
import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.DriverIdException;
import com.cg.ovms.exception.ValidateDriverException;
import com.cg.ovms.exception.ValidateVehicleException;
import com.cg.ovms.repository.IDriverRepository;
import com.cg.ovms.repository.IVehicleRepository;
import com.cg.ovms.serviceImpl.CDriverService;
import com.cg.ovms.serviceImpl.CVehicleService;

//@SpringBootApplication
@SpringBootTest
//@ContextConfiguration
@RunWith(SpringRunner.class)
public class JunitTesting {
	
	@Autowired
	private  IDriverRepository driverDao;
	
	@Autowired
	private  IVehicleRepository vehicleDao;
	
	@Autowired
	private CDriverService driverService;
	
	@Autowired
	private CVehicleService vehicleService;
	
	@Autowired
	private DriverDto tempDriver1;
	
	@Autowired
	private VehicleDto tempVehicle;
	
	@Autowired
	private Driver tempDriver2;
	@Autowired
	private Driver tempDriver3;
	
	Integer value=null;
	@Test
	@Order(1)
	 void addDriverTestValid() throws ValidateDriverException {
		tempDriver1.setFirstName("steve");
		tempDriver1.setLastName("smith");
		tempDriver1.setContactNumber("9999999999");
		tempDriver1.setEmail("v@gmail.com");
		tempDriver1.setAddress("Hyderabad");
		tempDriver1.setChargesPerDay(1000.0);
		tempDriver1.setLicenseNo("DL0010");
		tempDriver2=driverService.addDriver(tempDriver1);	
		value=tempDriver2.getDriverId();
		System.out.println(value);
		 List <Driver> dlist=driverDao.findAll();
		 tempDriver3=dlist.get(0);
		assertEquals(tempDriver2, tempDriver3);	
	}
	@Test
	@Order(2)
	 void addDriverTestValid2() throws ValidateDriverException {
		tempDriver1.setFirstName("rohit");
		tempDriver1.setLastName("chandra");
		tempDriver1.setContactNumber("9999994999");
		tempDriver1.setEmail("vi@gmail.com");
		tempDriver1.setAddress("Hyderabad");
		tempDriver1.setChargesPerDay(1200.0);
		tempDriver1.setLicenseNo("DL8010");
		tempDriver2=driverService.addDriver(tempDriver1);	
		 List <Driver> dlist=driverDao.findAll();
		 tempDriver3=dlist.get(0);
		 tempDriver3.setDriverId(232);		
		assertNotEquals(tempDriver2, tempDriver3);	
	}
	/*
	@Test
	@Order(3)
	 void addvehicleTestValid3() throws ValidateVehicleException, DriverIdException  {
		Vehicle vehicle2=new Vehicle();
		tempVehicle.setCapacity(40);
		tempVehicle.setCategory("ac");
		tempVehicle.setChargesPerKM(3.8);
		tempVehicle.setDescription("KalpanaTravels");
		tempVehicle.setFixedCharges(2.00);
		tempVehicle.setLocation("hyderabad");
		tempVehicle.setType("car");
		tempVehicle.setVehicleNumber("MH37PA0886");
		vehicle2= vehicleService.addVehicle(tempVehicle,value);	
		 List <Vehicle> vlist=vehicleDao.findAll();
		assertEquals(vehicle2,vlist.get(0));	
	}	
	
	@Test
	@Order(3)
	 void viewAllvehicleTestValid3() {
		 List <Vehicle> vlist =vehicleDao.findAll();
		assertThat(vlist).size().isGreaterThan(0);
		
	}	
	*/
}

