package com.techelevator.Items;

import java.math.BigDecimal;

public class Candy extends Item {

	public Candy(String name, double price, int quantity, String slot) {
		super(slot, name, price, quantity);
		// TODO Auto-generated constructor stub
	}


	public String consumeSound() {
		String sound = ("Munch Munch, Yum!");
		return sound;	
	}
	

	
	

}
