package com.cg.movie.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.dto.BookingDetails;
import com.cg.movie.dto.CreateBookingRequest;
import com.cg.movie.dto.CreatePaymentRequest;
import com.cg.movie.dto.CreateShowRequest;
import com.cg.movie.dto.PaymentDetails;
import com.cg.movie.entities.Booking;
import com.cg.movie.entities.Payment;
import com.cg.movie.service.IBookingService;
import com.cg.movie.util.BookingUtil;

@RestController
@RequestMapping("booking")
@Validated
public class BookingController {
	
	@Autowired
	private IBookingService bService;
	@Autowired
	private BookingUtil bUtil;
	
//	calculating total cost
	
	@PostMapping("/cost")	
	public double calculateTotalCost(@RequestBody @Valid CreateBookingRequest requestData){
		System.out.println("req data: " + requestData);
		
		Booking booking = new Booking(requestData.getBookingId(),requestData.getCustomerId(),requestData.getTheaterName(),requestData.getMovieName(),requestData.getShowDate(),requestData.getShowTime(),requestData.getNoOfTickets(),requestData.getSeatNo(),requestData.getCost());

		double cost = bService.calculateTotalCost(booking);
	
		return cost;
	}
//	some put calls to choose the seats
//	@PutMapping("/choose/seats")	
//	public ResponseEntity<List<Seat>> chooseSeats(@RequestBody List<Integer> seatIds){
//	
//		return new ResponseEntity<>(service.chooseSeats(seatIds),HttpStatus.OK);
//	}
	//choosing the payment method
	@PostMapping("/payment")
	public PaymentDetails choosePaymentMethod(@RequestBody @Valid CreatePaymentRequest requestData) {
		
		System.out.println("req data: " + requestData);
		Payment payment = new Payment(requestData.getPaymentId(),requestData.getCustomerId(),requestData.getPaymentMethod(),requestData.getPhno());
		payment = bService.choosePaymentMethod(payment);
		System.out.println("Payment Method came: " + payment);
	
		PaymentDetails details= bUtil.toDetails(payment); 
		return details;
		
	}
	//choosing the payment method
	@PostMapping("/makePayment")
	public String makePaymentMethod() {
		return "Payment made";
	}
	
	
	
	
	
	
	

}
