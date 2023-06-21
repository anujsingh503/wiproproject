package com.spring.boot.app.wiproproject.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
	private int postId;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private CategoryDTO category;
	private UserDto user;
	

}
