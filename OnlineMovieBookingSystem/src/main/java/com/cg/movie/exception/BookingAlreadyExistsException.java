package com.cg.movie.exception;

public class BookingAlreadyExistsException extends RuntimeException {

	public BookingAlreadyExistsException(String message) {
		super(message);
	}

}
