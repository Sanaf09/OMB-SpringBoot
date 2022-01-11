package com.cg.movie.exception;

public class SeatNotFoundException extends RuntimeException {

	public SeatNotFoundException(String message) {
		super(message);
	}

}
