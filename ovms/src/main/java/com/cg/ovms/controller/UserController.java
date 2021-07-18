package com.cg.ovms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ovms.dto.SuccessMessageDto;
import com.cg.ovms.dto.UserDto;
import com.cg.ovms.entities.User;
import com.cg.ovms.exception.ValidateUserException;
import com.cg.ovms.service.IUserService;
import com.cg.ovms.util.RentalConstants;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private IUserService userService;
	@GetMapping("/validate")
	public boolean validateUser(UserDto userDto) throws ValidateUserException {
		return userService.validateUser(userDto);
	}
	@PostMapping("/add")
	public SuccessMessageDto addUser(@RequestBody UserDto userDto) throws ValidateUserException {
		userService.addUser(userDto);
		return new SuccessMessageDto(RentalConstants.USER_ADDED);
	}
	
	@DeleteMapping("/remove")
	public SuccessMessageDto removeCustomer(@RequestBody User user){
		userService.removeUser(user);
		return new SuccessMessageDto(RentalConstants.USER_REMOVED);
	}
	
	@GetMapping("/signout")
	public User signOut(User user) {
		return userService.signOut(user);
	}
	
}
