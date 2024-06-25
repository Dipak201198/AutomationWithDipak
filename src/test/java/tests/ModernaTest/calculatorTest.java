package tests.ModernaTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class calculatorTest {
	
	@Test
	//Tests google calculator
	public void googleCalculator(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Deepak\\Downloads\\chromedriver-win64_29\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
       //Launch google
		driver.get("http://www.google.co.in");
		
		//Write 2+2 in google textbox
		WebElement googleTextBox = driver.findElement(By.id("gbqfq"));
		googleTextBox.sendKeys("2+2");
		
		//Click on searchButton
		WebElement searchButton = driver.findElement(By.id("gbqfb"));
		searchButton.click();
		
		//Get result from calculator
		WebElement calculatorTextBox = driver.findElement(By.id("cwos"));
		String result = calculatorTextBox.getText();
		
		//Verify that result of 2+2 is 4
		Assert.assertEquals(result, "4");
	}

}
