package com.cg.movie.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.dao.ISeatDao;
import com.cg.movie.entities.Seat;
import com.cg.movie.exception.SeatAlreadyBookedException;

@Service
@Transactional
public class SeatServiceImpl implements ISeatService {
	@Autowired
	private ISeatDao sDao;

	@Override
	public Seat cancelSeat(Integer seatId) {
		Optional<Seat> seatopt = sDao.findById(seatId);
		Seat seat = null;
		if (seatopt.isPresent()) {
			seat = seatopt.get();
			sDao.delete(seat);
		}

		return seat;
	}

	@Override
	public Boolean bookSeat(Seat seat) {
		boolean exists = seat.getSeatId() != null && sDao.existsById(seat.getSeatId());
		if (exists) {
			throw new SeatAlreadyBookedException("seat already exists for id=" + seat.getSeatId());
		}
		seat = sDao.save(seat);
		System.out.println("returning saved stud: " + seat);
		return true;
	}

}
