package com.revature.model;

import java.sql.Timestamp;

public class SaleRecord {
	
	private double saleAmount;
	private Timestamp timestamp;
	private int rock_id;
	private int customer_id;
	private int sale_id;
	
	public SaleRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaleRecord(double saleAmount, Timestamp timestamp, int rock_id, int customer_id, int sale_id) {
		super();
		this.saleAmount = saleAmount;
		this.timestamp = timestamp;
		this.rock_id = rock_id;
		this.customer_id = customer_id;
		this.sale_id = sale_id;
	}
	public double getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(double saleAmount) {
		this.saleAmount = saleAmount;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public int getRock_id() {
		return rock_id;
	}
	public void setRock_id(int rock_id) {
		this.rock_id = rock_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	
	@Override
	public String toString() {
		return "SaleRecord [saleAmount=" + saleAmount + ", timestamp=" + timestamp + ", rock_id=" + rock_id
				+ ", customer_id=" + customer_id + ", sale_id=" + sale_id + "]";
	}
	
	
	
	

}
