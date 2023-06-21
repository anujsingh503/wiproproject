package com.spring.boot.app.wiproproject.serviceImple;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.boot.app.wiproproject.dto.PostDto;
import com.spring.boot.app.wiproproject.entity.Category;
import com.spring.boot.app.wiproproject.entity.Post;
import com.spring.boot.app.wiproproject.entity.User;
import com.spring.boot.app.wiproproject.exception.ResourceNotFoundException;
import com.spring.boot.app.wiproproject.payload.Constent;
import com.spring.boot.app.wiproproject.payload.Response;
import com.spring.boot.app.wiproproject.repo.CategoryRepo;
import com.spring.boot.app.wiproproject.repo.PostRepo;
import com.spring.boot.app.wiproproject.repo.UserRepo;
import com.spring.boot.app.wiproproject.service.PostService;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Response createPost(PostDto postDto,int userId,int categoryId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "id", userId));
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category", " id", categoryId));
		
		Post post=this.modelMapper.map(postDto,Post.class);
		post.setAddedDate(new Date());
		post.setImageName("defalut.png");
		post.setUser(user);
		post.setCategory(category);
		Post savePost=this.postRepo.save(post);
		PostDto savePostDto=this.modelMapper.map(savePost, PostDto.class);
		Response response=new Response();
		response.setStatus(Constent.createStatus);
		response.setStatusCode(Constent.statusCode);
		response.setMessage(Constent.createMessage);
		response.setData(savePostDto);
		return response;
	}

	@Override
	public Response updatePost(PostDto postDto, int postId) {
		Post post=this.modelMapper.map(postDto,Post.class);
		Post posts=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", "id", postId));
		posts.setAddedDate(new Date());
		
		posts.setContent(post.getContent());
		posts.setTitle(post.getTitle());
		posts.setImageName("default.png");
		Post updatePost=postRepo.save(posts);
		PostDto updatePostDto=this.modelMapper.map(updatePost,PostDto.class);
		Response response=new Response();
		response.setStatus(Constent.updateStatus);
		response.setStatusCode(Constent.statusCode);
		response.setMessage(Constent.updateMessage);
		response.setData(updatePostDto);
		return response;
		
		
	}

	@Override
	public Response deletePost(int postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", "id", postId));
		PostDto postDto=this.modelMapper.map(post, PostDto.class);
		this.postRepo.delete(post);
		Response response=new Response();
		response.setStatus(Constent.deleteStatus);
		response.setStatusCode(Constent.statusCode);
		response.setMessage(Constent.deleteMassage);
		response.setData(postDto);
		return response;
	}

	@Override
	public Response getAllPost(int pageNumber,int pageSize,String sortBy) {
		
		Pageable pageable=PageRequest.of(pageNumber, pageSize,Sort.by(sortBy).descending());
		Page<Post> p=this.postRepo.findAll(pageable);
		List<Post> post=p.getContent();
		List<PostDto> postDto=post.stream().map((post1)->this.modelMapper.map(post1,PostDto.class)).collect(Collectors.toList());
		
		Response response=new Response();
		response.setStatus(Constent.getStatus);
		response.setStatusCode(Constent.statusCode);
		response.setMessage(Constent.getAllMessage);
		response.setData(postDto);
		return response;
	}

	@Override
	public Response getSinglePost(int postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", "id", postId));
		PostDto postDto=this.modelMapper.map(post,PostDto.class);
		Response response=new Response();
		response.setStatus(Constent.deleteStatus);
		response.setStatusCode(Constent.statusCode);
		response.setMessage(Constent.getMassage);
		response.setData(postDto);
		return response;
	}

	@Override
	public Response getPostByCategory(int categoryId) {
	 Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("post", "id", categoryId));
	 List<Post> post=this.postRepo.findByCategory(category);
	 List<PostDto> postDto=post.stream().map((post1)->this.modelMapper.map(post1,PostDto.class)).collect(Collectors.toList());
	 Response response=new Response();
	 response.setStatus(Constent.createStatus);
	 response.setStatusCode(Constent.statusCode);
	 response.setMessage(Constent.getMassage);
	 response.setData(postDto);
	 return response;
	}

	@Override
	public Response getPostByUser(int userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		List<Post> post=this.postRepo.findByUser(user);
		List<PostDto> postDto=post.stream().map((post1)->this.modelMapper.map(post1,PostDto.class)).collect(Collectors.toList());
		Response response=new Response();
		response.setStatus(Constent.createStatus);
		response.setStatusCode(Constent.statusCode);
		response.setMessage(Constent.getMassage);
		response.setData(postDto);
		return response;
		
	}

	@Override
	public Response searchPost(String key) {
		List<Post> post=this.postRepo.findByTitleContaining(key);
		List<PostDto> postDto=post.stream().map((post1)->this.modelMapper.map(post1,PostDto.class)).collect(Collectors.toList());
		
		Response response=new Response();
		response.setStatus(Constent.createStatus);
		response.setStatusCode(Constent.statusCode);
		response.setMessage(Constent.getAllMessage);
		response.setData(postDto);
		return response;
	}

}
