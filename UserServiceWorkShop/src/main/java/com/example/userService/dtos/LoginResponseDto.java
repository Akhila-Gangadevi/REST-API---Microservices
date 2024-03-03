package com.example.userService.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponseDto {
	
	private Long UserId;
	private ResponseStatus responseStatus;

}
