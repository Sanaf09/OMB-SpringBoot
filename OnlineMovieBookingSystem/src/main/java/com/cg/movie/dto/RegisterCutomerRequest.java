package com.cg.movie.dto;

import java.time.LocalDate;

public class RegisterCutomerRequest {
	private Integer customerId;
	private String customerName;
	private String password;
	private LocalDate dateOfBirth;
	private String customerContact;
	

	

	@Override
	public String toString() {
		return "CreateCutomerRequest [customerId=" + customerId + ", customerName=" + customerName + ", password="
				+ password + ", dateOfBirth=" + dateOfBirth + ", customerContact=" + customerContact + "]";
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

	

}
