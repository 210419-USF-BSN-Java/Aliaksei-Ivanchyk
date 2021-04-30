package com.revature.model;

public class Offer {
	private double offerAmount;
	private int customer_id;
	private int rock_id;
	private int offer_id;
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Offer(double offerAmount, int customer_id, int rock_id, int offer_id) {
		super();
		this.offerAmount = offerAmount;
		this.customer_id = customer_id;
		this.rock_id = rock_id;
		this.offer_id = offer_id;
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
	@Override
	public String toString() {
		return "Offer [offerAmount=" + offerAmount + ", customer_id=" + customer_id + ", rock_id=" + rock_id
				+ ", offer_id=" + offer_id + "]";
	}
	
	

}
