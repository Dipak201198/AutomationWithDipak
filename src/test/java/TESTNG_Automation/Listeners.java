package TESTNG_Automation;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	
	 public void onTestStart(ITestResult result) {
		 System.out.println("Test Case is Starting");
	
	}
	
	 public void onTestSuccess(ITestResult result) {
		 System.out.println("Test Case is Starting");
	
	}
	
	 public void onTestFailure(ITestResult result) {
		 System.out.println("Test Case is Starting");
		
	}
	
	 public void onTestSkipped(ITestResult result) {
		 System.out.println("Test Case is Starting");
		
	}
}
