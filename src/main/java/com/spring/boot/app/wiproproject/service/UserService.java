package com.spring.boot.app.wiproproject.service;

import java.util.List;

import com.spring.boot.app.wiproproject.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto,int userId);
	
	UserDto getUserById(int userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(int userId);
	
	List<UserDto> createMultipleUser(List<UserDto> userDto);

}
