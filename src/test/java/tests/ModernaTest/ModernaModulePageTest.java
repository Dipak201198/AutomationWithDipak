package tests.ModernaTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ModernaModule.ModernaPageBase;
import pages.actionpages.authentication.LoginPageBase;
import testdata.AuthTestData;
import testdata.ModernaTestData;
import tests.TestBase;

public class ModernaModulePageTest extends TestBase {
	
	LoginPageBase loginBase;
	ModernaPageBase modernaPageBase;
	
	ModernaTestData modernaTestData = new ModernaTestData();
	AuthTestData authTestData = new AuthTestData();

	@Override
	@BeforeClass
	protected void initPageObject() 
	{
		loginBase = new LoginPageBase(driverManager);
		modernaPageBase = new ModernaPageBase(driverManager);
	}
	
	@Test(description="BMRAM Dev",priority=1)
	public void LaunchBMRAM() 
	{
		
		
	}
		
	
	
}
