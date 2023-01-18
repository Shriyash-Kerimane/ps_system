package com.demo.secondhalf;

public class Bank {
	public Bank() {
		Account a1 = new Account();
		a1.deposit(1000);
		try {
			a1.withdraw(1500);
		}catch(LowBalanceException e) {
			e.printStackTrace();
		}
		System.out.println(a1.getBalance());
		System.out.println("Successfull");
	}

}
