package com.techelevator;

import java.util.Map;
import java.util.Set;

import com.techelevator.CashRegister.UserMoney;
import com.techelevator.FileReader.FileItemReader;
import com.techelevator.Items.Item;
import com.techelevator.machine.MachineInventory;
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
	
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.inventory = new MachineInventory();
		this.thisFileItemReader = new FileItemReader();
		this.userMoney = new UserMoney();
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
					
					double currentBalance = userMoney.getBalance();
					menu.displayCurrentBalance(currentBalance);
					
					if (choice2.equals(SUB_MENU_OPTION_FEED_MONEY)) {
						 menu.getTenderFromUser();
						 
					} else if (choice2.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {
						//functionality to catch invalid product code entered
						// and return user to "Please Select product"
						String slot = menu.getProductChoice();
						inventory.removeItemFromSlot(slot);
						double price = inventory.getInventory().get(slot).getPrice();
						userMoney.buyProduct(price);	
					} else if (choice2.equals(SUB_MENU_OPTION_FINISH_TRANSACTION)) {
						menu.printUsersChange(userMoney.getChange());
//						menu.printConsumedMessage(inventory.getInventory().get(slot));
//						menu.printConsumeMessage(<>);		//Items - slot key
//						menu.printListOfItemsBought(<>);	//shopping cart
						
					}
					break;
				}
			}
			
			/*
			 * use when need to debug
			 */
			
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
