package com.example.userService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.example.userService.controllers.UserController;
import com.example.userService.dtos.SignUpRequestDto;
import com.example.userService.dtos.SignUpResponseDto;

@SpringBootApplication
public class UserServiceWorkshopApplication implements CommandLineRunner {
	
	/*
	 * private UserController userController;
	 * 
	 * public UserServiceWorkshopApplication(UserController userController) {
	 * this.userController = userController; }
	 */

	public static void main(String[] args) {
		SpringApplication.run(UserServiceWorkshopApplication.class, args);
	}
	
	@Override
	public void run(String... args)throws Exception {
		
		/*
		 * SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
		 * 
		 * signUpRequestDto.setEmail("Akhila@gmail.com");
		 * signUpRequestDto.setPassword("123");
		 * 
		 * SignUpResponseDto signUpResponseDto =
		 * userController.signUp(signUpRequestDto); System.out.println("RESULT: "+
		 * signUpResponseDto.getResponseStatus());
		 */
		
	}

}
