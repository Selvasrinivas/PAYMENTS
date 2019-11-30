package com.cognizant.billpaymentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.billpaymentservice.ResponseTransfer;
import com.cognizant.billpaymentservice.UserAlreadyExistsException;
import com.cognizant.billpaymentservice.model.User;
import com.cognizant.billpaymentservice.service.UserService;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@PutMapping("")
	public ResponseTransfer modifyUser(@RequestBody User user) {

		userService.updateUserDetails(user);
		return new ResponseTransfer("Success");
	}
	
	@GetMapping("")
	public List<User> getuser(){
		return userService.getUserList();
		
		
	}
/*	@GetMapping("/{userId}")
	public Optional<User> getuserById(@PathVariable int userId ){
		return userService.getUser(userId);
		
		
	}*/
	@PostMapping("/{role}")
	public ResponseTransfer addUservalues(@RequestBody User user,@PathVariable("role") int rol) throws UserAlreadyExistsException {
		
		System.err.println(user);
		userService.addUser(user,rol);
		return new ResponseTransfer("added");
	}
	
	

}
