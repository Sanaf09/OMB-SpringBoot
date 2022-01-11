package com.cg.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.movie.dao.ICustomerDao;
import com.cg.movie.dao.ITheaterDao;
import com.cg.movie.entities.Booking;
import com.cg.movie.entities.Theater;
import com.cg.movie.exception.BookingAlreadyExistsException;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao cDao;
	@Autowired
	private ITheaterDao tDao;

	@Override
	public Boolean bookMovieTicket(Booking booking) {
		boolean exists = booking.getCustomerId() != null && cDao.existsById(booking.getCustomerId());
		if (exists) {
			throw new BookingAlreadyExistsException("student already exists for id=" + booking.getCustomerId());
		}
		booking = cDao.save(booking);
		System.out.println("returning saved stud: " + booking);
		return true;
	}

	@Override
	public Booking cancelMovieTicket(Integer bookingId) {
		Optional<Booking> bookopt = cDao.findById(bookingId);
		Booking booking=null;
		if (bookopt.isPresent()) {
			booking = bookopt.get();
			cDao.delete(booking);
		}
			
		return booking;
	}

	@Override
	public List<Theater> findByCityName(String theaterCity) {
		System.out.println("City: " + theaterCity);
		List<Theater> list = tDao.findByCityName(theaterCity);
		return list;		
	}
	
	
}
