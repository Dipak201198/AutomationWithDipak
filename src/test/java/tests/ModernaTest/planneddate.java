package tests.ModernaTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class planneddate 
{
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
	
	WebElement searchWorkOrder= driver.findElement(By.xpath("//input[@id='txtIdSearch']"));


	File file =new File("D:\\Tested File-PlannedStartEnd.xlsx");
	FileInputStream fis= new FileInputStream(file);
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	XSSFSheet sheet= workbook.getSheetAt(0);

	String cellValue= sheet.getRow(1).getCell(0).getStringCellValue();
	System.out.println(cellValue);
	searchWorkOrder.sendKeys(cellValue);
	Thread.sleep(10000);
	

	//Switch to Frame using id of the frame
	Set<String> parenthandle= driver.getWindowHandles();
	Iterator<String> it=parenthandle.iterator();
	String pw=it.next();
    String c1=it.next();
	driver.switchTo().window(c1);
    Thread.sleep(10000);
          
    driver.switchTo().frame("childmain");
	
	driver.findElement(By.xpath("//a[@title='Edit']")).click();
	Thread.sleep(5000);
	
	driver.switchTo().frame(0);
	Thread.sleep(2000);
			    		
    WebElement scheduling=driver.findElement(By.xpath("//li[@id='tabControl1_Tab1']"));
    scheduling.click();
	Thread.sleep(2000);
	
	String plannedstartdate=sheet.getRow(1).getCell(1).getStringCellValue();
    WebElement plannedstartdateMenu= driver.findElement(By.xpath("//input[@id='fld6122016']"));
    plannedstartdateMenu.click();
    plannedstartdateMenu.clear();
    Thread.sleep(2000);
    plannedstartdateMenu.sendKeys(plannedstartdate);
    Thread.sleep(5000);
    
	/*
    String plannedenddate=sheet.getRow(1).getCell(2).getStringCellValue();
    WebElement plannedenddateMenu= driver.findElement(By.xpath("//input[@id='fld6122017']"));
    plannedenddateMenu.click();
    plannedenddateMenu.clear();
    Thread.sleep(2000);
    plannedenddateMenu.sendKeys(plannedenddate);
    Thread.sleep(5000);
	*/
	driver.close();
	}

}
