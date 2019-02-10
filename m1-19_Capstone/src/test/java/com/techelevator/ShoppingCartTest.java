package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;



import com.techelevator.shoppingcart.ShoppingCart;

public class ShoppingCartTest {
	
	private ShoppingCart target;
	
	@Before
	public void setup() {
		target = new ShoppingCart(null);
	}
	
	@Test
	public void does_set_method_to_add_purchased_slot_to_list_works() {
		//Arrange
		List<String> slots = new ArrayList<>();
		slots.add("A1");
		
		//Act
		target.setItemsPurchased("A1");
		target.setItemsPurchased("B1");
		target.setItemsPurchased("C1");
		target.setItemsPurchased("D1");
		
		
		//Assert
		Assert.assertEquals("A1", target.getItemsPurchased().get(0));
		Assert.assertEquals("B1", target.getItemsPurchased().get(1));
		Assert.assertEquals("C1", target.getItemsPurchased().get(2));
		Assert.assertEquals("D1", target.getItemsPurchased().get(3));

	}
	

}
