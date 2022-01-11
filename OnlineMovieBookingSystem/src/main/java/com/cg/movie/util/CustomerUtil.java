package com.cg.movie.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.movie.dto.BookingDetails;
import com.cg.movie.dto.TheaterDetails;
import com.cg.movie.entities.Booking;
import com.cg.movie.entities.Theater;

@Component
public class CustomerUtil {
	public BookingDetails toDetails(Booking booking) {
		return new BookingDetails(booking.getBookingId(), booking.getCustomerId(), booking.getTheaterName(),
				booking.getMovieName(), booking.getShowDate(), booking.getShowTime(), booking.getNoOfTickets(),
				booking.getSeatNo(), booking.getCost());

	}

	public List<BookingDetails> toDetails(Collection<Booking> bookings) {
		List<BookingDetails> detailList = new ArrayList<>();
		for (Booking booking : bookings) {
			BookingDetails details = toDetails(booking);
			System.out.println(details);
			detailList.add(details);
		}
		return detailList;
	}

	public TheaterDetails toDetails1(Theater theater) {
		return new TheaterDetails(theater.getTheaterId(), theater.getTheaterName(), theater.getTheaterCity(),
				theater.getManagerName(), theater.getManagerContact());

	}

	public List<TheaterDetails> toDetails1(Collection<Theater> theaters) {
		List<TheaterDetails> detailList = new ArrayList<>();
		for (Theater theater : theaters) {
			TheaterDetails details = toDetails1(theater);
			System.out.println(details);
			detailList.add(details);
		}
		return detailList;

	}

}
