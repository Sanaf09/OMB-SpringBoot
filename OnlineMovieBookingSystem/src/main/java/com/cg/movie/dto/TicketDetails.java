package com.cg.movie.dto;

import com.cg.movie.entities.Ticket;

public class TicketDetails {
	private Integer ticketId;
	Integer noOfSeats;
	String seatName;
	String screenName;
	Boolean ticketStatus;

	public TicketDetails() {
	}

	public TicketDetails(Integer ticketId, Integer noOfSeats, String seatName, String screenName,
			Boolean ticketStatus) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.seatName = seatName;
		this.screenName = screenName;
		this.ticketStatus = ticketStatus;
	}

	public TicketDetails(Ticket ticket) {
		ticketId = ticket.getTicketId();
		noOfSeats = ticket.getNoOfSeats();
		seatName = ticket.getSeatName();
		screenName = ticket.getScreenName();
		ticketStatus = ticket.getTicketStatus();
	}

	@Override
	public String toString() {
		return "TicketDetails [ticketId=" + ticketId + ", noOfSeats=" + noOfSeats + ", seatName=" + seatName
				+ ", screenName=" + screenName + ", ticketStatus=" + ticketStatus + "]";
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Boolean getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(Boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	
}
