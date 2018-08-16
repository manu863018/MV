package org.gradle.sample;

import org.junit.Test;
import static org.junit.Assert.*;

public class GreeterTest {
    @Test
    public void test() {
        Greeter greeter = new Greeter();
        try {
            assertEquals("Hello World!", greeter.getGreeting());
        }catch(Exception e) {}
    }
	
	@Test
    public void testAddTwoNumbers() {
        Greeter greeter = new Greeter();        
		assertEquals(4, greeter.addTwoNumbers(1, 3));
        
    }
	
	@Test
    public void testMultiplyTwoNumbers() {
        Greeter greeter = new Greeter();        
		assertEquals(21.0, greeter.multiplyTwoNumbers(7.0, 3.0), 0);
        
    }	
}
