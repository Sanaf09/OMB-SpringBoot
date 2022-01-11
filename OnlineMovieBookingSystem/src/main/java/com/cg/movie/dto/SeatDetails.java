package com.cg.movie.dto;

public class SeatDetails {
	
	Integer seatId;
	String seatName;
	
	public SeatDetails(Integer seatId, String seatName) {
		super();
		this.seatId = seatId;
		this.seatName = seatName;
	}
	public SeatDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SeatDetails(String seatName) {
		super();
		this.seatName = seatName;
	}
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
		return "SeatDetails [seatId=" + seatId + ", seatName=" + seatName + "]";
	}
	
	

}
