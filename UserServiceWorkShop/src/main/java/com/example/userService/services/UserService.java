package com.example.userService.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.userService.exceptions.LoginFailedException;
import com.example.userService.models.User;
import com.example.userService.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User login(String email , String password) throws LoginFailedException {
		//Steps :
        //1. Go to DB and check if there's a user with the given emailId.
        //2. If yes, check the password with the given password.
        //3. If not, call the signUp method.
		
		Optional<User> optionalUser = userRepository.findByEmail(email);
		
		if (optionalUser.isEmpty()) {
			return signUp(email , password);
		}
		User user = optionalUser.get();
		if(user.getPassword().equals(password)) {
			//success
			return user;
		}
		else {
			 throw new LoginFailedException("InCorrect Password passed in Service");
		}
	}
	
	public User signUp( String email , String password) {
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		System.out.println("user.setEmail in service" + user.getEmail());
		
		User savedUser = userRepository.save(user);
		System.out.println("savedUser email in service" + savedUser.getEmail());
		return savedUser;
	}
	
	public User getById(Long Id) {
		Optional<User> optionalUser = userRepository.findById(Id);
		return optionalUser.get();
	}
}
