package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.demo.entity.User;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("user")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("user/{id}")
	public User getUserById(@PathVariable("id") Long id){
		/*
		 * User user; try { user = userService.getUserById(id); return
		 * ResponseEntity.ok(user); } catch (UserNotFoundException e) { // TODO
		 * Auto-generated catch block return new
		 * ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		 * 
		 * }
		 */
		User user = userService.getUserById(id);
		if(user==null) {
			throw new UserNotFoundException(id);
		}
		return user;
		
	
	}
	@GetMapping("user")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
		
	}
	@PutMapping("user/{id}")
	public ResponseEntity<User> putMethodName(@PathVariable("id") Long id, @RequestBody User userDetailsUser) {
		//TODO: process PUT request
		
		return ResponseEntity.ok(userService.updateUser(id, userDetailsUser));
	}
	@DeleteMapping("user/{id}")
	public ResponseEntity<User> deleteById(@PathVariable("id") Long id){
		userService.DeleteUser(id);
		return ResponseEntity.noContent().build();
		
	}
}
