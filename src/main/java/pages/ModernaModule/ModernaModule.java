package pages.ModernaModule;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.PageActionsBase;
import pages.uipages.ModernaModule.ModernaModulePageUI;
import utils.readers.Config;
import utils.webdrivers.DriverManager;

public class ModernaModule extends PageActionsBase {

	
	public ModernaModule(DriverManager driverManager) 
	{
		super(driverManager, new ModernaModulePageUI());
		browserActions.load(Config.getAccessBaseURL());
	}
	
	
	
	
}
