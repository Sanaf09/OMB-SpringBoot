package com.cg.movie.dto;

public class CreateSeatRequest {
	
	Integer seatId;
	String seatName;
	public Integer getSeatId() {
		return seatId;
	}
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	@Override
	public String toString() {
		return "CreateSeatRequest [seatId=" + seatId + ", seatName=" + seatName + "]";
	}
	
	

}
