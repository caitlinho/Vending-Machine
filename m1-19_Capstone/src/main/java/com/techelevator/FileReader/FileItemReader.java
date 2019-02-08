package com.techelevator.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sound.sampled.Line;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import com.techelevator.Items.Candy;
import com.techelevator.Items.Chips;
import com.techelevator.Items.Drink;
import com.techelevator.Items.Gum;
import com.techelevator.Items.Item;
import com.techelevator.machine.MachineInventory;
import com.techelevator.vendingmachine.exception.LoadVendingMachineException;

public class FileItemReader implements FileReader {
	
	private String filePath = "/m1-java-capstone-vending-machine/vendingmachine.csv";
	
	
	//File filePath = new File("/m1-java-capstone-vending-machine/vendingmachine.csv");
	
	/*
	 * Constructor 
	 */
	public FileItemReader (String filePath) {
		this.filePath = filePath;
	}
	
	
	
	@Override
	public List<Item> read() throws LoadVendingMachineException {
		
		List<String> itemsLines = new ArrayList<>();
		
		try {
			itemsLines = readFile();
		} catch (FileNotFoundException e) {
			throw new LoadVendingMachineException ("File Not Found", e);
		}
		
		return buildItemsFromFile(itemsLines);
	}
	
	//Reading Vendingmachine.csv and putting items in a List.
	private List<String> readFile() throws FileNotFoundException {
			
		List<String> itemsLines = new ArrayList<>();
			
		File inputFile = new File(filePath);
			
		try (Scanner newScanner = new Scanner(inputFile)) {
			while(newScanner.hasNextLine()) {
				itemsLines.add(newScanner.nextLine());
			}
				
		}
			return itemsLines;
	}
	
	
	private List<Item> buildItemsFromFile(List<String> itemsLines) {
		String[] itemInfo = null;
		List<Item> items = new ArrayList<Item>();
		
		//Instantiate a Machine Inventory instance
				MachineInventory inventory = new MachineInventory();
		
		for (String thisLine : itemsLines) {
			if (thisLine == null) {
				continue;
			}
			itemInfo = thisLine.split("\\|");
	
		/*
		 * Creating 5 instances of Chips
		 */
		List<Item> chipList = new ArrayList<>();
			if(itemInfo[0].contains("A")) {
				for (int i = 1; i <= 5; i++) {
				Chips chips = new Chips(itemInfo[1], new BigDecimal(itemInfo[2]));
				chipList.add(chips);
				}
				inventory.addItemToSlot(itemInfo[0], chipList);
			}
		
			/*
			 * Creating 5 instances of Candy
			 */
			List<Item> candyList = new ArrayList<>();
				if(itemInfo[0].contains("B")) {
					for (int i = 1; i <= 5; i++) {
					Candy candy = new Candy(itemInfo[1], new BigDecimal(itemInfo[2]));
					candyList.add(candy);
					}
					inventory.addItemToSlot(itemInfo[0], candyList);
				}
	
				/*
				 * Creating 5 instances of Drink
				 */
				List<Item> drinkList = new ArrayList<>();
					if(itemInfo[0].contains("C")) {
						for (int i = 1; i <= 5; i++) {
						Drink drink = new Drink(itemInfo[1], new BigDecimal(itemInfo[2]));
						drinkList.add(drink);
						}
						inventory.addItemToSlot(itemInfo[0], candyList);
					}
					/*
					 * Creating 5 instances of Gum
					 */
					List<Item> gumList = new ArrayList<>();

						if(itemInfo[0].contains("D")) {
							for (int i = 1; i <= 5; i++) {
							Gum gum = new Gum(itemInfo[1], new BigDecimal(itemInfo[2]));
							gumList.add(gum);
							}
							inventory.addItemToSlot(itemInfo[0], gumList);
						}
		}
		return items;
	}
		
}
