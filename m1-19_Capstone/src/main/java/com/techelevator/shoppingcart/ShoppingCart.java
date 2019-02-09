package com.techelevator.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.CashRegister.UserMoney;

public class ShoppingCart {
	
	List<String> itemsPurchased;	//store one or all the purchases made by user in one transaction
	UserMoney userMoney; 
	
	//Construct
	public ShoppingCart(List<String> itemsPurchased) {
		this.userMoney = new UserMoney();
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
