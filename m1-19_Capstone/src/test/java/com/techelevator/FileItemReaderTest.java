package com.techelevator;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import com.techelevator.FileReader.FileItemReader;
import com.techelevator.machine.MachineInventory;
import com.techelevator.vendingmachine.exception.LoadVendingMachineException;


public class FileItemReaderTest {

	private FileItemReader fileReader;
	
	@Before
	public void setup() {
		fileReader = new FileItemReader();
	}
	
	@Test
	public void machine_iinventory_was_created() throws LoadVendingMachineException {
		//Arrange
		MachineInventory inventory = fileReader.read();
		//Assert
		Assert.assertEquals("Potato Crisps",inventory.getInventory().get("A1").getName());
	}
}
