package PracticeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class cookieRead {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Deepak\\Downloads\\chromedriver-win64_29\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        // adding implicit wait of 15 seconds
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);     

     // Add two cookies in key-value pairs
        driver.manage().addCookie(new Cookie("C1", "VAL1"));
        driver.manage().addCookie(new Cookie("C2", "VAL2"));

        // get every cookie details
        Set<Cookie> c = driver.manage().getCookies();
        System.out.println("Cookie details are: " + c);
        
     // delete a cookie with its name
        driver.manage().deleteCookieNamed("C2");

     // get every cookie details after deleting cookie C2
        Set<Cookie> c2 = driver.manage().getCookies();
        System.out.println("Cookie details after deleting C2 cookie are: " + c2);
        
        // Closing browser
        driver.quit();
     }

}
