package com.cg.ovms.service;

import java.util.List;
import com.cg.ovms.dto.CustomerDto;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.exception.CustomerIdException;
import com.cg.ovms.exception.ValidateCustomerException;

public interface ICustomerService {

	public Customer updateCustomer(CustomerDto customerDto,Integer cid) throws CustomerIdException,ValidateCustomerException;
	public Customer viewCustomer(Integer customerId)throws CustomerIdException;
	public boolean removeCustomer(Integer customerId)throws CustomerIdException;
	public List<Customer> viewAllCustomer() throws CustomerIdException;
	public Customer addCustomer(CustomerDto customerDto)throws ValidateCustomerException;
	

	
}
