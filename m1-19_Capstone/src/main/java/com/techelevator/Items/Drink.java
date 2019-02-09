package com.techelevator.Items;

import java.math.BigDecimal;

public class Drink extends Item {

	public Drink(String name, double price, int quantity, String slot) {
		super(slot, name, price, quantity);
		// TODO Auto-generated constructor stub
	}

	public String consumeSound() {
		String sound = ("Glug Glug, Yum!");
		return sound;	
	}

}
