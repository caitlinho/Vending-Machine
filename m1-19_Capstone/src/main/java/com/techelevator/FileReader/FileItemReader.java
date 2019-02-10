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
	
	private String filePath = "vendingmachine.csv";
	
	@Override
	public MachineInventory read() throws LoadVendingMachineException {
		List<String> line;
		try {
			line = readFile();
		} catch(FileNotFoundException e) {
			throw new LoadVendingMachineException("File Not Found", e);
		}
		return buildItemsFromFile(line);
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
	
	
	private MachineInventory buildItemsFromFile(List<String> itemsLines) {
		
		String[] itemInfo = null;
		List<Item> items = new ArrayList<Item>();
		
		//Instantiate a Machine Inventory instance
				MachineInventory inventory = new MachineInventory();
		//Instantiate Item class
				
		
		for (String thisLine : itemsLines) {
			Item thisItem = new Item ("", "", 0.00, 5);	//initial quantity of 5
			if (thisLine == null) {
				continue; 
			}
				//Splitting the incoming String line
			
				itemInfo = thisLine.split("\\|");
				
				thisItem.setSlot(itemInfo[0]);
				thisItem.setName(itemInfo[1]);
				thisItem.setPrice(Double.parseDouble(itemInfo[2]));
				
				inventory.addItemToSlot(itemInfo[0], thisItem);
			
		}
		
				return inventory;
	}
		
}
