package com.perscholars.cafe;

public class Coffee extends Product {

	private boolean sugar;
	private boolean milk;

	public Coffee() {
		super();
		name = "Coffee";
		price = 4.5;
		description = "Standard black coffee.";
		this.sugar = false;
		this.milk = false;
	}

	public Coffee(String name, double price, String description, boolean sugar, boolean milk) {
		super();
		this.sugar = sugar;
		this.milk = milk;
	}

	@Override
	public double calculateProductTotal() {
		return super.calculateProductTotal();
	}

	public boolean isSugar() {
		return sugar;
	}

	public void setSugar(boolean sugar) {
		this.sugar = sugar;
	}

	public boolean isMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}

}
