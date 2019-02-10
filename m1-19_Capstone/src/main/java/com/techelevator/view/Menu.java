package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.Items.Item;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			if (userInput.contains("A") || userInput.contains("B") || userInput.contains("C") || userInput.contains("D")) {
				choice = userInput;
			} else {
				int selectedOption = Integer.valueOf(userInput);
				if(selectedOption > 0 && selectedOption <= options.length) {
					choice = options[selectedOption - 1];
				}
			}  
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
	
	//Display Inventory
	public void displayVendingMachineItems(Map<String, Item> inventoryMap) {	
		for (String thisValue : inventoryMap.keySet()) {
			String slot = inventoryMap.get(thisValue).getSlot();
			String name = inventoryMap.get(thisValue).getName();
			double price = inventoryMap.get(thisValue).getPrice();
			int quantity = inventoryMap.get(thisValue).getQuantity();
			if (quantity > 0) {
				System.out.printf("%-5s %-21s $%-8.2f %-11s \n", slot, name, price, quantity + " Remaining");
			} else {
				System.out.printf("%-5s %-21s $%-8.2f %-11s \n", slot, name, price,  " Sold Out");
			}
		}	
	}
	
	//Display CURRENT BALANCE
		public void displayCurrentBalance(double currentBalance) {
			System.out.printf("Current Money Provided: $%.2f", currentBalance);
		}
	
	//Get money from user
	public double getTenderFromUser() {
		System.out.print("\nPlease enter amount ($1, $2, $5, $10)>>> " );
		String tender = in.nextLine();
		String removeDollarSign = tender.substring(1);
		double tenderAmount = Double.parseDouble(removeDollarSign);
		return tenderAmount;
	}
	
	//Please enter valid input
	public void enterValidInput() {
		System.out.print("\nPlease enter choice from given options");
	}
	
	//Capturing Users product selection
	public String getProductChoice() {	
		System.out.print("\nPlease select product>>> ");
		String productChoice = in.nextLine();
		return productChoice;
	}
	
	//Check if balance is greater than price
	public void insufficientFunds() {
		System.out.println("\nInsert more money");
	}
	
	//Printing sold out message
	public void soldOutMessage() {
		System.out.print("Product Sold OUT");
	}
	
	//printing product does not exist
	public void productDoesNotMessage() {
		System.out.print("Product DOES NOT EXIST");
	}
	
	//Printing Users change
	public void printUsersChange(String yourChange) {
		System.out.println();
		System.out.println(yourChange);
	}
	
	//Printing list of item purchased
	public void printItemsPurchased(String item) {
		System.out.println();
		System.out.println(item);
	}
	
	//Printing sounds
	public void printConsumedMessage(String message) {
		System.out.println();
		System.out.println(message);
	}
	
}
