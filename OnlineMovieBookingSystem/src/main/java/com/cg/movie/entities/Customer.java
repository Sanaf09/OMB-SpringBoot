package com.cg.movie.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_try")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer customerId;
	@Column(name = "cust_name")
	private String customerName;
	@Column(name = "password")
	private String password;
	@Column(name = "dob")
	private LocalDate dateOfBirth;
	@Column(name = "contact")
	private String customerContact;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Ticket> myTickets = new HashSet<>();

	public Customer() {
	}

	public Customer(Integer customerId, String customerName, String password, LocalDate dateOfBirth,
			String customerContact, Set<Ticket> myTickets) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.customerContact = customerContact;
		this.myTickets = myTickets;
	}

	public Customer(String customerName, String password, LocalDate dateOfBirth, String customerContact) {
		this.customerName = customerName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.customerContact = customerContact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<Ticket> getMyTickets() {
		return myTickets;
	}

	public void setMyTickets(Set<Ticket> myTickets) {
		this.myTickets = myTickets;
	}

	public void addTicket(Ticket ticket) {
//		ticket.setCustomer(this);
		myTickets.add(ticket);
	}

}
