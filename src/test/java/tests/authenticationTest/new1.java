package tests.authenticationTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class new1 {
	


public static void main(String[] args) throws InterruptedException, IOException
{
//System.setProperty("webdriver.chrome.driver", "C:\\Users\\RKakade\\Desktop\\vaibhav angular\\selenium\\chrome\\chromedriver_win32 (1)//chromedriver.exe");
WebDriverManager.chromedriver().setup();
// ChromeOptions options = new ChromeOptions();
WebDriver driver= new ChromeDriver();

driver.get("http://ram-gmp-t/ram/default.aspx");

// Maximize window size of browser
driver.manage().window().maximize();
Thread.sleep(2000);

driver.findElement(By.xpath("//select[@onchange='UpdateLoginForm();']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//option[text()='Moderna (MODERNA)']")).click();
Thread.sleep(3000);
// Enter your login email id
driver.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("agopale@modernatx.com");
Thread.sleep(3000);
// Enter your login password
driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("ModNorBos@789");
Thread.sleep(3000);
driver.findElement(By.xpath("//span[@id='btnMidbtnLogin']")).click();
Thread.sleep(5000);
/*
Thread.sleep(10000);
driver.findElement(By.xpath("//a[text()='Go To']")).click();
Thread.sleep(3000);

driver.findElement(By.xpath("//a[@data-menuvalue='OPT_QUERY']")).click();
Thread.sleep(3000);

WebElement Work = driver.findElement(By.xpath("(//a[text()='Work'])[2]"));
Thread.sleep(3000);
Actions act = new Actions(driver);
Thread.sleep(3000);
act.doubleClick(Work).build().perform();
Thread.sleep(3000);

driver.findElement(By.xpath("//div[@id='panelView1_ToggleBar']")).click();
Thread.sleep(3000);

WebElement AllWork= driver.findElement(By.xpath("(//a[text()='All Work'])[1]"));
Thread.sleep(3000);
act.doubleClick(AllWork).build().perform();
Thread.sleep(3000);

WebElement AllWork2= driver.findElement(By.xpath("(//a[text()='All Work'])[2]"));
Thread.sleep(1000);
act.doubleClick(AllWork2).build().perform();
Thread.sleep(8000);
*/
WebElement searchWorkOrder= driver.findElement(By.xpath("//input[@id='txtIdSearch']"));


File file =new File("D:\\Tested File-PlannedStartEnd.xlsx");
FileInputStream fis= new FileInputStream(file);
XSSFWorkbook workbook= new XSSFWorkbook(fis);
XSSFSheet sheet= workbook.getSheetAt(0);

String cellValue= sheet.getRow(1).getCell(0).getStringCellValue();
System.out.println(cellValue);
searchWorkOrder.sendKeys(cellValue);
Thread.sleep(10000);

//String parent=driver.getWindowHandle();
//
//Set<String>s=driver.getWindowHandles();
//Iterator<String> I1= s.iterator();
//String child_window=I1.next();
//driver.switchTo().window(child_window);
//driver.manage().window().maximize();


/*
String parent=driver.getWindowHandle();

Set<String>s=driver.getWindowHandles();

// Now iterate using Iterator
Iterator<String> I1= s.iterator();

while(I1.hasNext())
{

String child_window=I1.next();


if(!parent.equals(child_window))

driver.switchTo().window(child_window);

System.out.println(driver.switchTo().window(child_window).getTitle());

//driver.manage().window().maximize();

}
*/

// navigates to the page consisting an iframe

driver.manage().window().maximize();
driver.switchTo().frame("childmain"); //switching the frame by ID

System.out.println("********We are switch to the iframe*******");
driver.findElement(By.xpath("/html/body")).click(); //Clicks the iframe

Thread.sleep(3000);

driver.findElement(By.xpath("//a[@title='Edit']")).click();
Thread.sleep(5000);

Thread.sleep(3000);
driver.findElement(By.xpath("//a[text()='Scheduling']")).click();
driver.findElement(By.xpath("(//span[text()='Planned Start Date']//ancestor::td//following::input)[1]")).sendKeys("");
driver.findElement(By.xpath("(//span[text()='Planned End Date']//ancestor::td//following::input)[1]")).sendKeys("");



}

}