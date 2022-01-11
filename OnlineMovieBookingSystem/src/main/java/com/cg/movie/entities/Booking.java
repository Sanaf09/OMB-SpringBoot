package com.cg.movie.entities;


import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_try")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer bookingId;
	@Column(name = "cust_id")
	private Integer customerId;
	@Column(name = "theaterName")
	private String theaterName;
	@Column(name = "movieName")
	private String movieName;
	@Column(name = "showDate")
	private LocalDate showDate;
	@Column(name = "showTime")
	private String showTime;
	@Column(name = "noOfTickets")
	private int noOfTickets;
	@Column(name = "seatNo")
	private String seatNo;
	@Column(name = "cost")
	private double cost;

	public Booking() {

	}

	public Booking(Integer bookingId, Integer customerId, String theaterName, String movieName, LocalDate showDate,
			String showTime, int noOfTickets, String seatNo, double cost) {
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

	public Booking(Integer customerId, String theaterName, String movieName, LocalDate showDate, String showTime,
			int noOfTickets, String seatNo, double cost) {
		this.customerId = customerId;
		this.theaterName = theaterName;
		this.movieName = movieName;
		this.showDate = showDate;
		this.showTime = showTime;
		this.noOfTickets = noOfTickets;
		this.seatNo = seatNo;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerId=" + customerId + ", theaterName=" + theaterName
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
