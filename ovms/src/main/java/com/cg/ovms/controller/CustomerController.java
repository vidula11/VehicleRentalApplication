package com.cg.ovms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.dto.CustomerDto;
import com.cg.ovms.dto.SuccessMessageDto;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.exception.CustomerIdException;
import com.cg.ovms.exception.ValidateCustomerException;
import com.cg.ovms.service.ICustomerService;
import com.cg.ovms.util.RentalConstants;

@RestController
@RequestMapping("/customer")
//@CrossOrigin
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/add")
	public SuccessMessageDto addCustomer(@RequestBody CustomerDto customerDto) throws ValidateCustomerException {
		Customer customer=customerService.addCustomer(customerDto);
		return new SuccessMessageDto(RentalConstants.CUSTOMER_ADDED+customer.getCustomerId());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/remove/{cid}")
	public SuccessMessageDto removeCustomer(@PathVariable Integer cid) throws CustomerIdException {
		customerService.removeCustomer(cid);
		return new SuccessMessageDto(RentalConstants.CUSTOMER_REMOVED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/view/{cid}")
	public Customer viewCustomer(@PathVariable Integer cid) throws CustomerIdException {
		return customerService.viewCustomer(cid);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update/{cid}")
	public SuccessMessageDto updateCustomer(@RequestBody CustomerDto customerDto,@PathVariable Integer cid) throws CustomerIdException, ValidateCustomerException {
		Customer customer=customerService.updateCustomer(customerDto,cid);
		return new SuccessMessageDto(RentalConstants.CUSTOMER_UPDATED+customer.getCustomerId());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/viewAll")
	public List<Customer> viewAllCustomer() throws CustomerIdException {
		return customerService.viewAllCustomer();
	}
	
	

		
}
