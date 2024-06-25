package TESTNG_Automation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Retry {
	
	@Test(retryAnalyzer = FailedTestCases_Retry.class)
	  public void test2() {
	    Assert.fail();
	  }

}
