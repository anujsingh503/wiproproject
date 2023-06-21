package com.spring.boot.app.wiproproject.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	
	private String status;
	private String statusCode;
	private Object data;
	private String message;

}
