package com.cg.ovms.repository;


import java.util.List;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Payment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Integer>{
	List<Payment> findByBooking(Booking booking);
	//List<Payment> findByVehicle(Vehicle vehicle);
	
	
}
