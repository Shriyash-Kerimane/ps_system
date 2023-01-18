package com.demo.app;
public class Account {
    private double amount;



   public Account() {
        this.amount = amount;
    }



   public double getBalance() {
        return amount;
    }



   public double deposit(double damount) {
        amount = amount + damount;
        return amount;
    }



   public double withdraw(double wamount) throws LowBalanceException {
        try {
            if (wamount > amount) {
                throw new LowBalanceException("Account has low balance");
            } else {
                amount = amount - wamount;
                return amount;
            }



       } catch (LowBalanceException e) {
            throw new LowBalanceException(e.getMessage());
        }



   }



}