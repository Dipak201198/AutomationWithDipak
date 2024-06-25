package PracticeTest;

import org.testng.annotations.Test;

public class Dependency_TESTNG {
	
	// dependsOnMethods
	
    @Test
    public void parentTest() { 
      System.out.println("Running parent test.");
    }
   
    @Test(dependsOnMethods={"parentTest"}) 
    public void dependentTest() { 
      System.out.println("Running dependent test.");
    } 


}

/*
 OUTPUT
 
Running parent test.
Running dependent test.
PASSED: parentTest
PASSED: dependentTest
 
 
 */
