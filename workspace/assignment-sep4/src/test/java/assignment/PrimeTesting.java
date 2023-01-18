package assignment;

import org.junit.Assert;

public class PrimeTesting {

   boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

       // Check from 2 to square root of n
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
       return true;
    }

   public void testcase1(int data) {
        // use data for testing
        // use assert fail to fail the test case
        boolean result = isPrime(data);
        if (result) {
            System.out.println("It is Prime");
       } else {
            Assert.fail();
        }
    }
}