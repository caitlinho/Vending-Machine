package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.techelevator.CashRegister.UserMoney;
import com.techelevator.FileReader.FileItemReader;
import com.techelevator.Items.Item;
import com.techelevator.machine.AuditLog;
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
	AuditLog auditLog;
	
	
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.inventory = new MachineInventory();
		this.thisFileItemReader = new FileItemReader();
		this.userMoney = new UserMoney();
		this.shoppingCart = new ShoppingCart(null);
		this.auditLog = new AuditLog();
	}
	
	
	
	public void run() throws LoadVendingMachineException, IOException {
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
						 
						 userMoney.addMoney(tenderAmount);
						 shoppingCart.setFedMoney(tenderAmount);
						 
						 
						 //display current balance
						 menu.displayCurrentBalance(userMoney.getBalance());
						 
						 //write to log file
						 auditLog.writeToFile("FEED MONEY", tenderAmount, userMoney.getBalance());
						 
					} else if (choice2.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {
								//get slot number from user
						
								String slot = null;
								
								slot = menu.getProductChoice().toUpperCase();
								
								try {
									//checking for sufficient funds
									if (userMoney.getBalance() < inventory.getInventory().get(slot).getPrice()) {
										menu.insufficientFunds();
									} 
									else if (userMoney.getBalance() > inventory.getInventory().get(slot).getPrice()) {
									
										//add product choice to the list of user choice in ShoppingCart
										shoppingCart.setItemsPurchased(slot);
									
										//check inventory
										if (inventory.getInventory().get(slot).getQuantity() <= 0) {
											menu.soldOutMessage();
										} 
										else {
											//remove that item from inventory
											inventory.removeItemFromSlot(slot);
										
											//write to log file
											 auditLog.writeToFile(inventory.getInventory().get(slot).getName(),
												 					userMoney.getBalance(), 
												 					(userMoney.getBalance() - inventory.getInventory().get(slot).getPrice()));	
												 
											//subtracting price of product from current balance
											userMoney.buyProduct(inventory.getInventory().get(slot).getPrice());
										}
									}
									 
									//display current balance
									menu.displayCurrentBalance(userMoney.getBalance());	
						
								} catch (NullPointerException e) {
									menu.productDoesNotMessage();
							}
							
					} else if (choice2.equals(SUB_MENU_OPTION_FINISH_TRANSACTION)) {
							
							//Audit log writing
								auditLog.writeToFile("GIVE CHANGE", userMoney.getBalance(), (userMoney.getBalance() - userMoney.getBalance()) );
						
							//display change owed to user
								menu.printUsersChange(userMoney.getChange());
							
							//print list of items purchased
							for(String thisItem : shoppingCart.getItemsPurchased()) {
								menu.printItemsPurchased(inventory.getInventory().get(thisItem).getName());
							}
							
							//print consumed message
							for(String thisItem : shoppingCart.getItemsPurchased()) {
								String message = inventory.getInventory().get(thisItem).getSound(thisItem);
								menu.printConsumedMessage(message);
							}
							
							break;
						}
					}
				}
			}
		
	}
	
	public static void main(String[] args) throws LoadVendingMachineException, IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
