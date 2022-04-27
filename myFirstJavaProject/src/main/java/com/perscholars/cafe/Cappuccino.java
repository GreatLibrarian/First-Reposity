package com.perscholars.cafe;

public class Cappuccino extends Product {

	private boolean peppermint;
	private boolean whippedCream;

	public Cappuccino() {
		super();
		name = "Cappuccino";
		price = 8;
		description = "What you drink when you hate coffee.";
		this.peppermint = false;
		this.whippedCream = false;
	}

	@Override
	public double calculateProductTotal() {
		boolean a = (peppermint && whippedCream);
		boolean b = (peppermint);
		boolean c = (whippedCream);
		double realprice = getPrice();
		if (a) {
			realprice = getPrice() + 3;
		} else {
			if (b) {
				realprice = getPrice() + 2;
			} else {
				if (c) {
					realprice = getPrice() + 1;
				}
			}
		}
		double subtotal = Math.floor((realprice * getQuantity()) * 100) / 100;
		return subtotal;
	}

	public Cappuccino(String name, double price, String description, boolean peppermint, boolean whippedCream) {
		super();
		this.peppermint = peppermint;
		this.whippedCream = whippedCream;
	}

	public boolean isPeppermint() {
		return peppermint;
	}

	public void setPeppermint(boolean peppermint) {
		this.peppermint = peppermint;
	}

	public boolean isWhippedCream() {
		return whippedCream;
	}

	public void setWhippedCream(boolean whippedCream) {
		this.whippedCream = whippedCream;
	}

}
