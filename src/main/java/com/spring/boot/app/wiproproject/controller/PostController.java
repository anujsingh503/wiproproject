package com.spring.boot.app.wiproproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.app.wiproproject.dto.PostDto;
import com.spring.boot.app.wiproproject.entity.Post;
import com.spring.boot.app.wiproproject.payload.Response;
import com.spring.boot.app.wiproproject.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@PostMapping("/user/{userId}/category/{categoryId}/post")
	public ResponseEntity<Response> createResource(@RequestBody PostDto postDto,
													@PathVariable int userId,@PathVariable int categoryId )
	{
		Response response=this.postService.createPost(postDto,userId,categoryId);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<Response> getPostByCategory(@PathVariable int categoryId)
	{
		Response response=this.postService.getPostByCategory(categoryId);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<Response> getPostByUser(@PathVariable int userId)
	{
		Response response=this.postService.getPostByUser(userId);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<Response> getAllPost(@RequestParam(value="pageNumber",defaultValue = "0",required = false) 
												int pageNumber,@RequestParam(value="pageSze",defaultValue = "5",required = false) 
												int pageSize,@RequestParam(value="sortBy",defaultValue = "title",required = false)
												String sortBy)
	{
		Response response=this.postService.getAllPost(pageNumber,pageSize,sortBy);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/post/{postId}")
	public ResponseEntity<Response> getAllPost(@PathVariable int postId)
	{
		Response response=this.postService.getSinglePost(postId);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/post/{postId}")
	public ResponseEntity<Response> updatePost(@RequestBody PostDto postDto, @PathVariable int postId)
	{
		Response response=this.postService.updatePost(postDto, postId);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/post/{postId}")
	public ResponseEntity<Response> deletePost(@PathVariable int postId)
	{
		Response response=this.postService.deletePost(postId);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/serch/{key}")
	public ResponseEntity<Response> getSerchingPost(@PathVariable String key)
	{
		Response response=this.postService.searchPost(key);
		return ResponseEntity.ok(response);
	}

}
