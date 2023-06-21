package com.spring.boot.app.wiproproject.service;

import java.util.List;

import com.spring.boot.app.wiproproject.dto.PostDto;
import com.spring.boot.app.wiproproject.entity.Post;
import com.spring.boot.app.wiproproject.payload.Response;

public interface PostService {
	
	Response createPost(PostDto postDto,int userId,int categoryId);
	
	Response updatePost(PostDto postDto, int postId);
	
	Response deletePost(int postId);
	
	Response getAllPost(int pageNumber,int pageSize,String sortBy);
	
	Response getSinglePost(int postId);
	
	Response getPostByCategory(int postId);
	
	Response getPostByUser(int postId);
	
	Response searchPost(String key);
	
	

}
