package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@RestController
@CrossOrigin("http://localhost:3000/")
public class usercontroller {

	@Autowired
	private UserRepo userRepository;
	
	@PostMapping("/user")
	User newUser(@RequestBody User newUser)
	{
		return userRepository.save(newUser);
	}
	
	
	@GetMapping("/users")
	List<User> getAllUser()
	{
		return userRepository.findAll();
	}
	
	//get user by -> Id
	@GetMapping("/user/{id}")
	Optional<User> getUserById(@PathVariable Long id)
	{
		return userRepository.findById(id);
		
//		. orElseThrow(()->new UserNotFoundException(id));
		
	} 
	
	//Edit the user by id /Update the rec
	
	@PutMapping ("/user/{id}")
	
	Optional<User> updateUser(@RequestBody User newUser,@PathVariable Long id)
	{
		return userRepository.findById(id)
		.map(user->{
			user.setUsername(newUser.getUsername());
			user.setLastname(newUser.getLastname());
			user.setEmail(newUser.getEmail());
			
			return userRepository.save(user);
			
		});
	}


// Delete the rec
	
	@DeleteMapping("/user/{id}")
	
	String deleteUser (@PathVariable Long id)
	{
//		if(!userRepository.existsById(id));
		
		userRepository.deleteById(id);
		return "user with id" +id+"hasebeen deeted";
		
	}
	
	
	
	
}
