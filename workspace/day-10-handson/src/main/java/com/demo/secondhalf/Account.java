package com.demo.secondhalf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Account {
	private double balance;
	
	private Logger LOGGER = LogManager.getLogger(this.getClass().getName());

	public Account() {
		
		LOGGER.info("An Account object is created");

	}
	public Account(double balance) {
		LOGGER.info("Account Balance Updated");
		this.balance = balance;
	}
	public double deposit(double amount) {
		LOGGER.info("Amount deposited");
		this.balance = this.balance + amount;
		return this.balance;
	}
	public double withdraw(double amount) throws LowBalanceException {

		try {
			if (amount > balance) {
				throw new LowBalanceException("Balance is Low");
			} else {
				LOGGER.info("Withdraw Successful");
				this.balance = this.balance - amount;
				System.out.println(" Transaction sucessful");
				return this.balance;
			}
		} catch (LowBalanceException e) {
			LOGGER.error("withdraw is in error condition : ",e.fillInStackTrace());
			LOGGER.warn("withdraw is in error condition : ",e.fillInStackTrace());
			throw e;
		}

	}

	public double getBalance() {
		return this.balance;
	}
}
		


