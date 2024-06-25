package PracticeTest;

import org.testng.annotations.Test;

public class Priority_in_TestNG {
	
	@Test(priority = 1) 
	public void testMethodA() { 
	   System.out.println("Executing - testMethodA");
	} 
	@Test 
	public void testMethodB() { 
	   System.out.println("Executing - testMethodB");
	}
	@Test(priority = 2) 
	public void testMethodC() { 
	   System.out.println("Executing - testMethodC");
	}

}
