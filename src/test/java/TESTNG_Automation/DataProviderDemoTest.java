package TESTNG_Automation;

import org.testng.annotations.DataProvider;

public class DataProviderDemoTest {
	
	@org.testng.annotations.Test(dataProvider = "dataset")
	public void Test(String username, String password) 
	{
		System.out.println(username+"===="+password);
	}
	
	// Second way of DataProvider is Used
	@DataProvider
	public Object[][] dataset1()
	{
				return new Object[][]
				{
					{"username","password"},
					{"username1","password1"}
				};
	}
	
	// One way of DataProvider is Used
	@DataProvider
	public Object[][] dataset()
	{
		Object [][] dataset = new Object [4][2];
		
		//first row
		dataset[0][0]="user1";
		dataset[0][1]="pass1";
		
		//second row
		dataset[1][0]="user2";
		dataset[1][1]="pass2";
		
		//Third row
		dataset[2][0]="user3";
		dataset[2][1]="pass3";
		
		//fourth row
		dataset[3][0]="user4";
		dataset[3][3]="pass4";
		
		return dataset;
		
		
		
		
	}

}
