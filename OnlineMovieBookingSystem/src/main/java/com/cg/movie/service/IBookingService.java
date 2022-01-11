package com.cg.movie.service;

import com.cg.movie.entities.Booking;
import com.cg.movie.entities.Payment;

public interface IBookingService {
	public Payment choosePaymentMethod(Payment payment);

	public double calculateTotalCost(Booking booking);
}
