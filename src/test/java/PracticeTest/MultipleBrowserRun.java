package PracticeTest;

public class MultipleBrowserRun {
	
	/*
	 
	----- The beforeTest method with @Parameter of TestNG will look like-----
	 
	 @Parameters("browser")
@BeforeTest
public void setBrowser(String browser)
{
   if (browser.equalsIgnoreCase("Firefox")) {
      driver = new FirefoxDriver();
      
   }
   else if (browser.equalsIgnoreCase("Chrome")) {
      System.setProperty("webdriver.chrome.driver", 
         + pathToChromeDriverBinary + "chromedriver.exe");
      driver = new ChromeDriver();
   }
   else {
      throw new IllegalArgumentException("Invalid browser value!!");
   }
   driver.get(URL);
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   driver.manage().window().maximize();
}
	
	---- parallel=”tests” in the Suite tag makes the two tests run in parallel.----
	
	 <suite name="MultiBrowserSuite" parallel="tests" thread-count="2">
   <test name="TestFirefox">
      <parameter name="browser" value="Firefox"/>
      <classes>
         <class name="sampleTestPackage.MultiBrowserTest"/>
      </classes>
   </test>
   <test name="TestChrome">
      <parameter name="browser" value="Chrome"/>
      <classes>
         <class name="sampleTestPackage.MultiBrowserTest"/>
      </classes>
   </test>
</suite>


	 */

}
