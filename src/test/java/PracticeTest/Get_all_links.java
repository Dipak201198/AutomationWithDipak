package PracticeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Get_all_links {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Deepak\\Downloads\\chromedriver-win64_29\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        
      //Launching sample website
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();
        
        //Get list of web-elements with tagName  - a
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        
        //Traversing through the list and printing its text along with link address
        for(WebElement link:allLinks)
        {
        	System.out.println(link.getText() + " - " + link.getAttribute("href"));
        }
        
        //Commenting driver.quit() for user to easily verify the links
        //driver.quit();

	}

}
