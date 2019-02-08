package com.techelevator;

import java.util.List;

import org.junit.Before;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.techelevator.machine.MachineInventory;

import junit.framework.Assert;

public class InventoryTest {

	public static void main(String[] args) {

		private MachineInventory target;
		
		@Before
		public void setup() {
			target = new MachineInventory;
		}
		
		@Test
		public is_addItemToSlot_working_correctly() {
			List<String> thisItem = new ArrayList<>();
			for (int i = 0; i<5; i++) {
			thisItem.add(chip);
			}
			target.addItemToSlot("A1", thisItem);
			
			Assert.assertEquals(thisItem, target.addItemToSlot("A1", items););
		}
		
	}

}
