package com.example.demo.exceptions;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(Long id) {
		// TODO Auto-generated constructor stub
		super("user not found with id "+id) ;
	}

}
