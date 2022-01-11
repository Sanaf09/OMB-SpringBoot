package com.cg.movie.service;

import com.cg.movie.entities.Seat;

public interface ISeatService {
	Seat cancelSeat(Integer seatId);

	Boolean bookSeat(Seat seat);
}
