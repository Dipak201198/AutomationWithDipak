package PracticeTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Open_New_Tab {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Deepak\\Downloads\\chromedriver-win64_29\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        
      //implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
        
        // method Keys.chord
        String n = Keys.chord(Keys.CONTROL, Keys.ENTER);
        
        //open link in new tab
        driver.findElement(By.linkText("Team")).sendKeys(n);
        Thread.sleep(8000);
        
        // store window handle ids
        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
        
        //switch to open tab
        driver.switchTo().window(w.get(1));
        System.out.println("New tab title: " + driver.getTitle());
        
        //switch to first tab
        driver.switchTo().window(w.get(0));
        System.out.println("First tab title: " + driver.getTitle());
        driver.quit();

	}

}
