package PracticeTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class Return_Failed_Tests {
	
	//Counter to keep track of retry attempts
	 int retryAttemptsCounter = 0;
	 
	 //The max limit to retry running of failed test cases
	 //Set the value to the number of times we want to retry
	 int maxRetryLimit = 1;
	 //Method to attempt retries for failure tests
	 public boolean retry(ITestResult result) {
	 if (!result.isSuccess()) {
	 if(retryAttemptsCounter < maxRetryLimit){
	 retryAttemptsCounter++;
	 return true;
	 }
	 }
	 return false;
	 } 

}



/*
 @Test(retryAnalyzer = RetryAnalyzer.class)
    public void intentionallyFailingTest(){
     System.out.println("Executing Test");
     Assert.fail("Failing Test");
    }
    
 */
