package com.cg.movie.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.dao.IBookingDao;
import com.cg.movie.dao.IBookingPaymentDao;
import com.cg.movie.entities.Booking;
import com.cg.movie.entities.Payment;

@Service
@Transactional
public class BookingServiceImpl implements IBookingService {

	double COST = 350;
	@Autowired
	private IBookingPaymentDao bPdao;

	@Autowired
	private IBookingDao bDao;

	@Override
	public Payment choosePaymentMethod(Payment payment) {

		payment = bPdao.save(payment);

		return payment;
	}

	@Override
	public double calculateTotalCost(Booking booking) {
		double cost = booking.getNoOfTickets() * booking.getCost();
		
		return cost;
	}

}
