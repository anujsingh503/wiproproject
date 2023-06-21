package com.spring.boot.app.wiproproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	
	
	private int categoryId;
	private String categoryTitle;
	private String categoryDescription;

}
