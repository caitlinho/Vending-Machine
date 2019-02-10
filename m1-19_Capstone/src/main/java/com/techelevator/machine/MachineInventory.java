package com.techelevator.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.print.attribute.Size2DSyntax;

import com.techelevator.Items.Item;

public class MachineInventory {
	
	Map<String, Item> inventory = new TreeMap<String, Item>();
	
	/*
	 * method to add items to inventory
	 */
	
	public void addItemToSlot(String slot, Item item) {
		 this.inventory.put(slot, item);
	}
	
	/*
	 * 
	 */
	public void removeItemFromSlot(String slot) {
		/*
		 * getting the Quantity from Item class .get() method
		 * decrementing by 1
		 * setting the new Quantity in Item class via .set() method
		 */
		int qty = this.inventory.get(slot).getQuantity();
		this.inventory.get(slot).setQuantity(qty - 1); 
	}

	/*
	 * GETTER to display items
	 */
	
	public Map<String, Item> getInventory() {		
		return this.inventory;
	}

}
