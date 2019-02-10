package com.techelevator;

import org.junit.*;

import com.techelevator.Items.Item;

public class ItemTest {
	
	private Item target;
	
	@Before
	public void setup() {
		target = new Item(null, null, 0, 0);
	}
}
