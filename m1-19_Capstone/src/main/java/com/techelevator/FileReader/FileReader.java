package com.techelevator.FileReader;

import java.io.File;
import java.util.List;

import com.techelevator.Items.Item;
import com.techelevator.vendingmachine.exception.LoadVendingMachineException;

public interface FileReader {
	
	
	
	List<Item> read() throws LoadVendingMachineException;

}
