package com.fabiano.clients.domain;

import javax.persistence.Entity;

import com.fabiano.clients.domain.enums.PaymentStatus;

@Entity
public class CreditCardPayment extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Integer installments;
	
	public CreditCardPayment() {
		
	}

	public CreditCardPayment(Integer id, PaymentStatus status, Order order, Integer installments) {
		super(id, status, order);
		this.installments= installments;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	
	
	
	
	
	

}
