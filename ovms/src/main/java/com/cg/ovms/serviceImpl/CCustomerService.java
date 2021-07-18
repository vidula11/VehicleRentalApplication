package com.cg.ovms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ovms.dto.CustomerDto;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.exception.CustomerIdException;
import com.cg.ovms.exception.ValidateCustomerException;
import com.cg.ovms.repository.ICustomerRepository;
import com.cg.ovms.service.ICustomerService;
import com.cg.ovms.util.RentalConstants;

@Service
public class CCustomerService implements ICustomerService{

	@Autowired
	private ICustomerRepository customerDao;
	
	@Override
	public Customer updateCustomer(CustomerDto customerDto,Integer cid) throws CustomerIdException, ValidateCustomerException {
		validateCustomer(customerDto);
		
		Optional<Customer> optCustomer=customerDao.findById(cid);
		if(!optCustomer.isPresent()) 
			throw new CustomerIdException(RentalConstants.CUSTOMER_NOT_FOUND);
		Customer customer=optCustomer.get();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setEmailId(customerDto.getEmailId());
		customer.setAddress(customerDto.getAddress());

		Customer updatedCustomer= customerDao.save(customer);
		return updatedCustomer;
	}
	
	public boolean validateCustomer(CustomerDto customerDto) throws ValidateCustomerException{
		if(!customerDto.getFirstName().matches("[a-zA-Z]{1,15}"))
			throw new ValidateCustomerException(RentalConstants.FIRST_NAME_CANNOT_BE_EMPTY);
		if(!customerDto.getLastName().matches("[a-zA-Z]{1,15}"))
			throw new ValidateCustomerException(RentalConstants.LAST_NAME_CANNOT_BE_EMPTY);
		if(!customerDto.getMobileNumber().matches("[6-9][0-9]{9}"))
			throw new ValidateCustomerException(RentalConstants.MOBILE_CANNOT_BE_EMPTY);
		if(!customerDto.getEmailId().matches("[a-zA-Z0-9]+@[a-z.]+"))
			throw new ValidateCustomerException(RentalConstants.EMAIL_CANNOT_BE_EMPTY);
		if(!customerDto.getAddress().matches("[a-zA-Z0-9_.,]{1,40}"))
			throw new ValidateCustomerException(RentalConstants.ADDRESS_CANNOT_BE_EMPTY);
		return true;
		}
	
	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerIdException {
		Optional<Customer> optCustomer=customerDao.findById(customerId);
		if(!optCustomer.isPresent())
			throw new CustomerIdException(RentalConstants.CUSTOMER_NOT_FOUND);
		
		return optCustomer.get();
		
	}

	@Override
	public boolean removeCustomer(Integer customerId) throws CustomerIdException {
		Optional<Customer> optCustomer=customerDao.findById(customerId);
		if(!optCustomer.isPresent())
			throw new CustomerIdException(RentalConstants.CUSTOMER_NOT_FOUND);
		customerDao.delete(optCustomer.get());
		return true;
	}
	
	@Override
	public List<Customer> viewAllCustomer() throws CustomerIdException {
		List<Customer> customerlist=customerDao.findAll();
		if(customerlist.isEmpty())
			throw new CustomerIdException(RentalConstants.CUSTOMER_NOT_FOUND);
		//sorted based on First Name
		customerlist.sort((a1,a2)->a1.getFirstName().compareTo(a2.getFirstName()));
		return customerlist;
	}
	
	@Override
	public Customer addCustomer(CustomerDto customerDto)throws ValidateCustomerException {
		validateCustomer(customerDto);
		Customer customer=new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setEmailId(customerDto.getEmailId());
		customer.setAddress(customerDto.getAddress());
		Customer savedCustomer=customerDao.save(customer);
		return savedCustomer;
	}


}
