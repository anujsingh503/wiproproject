package com.spring.boot.app.wiproproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	private String categoryTitle;
	private String categoryDescription;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Post> posts=new ArrayList<Post>();
	
	

}
