package com.techelevator.Items;

import java.math.BigDecimal;
import java.util.List;

import com.techelevator.FileReader.FileReader;

public class Item {
	
	private String name;
	private BigDecimal price;
	
	
	//constructor
	public Item(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	//methods
	
	
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
		

}
