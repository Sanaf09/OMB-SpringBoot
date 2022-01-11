package com.cg.movie.util;

import org.springframework.stereotype.Component;

import com.cg.movie.dto.BookingDetails;
import com.cg.movie.dto.PaymentDetails;
import com.cg.movie.entities.Booking;
import com.cg.movie.entities.Payment;

@Component
public class BookingUtil {

	public PaymentDetails toDetails(Payment payment) {
		return new PaymentDetails(payment.getPaymentId(), payment.getCustomerId(), payment.getPaymentMethod(),
				payment.getPhno());

	}

	public BookingDetails toDetails(Booking booking) {

		return new BookingDetails(booking.getCost());
	}

}
