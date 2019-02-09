package com.techelevator.Items;

import java.math.BigDecimal;

public class Gum extends Item {

	public Gum(String name, double price, int quantity, String slot) {
		super(slot, name, price, quantity);
		// TODO Auto-generated constructor stub
	}

	public String consumeSound() {
		String sound = ("Chew Chew, Yum!");
		return sound;	
	}

}
