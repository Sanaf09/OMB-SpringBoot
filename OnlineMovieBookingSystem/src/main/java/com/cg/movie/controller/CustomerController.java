package com.cg.movie.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.dto.BookingDetails;
import com.cg.movie.dto.CreateBookingRequest;
import com.cg.movie.dto.TheaterDetails;
import com.cg.movie.entities.Booking;
import com.cg.movie.entities.Theater;
import com.cg.movie.exception.BookingFailedException;
import com.cg.movie.service.ICustomerService;
import com.cg.movie.util.CustomerUtil;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {
	@Autowired
	private ICustomerService cService;

	@Autowired
	private CustomerUtil cUtil;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/bookMovie")
	public BookingDetails add(@RequestBody @Valid CreateBookingRequest requestData) {
		boolean status;
		System.out.println("req data: " + requestData);
		Booking booking = new Booking(requestData.getCustomerId(),requestData.getTheaterName(),requestData.getMovieName(),requestData.getShowDate(),requestData.getShowTime(),requestData.getNoOfTickets(),requestData.getSeatNo(),requestData.getCost());
		System.out.println("Booking came: " + booking);
		status = cService.bookMovieTicket(booking);
		BookingDetails details=null;
		if(status) 
			details = cUtil.toDetails(booking);
		else
			throw new BookingFailedException("Failed to book movie ticket.");
		return details;		
	}
	
	
	@GetMapping("/cancelMovie/{bookingid}")
	public BookingDetails cancel(@PathVariable ("bookingid") Integer bookingId) {
		Booking booking = cService.cancelMovieTicket(bookingId);
		System.out.println("Booking came: " + booking);
		BookingDetails details=null;
		if(booking !=null) 
			details = cUtil.toDetails(booking);
		else
			throw new BookingFailedException("Failed to cancel movie ticket.");
		return details;		
	}
	
	@GetMapping("/searchTheaterByCity/{theaterCity}")
	public List<TheaterDetails> findByCityName(@PathVariable("theaterCity") String theaterCity) {
		System.out.println("cntrlr fetch city name: " + theaterCity);
		List<Theater> theater = cService.findByCityName(theaterCity);
		List<TheaterDetails> response = cUtil.toDetails1(theater);
		System.out.println("Theater by city details: " + response);
		return response;
	}
	
}
