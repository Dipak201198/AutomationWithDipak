package TESTNG_Automation;

import org.testng.annotations.DataProvider;

public class DataProviderMoveFile {
	
	// Second way of DataProvider is Used
	@DataProvider(name="Login")
	public Object[][] dataset1()
	{
				return new Object[][]
				{
					{"standard_user","secret_sauce"},
					{"locked_out_user","secret_sauce"},
					{"problem_user","secret_sauce"},
					{"performance_glitch_user","secret_sauce"}
				};
	}

}
