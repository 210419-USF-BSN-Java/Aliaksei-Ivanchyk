package com.revature.model;

public class Rock {
	
	private String type;
	private double weight;
	private double price;
	private int rock_id;
	private int status;
	private int customer_id;
	
	public Rock() {
		super();
	}



	public Rock(String type, double weight, double price, int rock_id, int status, int customer_id) {
		super();
		this.type = type;
		this.weight = weight;
		this.price = price;
		this.rock_id = rock_id;
		this.status = status;
		this.customer_id = customer_id;
	}



	public Rock(String type, double weight, double price, int rock_id) {
		super();
		this.type = type;
		this.weight = weight;
		this.price = price;
		this.setRock_id(rock_id);
	}
	
	

	@Override
	public String toString() {
		return "Rock [type=" + type + ", weight=" + weight + ", price=" + price + ", rock_id=" + rock_id + ", status="
				+ status + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRock_id() {
		return rock_id;
	}

	public void setRock_id(int rock_id) {
		this.rock_id = rock_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	
	
	

}
