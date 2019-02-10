package com.techelevator.FileReader;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.techelevator.Items.Item;
import com.techelevator.machine.MachineInventory;
import com.techelevator.vendingmachine.exception.LoadVendingMachineException;

public interface FileReader {

	MachineInventory read() throws LoadVendingMachineException;

}
