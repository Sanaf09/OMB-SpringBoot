package com.cg.movie.service;

import java.util.List;

import com.cg.movie.entities.Booking;
import com.cg.movie.entities.Theater;

public interface ICustomerService {
	Boolean bookMovieTicket(Booking booking);

	Booking cancelMovieTicket(Integer bookingId);
	
//	List<Theater> chooseCity(String theaterCity);

	List<Theater> findByCityName(String theaterCity);
}
