package PracticeTest;

import org.apache.poi.ss.formula.PlainCellCache.Loc;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvider {

	@Test(dataProvider="testdata")
	  public static void LoginTest(String username, String password) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Deepak\\Downloads\\chromedriver-win64_29\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

	    System.out.println("Clicked successfully");
	    driver.findElement(By.LinkText(Loc.getProperty("signin_link"))).click(); //locators-properties

	    driver.findElement(By.id(Loc.getProperty("email_field"))).sendKeys(username);
	    driver.findElement(By.xpath(Loc.getProperty("next_button"))).click();

	    Thread.sleep(4000);
	    driver.findElement(By.xpath(Loc.getProperty("pwd_field"))).sendKeys(password);

	    Thread.sleep(4000);
	    driver.findElement(By.xpath(Loc.getProperty("login_next_button"))).click();

	  }

	  @DataProvider(name="testdata")
	  public Object[][] tData() {
	    return new Object[][] {
	      {"rc@gmail.com", "testautn@1546456"},
	      {"rcvtutail.com", "testauto23"},
	      {"rcvtutomail.com", "testautoma67567@123"},
	      {"rcvtutorials@gmail.com","testautomation@123"}
	    };
	  }
}
