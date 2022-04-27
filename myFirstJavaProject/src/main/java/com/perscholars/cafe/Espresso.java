package com.perscholars.cafe;

public class Espresso extends Product {

	private boolean extraShot;
	private boolean macchiato;

	public Espresso() {
		super();
		name = "Espresso";
		price = 6;
		description = "Shot of expensive espresso.";
		this.extraShot = false;
		this.macchiato = false;
	}

	public Espresso(String name, double price, String description, boolean extraShot, boolean macchiato) {
		super();
		this.extraShot = extraShot;
		this.macchiato = macchiato;
	}

	@Override
	public double calculateProductTotal() {
		boolean a = (extraShot && macchiato);
		boolean b = (extraShot);
		boolean c = (macchiato);
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

	public boolean isExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean isMacchiato() {
		return macchiato;
	}

	public void setMacchiato(boolean macchiato) {
		this.macchiato = macchiato;
	}
	
	

}
