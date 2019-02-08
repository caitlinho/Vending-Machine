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
	
	public void displayCurrentBalance(double currentBalance) {
		System.out.println("Current Money Provided: $" + currentBalance);
	}
	
	public void displayVendingMachineItems(Map<String, Item> inventoryMap) {	
		for (String thisValue : inventoryMap.keySet()) {
			String slot = inventoryMap.get(thisValue).getSlot();
			String name = inventoryMap.get(thisValue).getName();
			double price = inventoryMap.get(thisValue).getPrice();
			int quantity = inventoryMap.get(thisValue).getQuantity();
			if (quantity != 0) {
				System.out.printf("%-5s %-21s $%-8.2f %-11s \n", slot, name, price, quantity + " Remaining");
			} else {
				System.out.printf("%-5s %-21s $%-8.2f %-11s \n", slot, name, price,  " Sold Out");

			}
		}	
	}
	
	//playing how to get money from use
		public double getTenderFromUser() {
			
			System.out.println("Please enter amount ($1, $2, $5, $10): " );
			String tender = in.nextLine();
			String removeDollarSign = tender.substring(1);
			
			double tenderAmount = Double.parseDouble(removeDollarSign);
			
		
			return tenderAmount;
		}
	
	//Capturing Users product selection
	
	public String getProductChoice() {
		
		System.out.println("Please select product: ");
		String productChoice = in.nextLine();
		return productChoice;
	}
	
	//Printing Users change
	
	public void printUsersChange(String yourChange) {
		System.out.println(yourChange);
	}
	
	//Print stupid noises
	
	public void printConsumedMessage(String message) {
		System.out.println(message);
	}
	
}
