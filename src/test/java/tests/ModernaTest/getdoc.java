package tests.ModernaTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getdoc {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64_18_04_2024\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--window-size=1920, 1080");
        options.addArguments("--disable-infobars");
        WebDriver driver = new ChromeDriver(options);
		String u = "https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm";
	      driver.get(u);
	      driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	      // identify element
	      WebElement m=driver.findElement(By.xpath("//input[@name='photo']"));
	      // file selection field with file path
	      m.sendKeys("C:\\Users\\dHolkarshinde\\Desktop\\BMRAM_AssetData_Template new.xlsx");
	      
	      
	      
	      
        
    }


}
