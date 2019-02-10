package com.techelevator.CashRegister;

public class UserMoney {
	
	double balance;
	int change;
	
	public void addMoney(double money) {
		balance = this.balance + money;
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
		balance = balance - change;
		return yourChange;
	}

	public double getBalance() {
		return this.balance;
	}
}
