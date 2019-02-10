package com.techelevator;

import org.junit.*;

import com.techelevator.CashRegister.UserMoney;

public class UserMoneyTest {

	private UserMoney target;
	
	@Before
	public void setup() {
		target = new UserMoney();
	}
	
	@Test
	public void does_addMoney_method_increments_and_updates_balance() {
		//Arrange
		double money = 5.00;
		//Act
		target.addMoney(money + 2.00);
		//Assert
		Assert.assertEquals(7.00, target.getBalance(), 0.001);
	}
	
	@Test
	public void does_buyProduct_method_deduct_price_of_item_purchased() {
		//Arrange
		double money = 5.00;
		double price = 3.65;
		//Act
		target.addMoney(money);
		target.buyProduct(price);
		//Assert
		Assert.assertEquals((money-price), target.getBalance(), 0.001);
	}
	
	@Test
	public void does_get_change_method_provide_correct_change_for_quarters() {
		//Arrange
		double money = 0.25;
		String change = "your Change is: \n" + 1 + " Quarters " +
						0 + " Dimes " + 0 + " Nickles " + 0 + " Pennies ";
		//Act
		target.addMoney(money);
		//Assert
		Assert.assertEquals(change, target.getChange());
	}
	
	@Test
	public void does_get_change_method_provide_correct_change_for_dimes() {
		//Arrange
		double money = 0.10;
		String change = "your Change is: \n" + 0 + " Quarters " +
						1 + " Dimes " + 0 + " Nickles " + 0 + " Pennies ";
		//Act
		target.addMoney(money);
		//Assert
		Assert.assertEquals(change, target.getChange());
	}
	
	@Test
	public void does_get_change_method_provide_correct_change_for_nickles() {
		//Arrange
		double money = 0.05;
		String change = "your Change is: \n" + 0 + " Quarters " +
						0 + " Dimes " + 1 + " Nickles " + 0 + " Pennies ";
		//Act
		target.addMoney(money);
		//Assert
		Assert.assertEquals(change, target.getChange());
	}
	
	@Test
	public void does_get_change_method_provide_correct_change_for_pennies() {
		//Arrange
		double money = 0.01;
		String change = "your Change is: \n" + 0 + " Quarters " +
						0 + " Dimes " + 0 + " Nickles " + 1 + " Pennies ";
		//Act
		target.addMoney(money);
		//Assert
		Assert.assertEquals(change, target.getChange());
	}
	
	@Test
	public void does_get_change_method_provide_correct_change_for_mixed_change() {
		//Arrange
		double money = 0.41;
		String change = "your Change is: \n" + 1 + " Quarters " +
						1 + " Dimes " + 1 + " Nickles " + 1 + " Pennies ";
		//Act
		target.addMoney(money);
		//Assert
		Assert.assertEquals(change, target.getChange());
	}	
}
