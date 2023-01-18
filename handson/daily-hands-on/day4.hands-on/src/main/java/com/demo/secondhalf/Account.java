package com.demo.secondhalf;

public class Account {
	private double amount=0;
	
	public double getBalance (){
		return amount;
	}
	
	public void deposit(double amount) {
		this.amount=this.amount+amount;
		
	}
	public void withdraw(double amount) throws LowBalanceException {
		try {
		if (this.amount>= amount) {
			this.amount=this.amount-amount;
			System.out.println("done");
		}
		else {
			throw new LowBalanceException("Low Balance");
		}}catch(LowBalanceException e) {
			throw e;
		}
		}
		
		
	}

