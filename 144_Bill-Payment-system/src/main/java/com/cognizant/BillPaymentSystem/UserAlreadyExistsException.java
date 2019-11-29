package com.cognizant.BillPaymentSystem;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="User Already Exits")
public class UserAlreadyExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException() {
		System.out.println("User Already Exits");
		// TODO Auto-generated constructor stub
	}


}
