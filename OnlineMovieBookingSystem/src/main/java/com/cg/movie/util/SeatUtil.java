package com.cg.movie.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.movie.dto.SeatDetails;
import com.cg.movie.entities.Seat;

@Component
public class SeatUtil {
	public SeatDetails toDetails(Seat seat) {
		return new SeatDetails(seat.getSeatId(), seat.getSeatName());
	}
		
	public List<SeatDetails> toDetails(Collection<Seat> seats) {
		List<SeatDetails> detailList = new ArrayList<>();
		for (Seat seat : seats) {
			SeatDetails details = toDetails(seat);
			System.out.println(details);
			detailList.add(details);
		}
		return detailList;
	}
}
