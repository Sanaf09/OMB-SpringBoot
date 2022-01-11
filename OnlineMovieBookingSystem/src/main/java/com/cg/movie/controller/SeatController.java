package com.cg.movie.controller;

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

import com.cg.movie.dto.CreateSeatRequest;
import com.cg.movie.dto.SeatDetails;
import com.cg.movie.entities.Seat;
import com.cg.movie.exception.BookingFailedException;
import com.cg.movie.exception.SeatNotFoundException;
import com.cg.movie.service.ISeatService;
import com.cg.movie.util.SeatUtil;

@RestController
@RequestMapping("/seat")
@Validated
public class SeatController {
	@Autowired
	private ISeatService sService;

	@Autowired
	private SeatUtil sUtil;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/bookSeat")
	public SeatDetails add(@RequestBody @Valid CreateSeatRequest requestData) {
		boolean status;
		System.out.println("req data: " + requestData);
		Seat seat = new Seat(requestData.getSeatId(), requestData.getSeatName());
		System.out.println("Seat came: " + seat);
		status = sService.bookSeat(seat);
		SeatDetails details=null;
		if(status) 
			details = sUtil.toDetails(seat);
		else
			throw new BookingFailedException("Failed to book movie ticket.");
		return details;		
	}
	
	@GetMapping("/cancelSeat/{seatid}")
	public SeatDetails cancel(@PathVariable ("seatid") Integer seatId) {
		Seat seat = sService.cancelSeat(seatId);
		System.out.println("Booking came: " + seat);
		SeatDetails details=null;
		if(seat !=null) 
			details = sUtil.toDetails(seat);
		else
			throw new SeatNotFoundException("Failed to cancel seat.");
		return details;		
	}

}
