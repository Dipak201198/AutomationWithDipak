package PracticeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SampleTest {
	
	@Test
	public void sampleTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Deepak\\Downloads\\chromedriver-win64_29\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
		String u = "https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm";
	      driver.get(u);
	      driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	      // identify element
	      WebElement m=driver.findElement(By.xpath("//input[@name='photo']"));
	      // file selection field with file path
	      m.sendKeys("C:\\Users\\dHolkarshinde\\Desktop\\BMRAM_AssetData_Template new.xlsx");
	   
	}

}
