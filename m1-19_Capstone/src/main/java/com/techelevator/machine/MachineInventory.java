package com.techelevator.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.Size2DSyntax;

import com.techelevator.Items.Item;




public class MachineInventory {
	
	
	Map<String, List<Item>> inventory = new HashMap<String, List<Item>>();
	
	/*
	 * method to add items to inventory
	 */
	
	public void addItemToSlot(String slot, List<Item>items) {
		 inventory.put(slot, items);
	}
	
	public List<Item> removeItemFromSlot(String slot) {
		/*
		 * we are taking list of Objects and assigning it to List
		 */
		List<Item >thisItem = inventory.get(slot);
		/*
		 * removing one instance of object from the List
		 */
		thisItem.remove(0);
		/*
		 * updating the inventory
		 */
		inventory.put(slot, removeItemFromSlot(slot));
		//return chipsItems.size();
		
		return thisItem;
	}
	/*
	 * method to use when display of items is needed
	 * inquiry of stock is made
	 */
	public Map<String, List<Item>> getInventory(String slot) {
		
		return this.inventory;
	}
	
	 
	
	

}
