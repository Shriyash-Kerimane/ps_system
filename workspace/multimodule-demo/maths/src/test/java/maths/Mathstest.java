package maths;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Mathstest {



	   @Test
	    public void testAdd() {
	        Maths m = new Maths();
	        assertEquals(5, m.add(2, 2));
	    }
}