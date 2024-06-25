package TESTNG_Automation;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class Skip_Test_Cases {
	
	boolean datasetup = true;
	
	@Test(enabled = false)
	public void skipTest1() {
		
		System.out.println("Skipping the Test1");
		
	}
	
	@Test
	public void skipTest2() {
		System.out.println("Skipping the Test Forcefully");
		throw new SkipException("Skipping this Test");
		
	}
	
	@Test
	public void skipTest3() {
		System.out.println("Skipping the Test is Condition based");
		if(datasetup=true)
		{
			System.out.println("Execute the Test");
		}
		else {
			System.out.println("Do not execute the Test Cases");
		throw new SkipException("Skipping this Test");
		}
	}

}
