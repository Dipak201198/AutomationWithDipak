package TESTNG_Automation;

import org.testng.annotations.Test;

import common.CommonDataSetup;

public class GroupsDemoTestsuite extends CommonDataSetup{

	@Test(groups = { "Regression", "bvt" })
	public void bTest3() {
		System.out.println("Test3");

	}

	@Test(groups = "bvt")
	public void bTest4() {
		System.out.println("Test4");

	}

}
