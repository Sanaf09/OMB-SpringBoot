package com.cg.movie.dto;

import java.time.LocalDate;
import java.util.Set;

public class CustomerDetails {
	private Integer customerId;
	private String customerName;
	private String password;
	private LocalDate dateOfBirth;
	private String customerContact;
	private Set<TicketDetails> myTickets;

	

	public CustomerDetails(Integer customerId, String customerName, String password, LocalDate dateOfBirth,
			String customerContact, Set<TicketDetails> myTickets) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.customerContact = customerContact;
		this.myTickets = myTickets;
	}

	public CustomerDetails(Integer customerId, String customerName, String password, LocalDate dateOfBirth,
			String customerContact) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.customerContact = customerContact;
	}

	public CustomerDetails() {

	}

	@Override
	public String toString() {
		return "CreateCutomerRequest [customerId=" + customerId + ", customerName=" + customerName + ", password="
				+ password + ", dateOfBirth=" + dateOfBirth + ", customerContact=" + customerContact + ", myTickets="
				+ myTickets + "]";
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public Set<TicketDetails> getMyTickets() {
		return myTickets;
	}

	public void setMyTickets(Set<TicketDetails> myTickets) {
		this.myTickets = myTickets;
	}

	

}
