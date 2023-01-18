package com.demo.secondhalf;

public class Bank {
	
		Account account;

		public void createAccount(double balance) {
			this.account = new Account(balance);
		}

		public Account getAccount() {
			return this.account;
		}
}
