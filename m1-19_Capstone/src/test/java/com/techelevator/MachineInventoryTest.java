package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.techelevator.Items.Item;
import com.techelevator.machine.MachineInventory;


public class MachineInventoryTest {
	
	private MachineInventory target;
	
	@Before
	public void setup() {
		target = new MachineInventory();
	}
	
	@Test
	public void add_item_to_slot_actually_adds_to_map() {
		//Arrange
		String slotString = "B3";
		String candyNameString = "Skittles";
		Item itemExample = new Item(slotString, candyNameString, 0.85, 3);
		//Act
		target.addItemToSlot("B3", itemExample);
		//Assert
		Assert.assertEquals("Skittles", target.getInventory().get("B3").getName());
	}
	
	@Test
	public void remove_item_from_slot_after_buying() {
		//Arrange
		String slotString = "D2";
		String gumString = "Orbit";
		Item item = new Item(slotString, gumString, 0.75, 4);
		target.addItemToSlot(slotString, item);
		//Act
		target.removeItemFromSlot("D2");
		//Assert
		Assert.assertEquals(3, target.getInventory().get("D2").getQuantity());
	}
}
