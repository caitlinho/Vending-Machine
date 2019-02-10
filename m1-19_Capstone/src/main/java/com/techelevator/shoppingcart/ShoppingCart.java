package com.techelevator.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.CashRegister.UserMoney;

public class ShoppingCart {
	
	List<String> itemsPurchased;	//store all the purchases made by user in one transaction
	
	//Construct
	public ShoppingCart(List<String> itemsPurchased) {
		this.itemsPurchased = new ArrayList<>();
	}

	//GETTER and SETTER
	public List<String> getItemsPurchased() {		
		return itemsPurchased;
	}
	public void setItemsPurchased(String slot) {
		itemsPurchased.add(slot);
		this.itemsPurchased = itemsPurchased;
	}	
}
