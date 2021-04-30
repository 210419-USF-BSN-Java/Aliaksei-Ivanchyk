package com.revature.model;

public class Rock {
	
	private String type;
	private double weight;
	private double price;
	private int rock_id;
	
	public Rock() {
		super();
	}

	public Rock(String type, double weight, double price) {
		super();
		this.type = type;
		this.weight = weight;
		this.price = price;
	}
	
	

	public Rock(String type, double weight, double price, int rock_id) {
		super();
		this.type = type;
		this.weight = weight;
		this.price = price;
		this.setRock_id(rock_id);
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
	
	
	
	

}
