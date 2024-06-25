package TESTNG_Automation;

import org.testng.annotations.Test;

public class GroupsDemoTest {

	@Test(priority = 0, groups = "Regression")
	public void aTest1() {
		System.out.println("Test1");
	}

	@Test(priority = 1, groups = "Regression")
	public void bTest2() {
		System.out.println("Test2");

	}

	@Test(groups = { "Regression", "bvt" })
	public void bTest3() {
		System.out.println("Test3");

	}

	@Test(groups = "bvt")
	public void bTest4() {
		System.out.println("Test4");

	}

}
