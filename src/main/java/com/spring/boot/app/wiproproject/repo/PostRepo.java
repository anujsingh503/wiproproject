package com.spring.boot.app.wiproproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.app.wiproproject.dto.PostDto;
import com.spring.boot.app.wiproproject.entity.Category;
import com.spring.boot.app.wiproproject.entity.Post;
import com.spring.boot.app.wiproproject.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);

}
