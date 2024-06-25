package tests.ModernaTest;

import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Code_Snippet {

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Deepak\\Downloads\\chromedriver-win64_29\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        
        driver.get("https://www.testandquiz.com/selenium/testing.html");
        
        // Implicit Waits
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Explicit Waits
        WebDriverWait wait = new WebDriverWait(driver, 15);
       // wait.until(ExpectedConditions.presenceOfElementLocated(ElementLocator));
        
        //Handling drop-downs
        Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));  
        dropdown.selectByVisibleText("Database Testing");  
        dropdown.selectByValue("");
        
        // Right Click
        Actions action = new Actions(driver);
		WebElement searchBox = driver.findElement(By.id("fname"));
		action.contextClick(searchBox).perform();

		//Double click the button 
		WebElement btn = driver.findElement(By.id("dblClkBtn"));
		action.doubleClick(btn).perform();
		
		//Mouseover on submit button
		WebElement btn1 = driver.findElement(By.id("idOfButton"));
		action.moveToElement(btn).perform();
		
		//Performing the drag and drop action  
		WebElement from = driver.findElement(By.id("sourceImage"));  
		WebElement to = driver.findElement(By.id("targetDiv"));  
		action.dragAndDrop(from,to).build().perform();  
		
		//Enter/Return Key
		WebElement textbox = driver.findElement(By.id("idOfElement"));
		textbox.sendKeys(Keys.ENTER);
		
		WebElement textbox1 = driver.findElement(By.id("idOfElement"));
		textbox.sendKeys(Keys.RETURN);
		
		//Scroll down the webpage by 2500 pixels
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0, 2500)"); 
		
		// Refresh a Webpage
		driver.navigate().refresh();
		
		// Maximize or Minimize
		driver.manage().window().maximize();
		driver.manage().window().setPosition(new Point(0, -1000));
		
		// Resize Browser Window
		int width = 600;
		int height = 400;
		Dimension dimension = new Dimension(width, height);
	//	driver.manage().window().setSize(dimension);
		
		


        
        

	}

}
