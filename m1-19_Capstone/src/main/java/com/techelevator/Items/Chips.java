package com.techelevator.Items;

import java.math.BigDecimal;

public class Chips extends Item{

	public Chips(String name, double price, int quantity, String slot) {
		super(slot, name, price, quantity);
		// TODO Auto-generated constructor stub
	}

	public String consumeSound() {
		String sound = ("Crunch Crunch, Yum!");
		return sound;	
	}
		
}
