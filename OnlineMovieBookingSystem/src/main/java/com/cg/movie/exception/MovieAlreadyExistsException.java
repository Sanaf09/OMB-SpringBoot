package com.cg.movie.exception;

public class MovieAlreadyExistsException extends RuntimeException {

	public MovieAlreadyExistsException(String message) {
		super(message);
	}

}
