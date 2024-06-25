package TESTNG_Automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Annotations {
	@Test(groups= "user")
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("Before class is started");
	}

	@AfterClass
	public void afterclass() {
		System.out.println("after class is ended");
	}
}
