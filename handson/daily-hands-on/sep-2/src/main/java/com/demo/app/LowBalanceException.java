package com.demo.app;
public class LowBalanceException extends Exception {
    public LowBalanceException() {



   }



   public LowBalanceException(String message) {
        super(message);
    }



   public String toString() {
        return this.getClass().getName() + " " + super.getMessage();
    }



}