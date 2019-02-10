package com.techelevator.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.CashRegister.UserMoney;

public class ShoppingCart {
	
	List<String> itemsPurchased;	//store one or all the purchases made by user in one transaction
	UserMoney userMoney; 
	List<Double> fedMoney;			//store the instances of money fed by the user
	
	//Construct
	public ShoppingCart(List<String> itemsPurchased) {
		this.userMoney = new UserMoney();
		this.itemsPurchased = new ArrayList<>();
		this.fedMoney = new ArrayList<>();
	}

	//GETTER and SETTER
	public List<String> getItemsPurchased() {		
		return itemsPurchased;
	}
	public void setItemsPurchased(String slot) {
		itemsPurchased.add(slot);
		this.itemsPurchased = itemsPurchased;
	}
	public List<Double> getFedMoney() {
		return fedMoney;
	}
	public void setFedMoney(double tenderAmount) {
		fedMoney.add(tenderAmount);		//widening
		this.fedMoney = fedMoney;
	}
	
	
}
