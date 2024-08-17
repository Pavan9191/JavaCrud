package com.example.demo.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
		
	}
	public User getUserById(Long id) {
		 return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		
	}
	public List<User> getAllUsers() {
		 return userRepository.findAll();
		
	}
	public User updateUser(Long id, User userDetails) {
		User user=getUserById(id);
	    user.setEmail(userDetails.getEmail());
	    user.setName(userDetails.getName());
		return userRepository.save(user);
	}
	public void DeleteUser(Long id) {
		User user =getUserById(id);
		userRepository.delete(user);
	}
	

}
