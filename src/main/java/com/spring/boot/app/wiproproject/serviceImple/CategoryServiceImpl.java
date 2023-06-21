package com.spring.boot.app.wiproproject.serviceImple;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.app.wiproproject.dto.CategoryDTO;
import com.spring.boot.app.wiproproject.entity.Category;
import com.spring.boot.app.wiproproject.exception.ResourceNotFoundException;
import com.spring.boot.app.wiproproject.repo.CategoryRepo;
import com.spring.boot.app.wiproproject.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO cateDto) {
		
		Category cate=this.modelMapper.map(cateDto, Category.class);
		Category saveCate=this.categoryRepo.save(cate);
		return this.modelMapper.map(saveCate,CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAll() {
		
		List<Category> allCategory=categoryRepo.findAll();
		return allCategory.stream().map((cate)->this.modelMapper.map(cate,CategoryDTO.class)).collect(Collectors.toList());
	}

	@Override
	public CategoryDTO getSingleCategory(int categoryId) {
		
		Category cate=categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "id", categoryId));
		return this.modelMapper.map(cate,CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO cate, int categoryId) {
		
		
		Category cate1=categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "id", categoryId));
		cate1.setCategoryDescription(cate.getCategoryDescription());
		cate1.setCategoryTitle(cate.getCategoryTitle());
		Category updatedCategory=categoryRepo.save(cate1);
		
		return this.modelMapper.map(updatedCategory,CategoryDTO.class);
	}

	@Override
	public void deleteCategory(int categoryId) {
		
		Category cate=categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","id", categoryId));
		categoryRepo.delete(cate);
	}

}
