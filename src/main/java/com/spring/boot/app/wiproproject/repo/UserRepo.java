package com.spring.boot.app.wiproproject.repo;

import java.util.Optional;

import org.apache.catalina.startup.ListenerCreateRule.OptionalListener;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.app.wiproproject.dto.UserDto;
import com.spring.boot.app.wiproproject.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public Optional<User> findByName(String name);

}
