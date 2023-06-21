package com.spring.boot.app.wiproproject.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.app.wiproproject.dto.UserDto;
import com.spring.boot.app.wiproproject.payload.APIResponse;
import com.spring.boot.app.wiproproject.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createdUser =userService.createUser(userDto);
		return new ResponseEntity<UserDto>(createdUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable int userId)
	{
		UserDto updateduser=this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updateduser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<APIResponse> deleteUser(@PathVariable int userId)
	{
		this.userService.deleteUser(userId);
		return new ResponseEntity<APIResponse>(new APIResponse("User deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable int userId)
	{
		UserDto user=this.userService.getUserById(userId);
		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<UserDto>> getAllUser()
	{
		
		List<UserDto> allUser=this.userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(allUser,HttpStatus.OK);
		//return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@PostMapping("/createmultiple")
	public ResponseEntity<List<UserDto>> createMultipleUsers(@Valid @RequestBody List<UserDto> userDto) {
		
		
		List<UserDto> saveAllUser=this.userService.createMultipleUser(userDto);
		return new ResponseEntity<List<UserDto>>(saveAllUser,HttpStatus.OK);
		
	}

}
