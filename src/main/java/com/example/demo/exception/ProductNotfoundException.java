package com.example.demo.exception;


//繼承RuntimeException，由ProductExceptionController的@ExceptionHandler來處理例外回應。
public class ProductNotfoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

}
