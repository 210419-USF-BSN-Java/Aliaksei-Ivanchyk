package com.revature.model;

public class Offer {
	private double offerAmount;
	private int customer_id;
	private int rock_id;
	private int offer_id;
	private int status;
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Offer(double offerAmount, int customer_id, int rock_id, int offer_id, int status) {
		super();
		this.offerAmount = offerAmount;
		this.customer_id = customer_id;
		this.rock_id = rock_id;
		this.offer_id = offer_id;
		this.status = status;
	}

	public double getOfferAmount() {
		return offerAmount;
	}
	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getRock_id() {
		return rock_id;
	}
	public void setRock_id(int rock_id) {
		this.rock_id = rock_id;
	}
	public int getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Offer [offerAmount=" + offerAmount + ", customer_id=" + customer_id + ", rock_id=" + rock_id
				+ ", offer_id=" + offer_id + ", status=" + status + "]";
	}
	
	
	
	

}
