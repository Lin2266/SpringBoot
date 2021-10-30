package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice 用於全局處理異常。
@ControllerAdvice
public class ProductExceptionController {
	
	//@ExceptionHandler 用於處理特定的異常並向客戶端發送自定義響應。
	@ExceptionHandler(value = ProductNotfoundException.class)
	public ResponseEntity<Object> exception(ProductNotfoundException exception){
		return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
	}

}
