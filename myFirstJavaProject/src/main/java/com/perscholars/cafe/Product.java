package com.perscholars.cafe;

public abstract class Product {
	protected String name;
	protected double price;
	protected String description;
	protected int quantity = 0;

	public Product() {
		name = "";
		price = 0;
		description = "";
	}

	public Product(String name, double price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public double calculateProductTotal() {
		double subtotal = Math.floor((price * quantity) * 100) / 100;
		return subtotal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
