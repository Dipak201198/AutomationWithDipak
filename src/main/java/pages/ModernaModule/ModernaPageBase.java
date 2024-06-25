package pages.ModernaModule;

import utils.webdrivers.DriverManager;

public class ModernaPageBase {
	protected DriverManager driverManager;
	
	public ModernaPageBase(DriverManager driverManager) {		
		this.driverManager = driverManager;		
	}
	public ModernaModule modernaModule()
	{
		return new ModernaModule(driverManager);
	}
}
