package com.example.userService.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpRequestDto {
	
	String email;
	String password;
}
