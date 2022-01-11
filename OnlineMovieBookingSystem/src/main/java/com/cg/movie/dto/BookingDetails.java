package com.cg.movie.dto;

import java.time.LocalDate;


public class BookingDetails {
	private Integer bookingId;
	private Integer customerId;
	private String theaterName;
	private String movieName;
	private LocalDate showDate;
	private String showTime;
	private int noOfTickets;
	private String seatNo;
	private double cost;

	public BookingDetails() {

	}

	public BookingDetails(Integer bookingId, Integer customerId, String theaterName, String movieName,
			LocalDate showDate, String showTime, int noOfTickets, String seatNo, double cost) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.theaterName = theaterName;
		this.movieName = movieName;
		this.showDate = showDate;
		this.showTime = showTime;
		this.noOfTickets = noOfTickets;
		this.seatNo = seatNo;
		this.cost = cost;
	}

	public BookingDetails(double cost) {
		this.cost = cost;

	}

	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", customerId=" + customerId + ", theaterName=" + theaterName
				+ ", movieName=" + movieName + ", showDate=" + showDate + ", showTime=" + showTime + ", noOfTickets="
				+ noOfTickets + ", seatNo=" + seatNo + ", cost=" + cost + "]";
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
