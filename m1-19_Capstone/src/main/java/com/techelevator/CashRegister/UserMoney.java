package com.techelevator.CashRegister;

public class UserMoney {
	
	double tenderAmount;
	double balance;
	int change;
	
	public void addMoney() {
		balance += tenderAmount;
	}
	
	public void buyProduct(double price) {
		balance -= price;
	}
	
	public String getChange() {
		int numberOfQuarters = 0;
		int numberOfDimes = 0;
		int numberOfNickles = 0;
		int numberOfPennies = 0;
		
		change = (int) (balance * 100);
		
		while(change >=  25) {
			
			numberOfQuarters = change / 25;
			change = change % 25;
		}
		while(change >=  10) {
			numberOfDimes = change / 10;
			change = change % 10;
		}
		while(change >=  5) {
			numberOfNickles = change / 5;
			change = change % 5;
		}
		while(change >=  1) {
			numberOfPennies = change / 1;
			change = change % 1;
		}
		String yourChange = ("your Change is: \n" + numberOfQuarters + " Quarters " + 
								numberOfDimes + " Dimes " + numberOfNickles + 
								" Nickles " + numberOfPennies + " Pennies ");
	
		return yourChange;
	}
	
	//Getter and Setter
	public double getTenderAmount() {
		return tenderAmount;
	}
	public void setTenderAmount(double tenderAmount) {
		this.tenderAmount = tenderAmount;
	}
	public double getBalance() {
		return this.balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
