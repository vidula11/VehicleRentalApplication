package com.cg.ovms.service;

import com.cg.ovms.dto.UserDto;
import com.cg.ovms.entities.User;
import com.cg.ovms.exception.ValidateUserException;

public interface IUserService {

	public boolean validateUser(UserDto userDto)throws ValidateUserException;
	public User addUser(UserDto userDto) throws ValidateUserException;
	public boolean removeUser(User user);
	public User signOut(User user);
}
