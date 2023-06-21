package com.spring.boot.app.wiproproject.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	
	@ManyToOne
	private Category category;
	@ManyToOne
	private User user;

}
