package com.spring.boot.app.wiproproject.service;

import java.util.List;

import com.spring.boot.app.wiproproject.dto.CategoryDTO;

public interface CategoryService {
	
	CategoryDTO createCategory(CategoryDTO cate);
	
	List<CategoryDTO> getAll(); 
	
	CategoryDTO getSingleCategory(int categoryId);
	
	CategoryDTO updateCategory(CategoryDTO cate,int categoryId);
	
	void deleteCategory(int categoryId);
	

}
