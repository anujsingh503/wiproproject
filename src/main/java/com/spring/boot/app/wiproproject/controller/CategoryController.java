package com.spring.boot.app.wiproproject.controller;

import java.util.List;

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

import com.spring.boot.app.wiproproject.dto.CategoryDTO;
import com.spring.boot.app.wiproproject.payload.APIResponse;
import com.spring.boot.app.wiproproject.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO category)
	{
		CategoryDTO categoryDTO=categoryService.createCategory(category);
		return new ResponseEntity<CategoryDTO>(categoryDTO,HttpStatus.CREATED);
	}
	
	@PutMapping("/{cateId}")
	public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO cate,@PathVariable int cateId)
	{
		CategoryDTO categoryDTO= categoryService.updateCategory(cate, cateId);
		return ResponseEntity.ok(categoryDTO);
	}
	
	@GetMapping(value="/",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<CategoryDTO>> getAllCategory()
	{
		List<CategoryDTO> categoryDTO=categoryService.getAll();
		return new ResponseEntity<List<CategoryDTO>>(categoryDTO,HttpStatus.OK);
	}
	
	@GetMapping("/{cateId}")
	public ResponseEntity<CategoryDTO> getSingleCategory(@PathVariable int cateId)
	{
		CategoryDTO categoryDTO= categoryService.getSingleCategory(cateId);
		return new ResponseEntity<CategoryDTO>(categoryDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/{cateId}")
	public ResponseEntity<APIResponse> deleteCategory(@PathVariable int cateId)
	{
		categoryService.deleteCategory(cateId);
		APIResponse aPIResponse=new APIResponse();
		aPIResponse.setMassage("Delete Successfully !!");
		aPIResponse.setSuccess(true);
		return new ResponseEntity<APIResponse>(aPIResponse,HttpStatus.OK);
	}

}
