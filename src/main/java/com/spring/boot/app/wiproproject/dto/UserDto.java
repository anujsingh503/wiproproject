package com.spring.boot.app.wiproproject.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotNull
	@Size(min=4,message="minimum four char !!")
	private String name;
	
	@Email(message="Email address not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min=4,max=10,message="password must be 4 char and max must be 10 !!")
	private String password;
	
	@NotEmpty
	private String about;

}
