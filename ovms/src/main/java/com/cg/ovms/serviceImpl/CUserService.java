package com.cg.ovms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.dto.UserDto;
import com.cg.ovms.entities.User;
import com.cg.ovms.exception.ValidateUserException;
import com.cg.ovms.repository.IUserRepository;
import com.cg.ovms.service.IUserService;
import com.cg.ovms.util.RentalConstants;

@Service
public class CUserService implements IUserService{

	@Autowired
	private IUserRepository userDao;
	
	@Override
	public  boolean validateUser(UserDto userDto) throws ValidateUserException {
		if(!userDto.getUserName().matches("[a-zA-Z0-9]{1,15}"))
			throw new ValidateUserException(RentalConstants.INVALID_USERNAME);
		if(!userDto.getPassword().matches("[a-zA-Z0-9*#@]{1,15}"))
			throw new ValidateUserException(RentalConstants.INVALID_PASSWORD);
		if(!userDto.getRole().matches("(admin|user)"))
			throw new ValidateUserException(RentalConstants.INVALID_ROLE);
		return true;
	}

	@Override
	public User addUser(UserDto userDto) throws ValidateUserException {
		validateUser(userDto);
		User user=new User();
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		User savedUser=userDao.save(user);
		return savedUser;
	}

	@Override
	public boolean removeUser(User user) {
		userDao.delete(user);
		return true;
	}

	@Override
	public User signOut(User user) {
		return null;
	}

}
