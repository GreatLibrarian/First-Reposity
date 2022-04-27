package com.perscholars.cafe;

import java.util.Scanner;

public class CafeApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		final double salesTax = 0.19;
		String adder;
		String truefalse;

		Coffee cof = new Coffee();
		Espresso esp = new Espresso();
		Cappuccino cap = new Cappuccino();
		
		System.out.println("How many cups of coffee would you like? ($4.50 each)");
		cof.setQuantity(scan.nextInt());
		System.out.println("Would you like to have milk in this coffee? Y/N");
		truefalse = scan.next();
		if (truefalse.equals("Y")) {
			cof.setMilk(true);
		} else {
			cof.setMilk(false);
		}
		
		System.out.println("Would you like to have sugar in this coffee? Y/N");
		truefalse = scan.next();
		if (truefalse.equals("Y")) {
			cof.setSugar(true);
		} else {
			cof.setSugar(false);
		}

		adder = "";
		if (cof.isMilk() && cof.isSugar()) {
			adder = " with milk and sugar";
		} else {
			if (cof.isMilk()) {
				adder = " with milk";
			} else {
				if (cof.isSugar()) {
					adder = " with sugar";
				}
			}
		}

		System.out.println("Product Name: " + cof.getName() + adder +'\n' + "Description " + cof.getDescription() + '\n'
				+ "Product Subtotal: $" + cof.calculateProductTotal());

		System.out.println("How many shots of espresso would you like? ($6.00 each)");
		esp.setQuantity(scan.nextInt());
		System.out.println("Would you like to have an extra shot for each espresso? (+$2.00) Y/N");
		truefalse = scan.next();
		if (truefalse.equals("Y")) {
			esp.setExtraShot(true);
		} else {
			esp.setExtraShot(false);
		}
		
		System.out.println("Would you like this espresso to be made in macchiato style? (+$1.00) Y/N");
		truefalse = scan.next();
		if (truefalse.equals("Y")) {
			esp.setMacchiato(true);
		} else {
			esp.setMacchiato(false);
		}

		adder = "";
		if (esp.isExtraShot() && esp.isMacchiato()) {
			adder = " with an extra shot and in macchiato style";
		} else {
			if (esp.isExtraShot()) {
				adder = " with an extra shot";
			} else {
				if (esp.isMacchiato()) {
					adder = " in macchiato style";
				}
			}
		}
		System.out.println("Product Name: " + esp.getName() + adder + '\n' + "Description " + esp.getDescription() + '\n'
				+ "Product Subtotal: $" + esp.calculateProductTotal());

		System.out.println("How many cups of cappuccino would you like? ($8.00 each)");
		cap.setQuantity(scan.nextInt());
		System.out.println("Would you like to add peppermint? (+$2.00) Y/N");
		truefalse = scan.next();
		if (truefalse.equals("Y")) {
			cap.setPeppermint(true);
		} else {
			cap.setPeppermint(false);
		}
		
		System.out.println("Would you like to add whipped cream? (+$1.00) Y/N");
		truefalse = scan.next();
		if (truefalse.equals("Y")) {
			cap.setWhippedCream(true);
		} else {
			cap.setWhippedCream(false);
		}

		adder = "";
		if (cap.isPeppermint() && cap.isWhippedCream()) {
			adder = " with peppermint and whipped cream";
		} else {
			if (cap.isPeppermint()) {
				adder = " with peppermint";
			} else {
				if (cap.isWhippedCream()) {
					adder = " with whipped cream";
				}
			}
		}
		
		System.out.println("Product Name: " + cap.getName() + adder + '\n' + "Description " + cap.getDescription() + '\n'
				+ "Product Subtotal: $" + cap.calculateProductTotal());

		double subtotal = cof.calculateProductTotal() + esp.calculateProductTotal() + cap.calculateProductTotal();
		subtotal = Math.floor((subtotal) * 100) / 100;
		double tax = Math.floor((subtotal * salesTax) * 100) / 100;
		double total = Math.floor((subtotal + tax)*100)/100;
		System.out.println("Subtotal: $" + subtotal);
		System.out.println("Sales Tax: $" + tax);
		System.out.println("Total: $" + total);

		scan.close();
	}

}
