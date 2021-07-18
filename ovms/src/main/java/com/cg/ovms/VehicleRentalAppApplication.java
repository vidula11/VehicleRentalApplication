package com.cg.ovms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.*"})
@EnableJpaRepositories(basePackages = {"com.*"})
public class VehicleRentalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleRentalAppApplication.class, args);
		System.out.println("Vehicle Rental System main method executed");
		
	}

}
