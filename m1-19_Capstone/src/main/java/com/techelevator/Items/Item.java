package com.techelevator.Items;

import java.math.BigDecimal;
import java.util.List;

import com.techelevator.FileReader.FileReader;

public class Item {
	
	private String name;
	private double price;
	private int quantity;
	private String slot;
	private String sound;
	
	//constructor
	public Item(String slot, String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.slot = slot;
	}

	//Getters and Setters
	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

}
