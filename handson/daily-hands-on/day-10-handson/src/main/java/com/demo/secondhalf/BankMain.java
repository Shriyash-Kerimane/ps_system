package com.demo.secondhalf;

public class BankMain {

	public static void main(String[] args) {
		Account account=new Account();
		
		account.deposit(5000);
		account.deposit(25000);
		System.out.println("Current Balance is "+account.getBalance());
		try {
		account.withdraw(10000);
		account.withdraw(27000);
		}catch (LowBalanceException e) {
			System.out.println(e);
		}

	}
}
