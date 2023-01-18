package com.demo.app;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



public class TestThrows {
	@Test
    public void testLowBalanceException() {
        Account account = new Account();
        account.deposit(500);
        ;
        LowBalanceException exception = assertThrows(LowBalanceException.class, () -> {
            account.withdraw(50001);
        });
        assertTrue(exception.getMessage().contains("account has low balance"));
   }
}