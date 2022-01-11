package com.cg.movie.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=" seat_try")
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer seatId;
	@Column(name="seatName")
	String seatName;
	
	
	public Seat(Integer seatId, String seatName) {
		super();
		this.seatId = seatId;
		this.seatName = seatName;
	}
	public Seat() {
		
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
		return "Seat [seatId=" + seatId + ", seatName=" + seatName + "]";
	}
}
