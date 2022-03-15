package com.cg.movie.exception;

public class IdNotFoundException extends RuntimeException{
	public IdNotFoundException(String message){
		super(message);
	}
}
