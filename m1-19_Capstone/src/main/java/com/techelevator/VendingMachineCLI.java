package com.techelevator;

import java.util.Map;
import java.util.Set;

import com.techelevator.CashRegister.UserMoney;
import com.techelevator.FileReader.FileItemReader;
import com.techelevator.Items.Item;
import com.techelevator.machine.MachineInventory;
import com.techelevator.shoppingcart.ShoppingCart;
import com.techelevator.vendingmachine.exception.LoadVendingMachineException;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	
	private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String SUB_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String SUB_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_OPTION_FEED_MONEY,
														SUB_MENU_OPTION_SELECT_PRODUCT,
														SUB_MENU_OPTION_FINISH_TRANSACTION};
	
	
	private Menu menu;
	FileItemReader thisFileItemReader;
	MachineInventory inventory;
	UserMoney userMoney;
	ShoppingCart shoppingCart;
	
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.inventory = new MachineInventory();
		this.thisFileItemReader = new FileItemReader();
		this.userMoney = new UserMoney();
		this.shoppingCart = new ShoppingCart(null);
	}
	
	public void run() {
		try {
			inventory = thisFileItemReader.read();
		}catch (Exception e) {
			e.printStackTrace();
		}
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				Map<String, Item> inventoryMap = inventory.getInventory();
				menu.displayVendingMachineItems(inventoryMap);
						
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				while(true) {
					
					String choice2 = (String)menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
					//display current balance
					menu.displayCurrentBalance(userMoney.getBalance());
					
					if (choice2.equals(SUB_MENU_OPTION_FEED_MONEY)) {
						 
						 //getting tendered amount from user
						 double tenderAmount = menu.getTenderFromUser();
						 userMoney.setBalance(tenderAmount);
						 //display current balance
						 menu.displayCurrentBalance(userMoney.getBalance());
						 						 
					} else if (choice2.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {
						
							/*functionality to catch invalid product code entered*/
							
							//get slot number from user
							String slot = menu.getProductChoice();
							//add product choice to the list of user choice in ShoppingCart
							shoppingCart.setItemsPurchased(slot);
							//remove that item from inventory
							inventory.removeItemFromSlot(slot);
							//subtracting price of product from current balance
							userMoney.buyProduct(inventory.getInventory().get(slot).getPrice());
							
							//display current balance
							menu.displayCurrentBalance(userMoney.getBalance());
							
							
					} else if (choice2.equals(SUB_MENU_OPTION_FINISH_TRANSACTION)) {
							
							//display change owed to user
							menu.printUsersChange(userMoney.getChange());
							
							//print list of items purchased
							for(String thisItem : shoppingCart.getItemsPurchased()) {
								menu.printItemsPurchased(inventory.getInventory().get(thisItem).getName());
							}
							
							//print consumed message
							for(String thisItem : shoppingCart.getItemsPurchased()) {
								menu.printConsumedMessage(inventory.getInventory().get(thisItem).getSound());
							}
							
							break;
						}
					}
				
				}
			}
		
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
