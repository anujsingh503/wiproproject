package com.spring.boot.app.wiproproject.exception;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.NonUniqueResultException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.spring.boot.app.wiproproject.exception.ResourceNotFoundException;

import com.spring.boot.app.wiproproject.payload.APIResponse;

@RestControllerAdvice
public class GlobalEceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> resourseNotFoundException(ResourceNotFoundException ex)
	{
		String massage=ex.getMessage();
		APIResponse apiResponse=new APIResponse(massage,false);
		return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String,String> map=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String filedName=((FieldError)error).getField();
			String defaultMessage=error.getDefaultMessage();
			map.put(filedName, defaultMessage);
		});
		
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<APIResponse> dataIntegrityViolationException(DataIntegrityViolationException ex)
	{
		String massage=ex.getMessage();
		APIResponse apiResponse=new APIResponse(massage,false);
		return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<APIResponse> nonUniqueResultException(IllegalArgumentException ex)
	{
		String massage="Name is duplicate, So please insert the unique name !!";
		APIResponse res=new APIResponse(massage,false);
		return new ResponseEntity<APIResponse>(res,HttpStatus.BAD_REQUEST);
	}
}
