package com.cg.ovms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ovms.entities.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle,Integer>{

	List<Vehicle> findByType(String vtype);
	List<Vehicle> findByLocation(String location);
	
}
