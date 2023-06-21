package com.spring.boot.app.wiproproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.app.wiproproject.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>
{

}
