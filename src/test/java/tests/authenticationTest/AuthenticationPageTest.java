package tests.authenticationTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.actionpages.authentication.LoginPageBase;

import tests.TestBase;


public class AuthenticationPageTest extends TestBase {

	LoginPageBase loginBase;


	
	
	@Override
	@BeforeClass
	protected void initPageObject() {
		loginBase = new LoginPageBase(driverManager);
	}

	@Test(description = "Verify user is able to login using valid login credintials")
	public void verify_valid_login() 
	{

		
	
	
	}

}
