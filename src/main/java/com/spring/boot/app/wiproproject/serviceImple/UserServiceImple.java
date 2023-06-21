package com.spring.boot.app.wiproproject.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.NonUniqueResultException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.spring.boot.app.wiproproject.dto.UserDto;
import com.spring.boot.app.wiproproject.entity.User;
import com.spring.boot.app.wiproproject.exception.ResourceNotFoundException;
import com.spring.boot.app.wiproproject.repo.UserRepo;
import com.spring.boot.app.wiproproject.service.UserService;


@Service
public class UserServiceImple implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user=this.modelMapper.map(userDto, User.class);
		
		User user1 =userRepo.findByName(user.getName()).orElse(null);
		
		User saveUser=null;
		if(user1==null)
		{
			saveUser=this.userRepo.save(user);
		}
		return this.modelMapper.map(saveUser, UserDto.class);
		
	}

	
	@Override
	public UserDto updateUser(UserDto userDto, int userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser=this.userRepo.save(user);
		UserDto updatedUserDto=this.modelMapper.map(updatedUser, UserDto.class);
		
		return updatedUserDto;
	}

	@Override
	public UserDto getUserById(int userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","Id",userId));
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDto=users.stream().map(e->this.modelMapper.map(e, UserDto.class)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(int userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","Id",userId));
		this.userRepo.delete(user);
	}

	@Override
	public List<UserDto> createMultipleUser(List<UserDto> userDto) {
		
		List<User> user=userDto.stream().map((e)->this.modelMapper.map(e, User.class)).collect(Collectors.toList());
		
		List<UserDto> saveUserDto=new ArrayList<>();
		for(User u : user)
		{
			this.userRepo.save(u);
			saveUserDto.add(this.modelMapper.map(u, UserDto.class));
		}
		
		return saveUserDto;
	}

}
