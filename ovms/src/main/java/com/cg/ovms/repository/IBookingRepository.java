package com.cg.ovms.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.entities.Vehicle;

@Repository
public interface IBookingRepository extends JpaRepository<Booking,Integer>{

	List<Booking> findByBookingDate(LocalDate date);
	List<Booking> findByCustomer(Customer customer);
	Optional<Booking> findByVehicle(Vehicle vehicle);
	
}
