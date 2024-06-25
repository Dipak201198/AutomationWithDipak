package TESTNG_Automation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTitle {
	
	@Test
	public void titleTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Deepak\\Downloads\\chromedriver-win64_29\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        
        String expectedTitle="Electronics, Cars, Fashion, Collectibles & More | eBay";
        String actualTile=driver.getTitle();
        
        Assert.assertEquals(actualTile, expectedTitle);
		driver.close();
	}

}
