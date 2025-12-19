package com.jsp.restapiwithvalidation.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
@RestControllerAdvice
public class GlobalException { 

	public GlobalException() {
	}

	@ExceptionHandler(NoResourseFoundException.class)
	private ResponseEntity<String> handleNoResourseException(NoResourseFoundException e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<Map<String ,Object>> handleExceptionMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("id can not be null", "check id value");
		hashMap.put("Color can not be blank", "check color value");
		hashMap.put("price can not be less than 30", "check price  value");
		return new ResponseEntity<>(hashMap,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ResourseAlreadyExist.class)
	private ResponseEntity<String> handleExceptionMethodArgumentNotValidException(ResourseAlreadyExist e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
