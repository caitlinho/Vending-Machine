package com.techelevator.Items;

public class Item {
	
	private String name;
	private double price;
	private int quantity;
	private String slot;
	
	//constructor
	public Item(String slot, String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.slot = slot;
	}

	//Getters and Setters
	public String getSound (String slot) {
		if (slot.contains("A")) {
			return "Crunch, Crunch, Yum!";
		} else if (slot.contains("B")) {
			return "Munch, Munch, Yum!";
		} else if (slot.contains("C")) {
			return "Glug, Glug, Yum!";
		} else if (slot.contains("D")) {
			return "Chew, Chew , Yum!";	
		}
		return null;
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
