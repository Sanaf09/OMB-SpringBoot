package com.cg.movie.dto;

public class PaymentDetails {
	
	private Integer paymentId;
	private Integer customerId;
	private String paymentMethod;
	private long phno;
	
	
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public PaymentDetails(Integer paymentId, Integer customerId, String paymentMethod, long phno) {
		super();
		this.paymentId = paymentId;
		this.customerId = customerId;
		this.paymentMethod = paymentMethod;
		this.phno = phno;
	}
	
	
	
	

}
