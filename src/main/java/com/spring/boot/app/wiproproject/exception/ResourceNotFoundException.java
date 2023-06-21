package com.spring.boot.app.wiproproject.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	String filedName;
	int fieldValue;
	public ResourceNotFoundException(String resourceName, String filedName, int fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName, filedName, fieldValue));
		this.resourceName = resourceName;
		this.filedName = filedName;
		this.fieldValue = fieldValue;
	}
	
	

}
