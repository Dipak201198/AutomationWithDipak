package TESTNG_Automation;

import org.testng.annotations.Test;

public class LoginTest {
	
	
	@Test(priority = 0, description = "Site is Login")
	public void bloginTest() 
	{
		System.out.println("Login is Successful");
	}
	
	@Test(priority = 1 ,description = "Site is Logout")
	public void alogoutTest() {
		System.out.println("LogOut is Successful");
		
	}

}
