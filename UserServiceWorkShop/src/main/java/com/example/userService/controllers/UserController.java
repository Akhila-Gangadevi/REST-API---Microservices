package com.example.userService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userService.dtos.LoginRequestDto;
import com.example.userService.dtos.LoginResponseDto;
import com.example.userService.dtos.ResponseStatus;
import com.example.userService.dtos.SignUpRequestDto;
import com.example.userService.dtos.SignUpResponseDto;
import com.example.userService.dtos.UserDto;
import com.example.userService.models.User;
import com.example.userService.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController{
	
	 private UserService userService;
	
	public UserController(com.example.userService.services.UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/login")
	public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		
		try {
			User user = userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
			
			loginResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
			loginResponseDto.setUserId(user.getId());
		}
		catch(Exception e) {
			loginResponseDto.setResponseStatus(ResponseStatus.FAILURE);
		}
		 return loginResponseDto;
	}
	
	@PostMapping("/signUp")
	public SignUpResponseDto signUp(@RequestBody SignUpRequestDto SignUpRequestDto) {
		
		SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
		try {
			
			User user = userService.signUp(SignUpRequestDto.getEmail(), SignUpRequestDto.getPassword());
			
			System.out.println("User email in controller" +user.getEmail());
			
			signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
			signUpResponseDto.setEmail(user.getEmail());
			
		}
		catch(Exception e){
			signUpResponseDto.setResponseStatus(ResponseStatus.FAILURE);
		}
		return signUpResponseDto;
		
	}
	
	@GetMapping("/{Id}")
	public UserDto getById(@PathVariable Long Id) {
		User user = userService.getById(Id);
		
		UserDto userDto = new UserDto();
		userDto.setEmail(user.getEmail());
		  System.out.println("getById() method called");
		
		return userDto;
		
		
	}
}
