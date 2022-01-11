package com.cg.movie.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(NotLoggedInException.class)
	public String handleLogin(NotLoggedInException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(MovieNotFoundException.class)
	public String handleMovieNotFound(MovieNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ScreenNotFoundException.class)
	public String handleScreenNotFound(ScreenNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(SeatNotFoundException.class)
	public String handleSeatNotFound(SeatNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ShowNotFoundException.class)
	public String handleShowNotFound(ShowNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(TheaterNotFoundException.class)
	public String handleTheaterNotFound(TheaterNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookingAlreadyExistsException.class)
	public String handleBookingExists(BookingAlreadyExistsException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public String handleCustomerExists(CustomerAlreadyExistsException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MovieAlreadyExistsException.class)
	public String handleMovieExists(MovieAlreadyExistsException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ScreenAlreadyExistsException.class)
	public String handleScreenExists(ScreenAlreadyExistsException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(SeatAlreadyBookedException.class)
	public String handleSeatExists(SeatAlreadyBookedException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ShowAlreadyExistsException.class)
	public String handleShowExists(ShowAlreadyExistsException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(TheaterAlreadyExistsException.class)
	public String handleTheaterExists(TheaterAlreadyExistsException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler(Exception.class)
	public String handleError(Exception e) {
		e.printStackTrace();
		return e.getMessage();
	}
}
