package tests.ModernaTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DetachEvent 
{
	@Test
	  public void f() throws Exception 
	  {
		  ChromeOptions chromeOptions = new ChromeOptions();
		  chromeOptions.addArguments("--remote-allow-origins=*");
		  
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(chromeOptions);
			driver.get("http://ram-gmp/ram/default.aspx");
			driver.manage().window().maximize();
			Thread.sleep(8000);
			
			File src1= new File("D:\\Selenium Excel\\Dipak.xlsx");
			FileInputStream fis = new FileInputStream(src1);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet1 =wb.getSheetAt(0);
			
			int rowcountt1=sheet1.getLastRowNum()+1;
			
			Select drpCountry = new Select(driver.findElement(By.id("lstAuthType")));
			drpCountry.selectByVisibleText("Moderna (MODERNA)");
			Thread.sleep(2000);
			WebElement userr= driver.findElement(By.id("txtUserName"));
			userr.sendKeys("agopale@modernatx.com");
			Thread.sleep(2000);
			WebElement passw=driver.findElement(By.id("txtPassword"));
			passw.sendKeys("OneUpland@2023");
			Thread.sleep(2000);
			WebElement loginbtn=driver.findElement(By.id("lblButtonbtnLogin"));
			loginbtn.click();
			Thread.sleep(10000);
			
			for(int i = 1; i < rowcountt1; i++)
			{
				String P1=sheet1.getRow(i).getCell(0).getStringCellValue();
				WebElement search=driver.findElement(By.xpath("//input[@id='txtIdSearch']"));
				search.clear();
				Thread.sleep(2000);
				search.sendKeys(P1);
				Thread.sleep(7000);
				System.out.println(P1);
				
				Set<String> parenthandle= driver.getWindowHandles();
				Iterator<String> it=parenthandle.iterator();
				String pw=it.next();
		        String c1=it.next();
				driver.switchTo().window(c1);
		        Thread.sleep(8000);
		        
		        driver.switchTo().frame("childmain");
		        

		        driver.findElement(By.xpath("//a[text()='View']")).click();
		    	Thread.sleep(3000);
		    	
		    	driver.findElement(By.xpath("//a[text()='Schedules']")).click();
			    Thread.sleep(3000);
				
			    driver.switchTo().frame("DETAIL_VIEW");
				Thread.sleep(3000);
			    
			 // Right click the button to launch right click menu options
			    Actions action = new Actions(driver);

			    WebElement link = driver.findElement(By.xpath("//div[text()='VEV-000017']"));
			    action.contextClick(link).perform();
			    
			    // Click on Edit link on the displayed menu options
			    WebElement element = driver.findElement(By.xpath("//a[text()='Detach Event']"));
			    element.click();
			    Thread.sleep(5000);
			    
			    driver.switchTo().frame("DeleteConfirm");
				Thread.sleep(3000);
				
				String detachreason=sheet1.getRow(i).getCell(2).getStringCellValue();
				WebElement dreason=driver.findElement(By.xpath("//textarea[@id='fld1']")); 
				dreason.click();
				Thread.sleep(2000);
				dreason.sendKeys(detachreason);
				Thread.sleep(3000);
				
				WebElement confirmpassword = driver.findElement(By.id("fldfldCurrentPwd"));
				confirmpassword.sendKeys("OneUpland@2023");
				Thread.sleep(2000);
				
				WebElement checkbox = driver.findElement(By.id("cbDeleteAgree"));
				checkbox.click();
				Thread.sleep(2000);
				
				WebElement delete = driver.findElement(By.id("btnMidbtnDelete"));
				delete.click();
				Thread.sleep(4000);
				
				
				WebElement deleteok = driver.findElement(By.id("btnMidbtnAckMsg"));
				deleteok.click();
				Thread.sleep(2000);
				
				driver.close();
			    
			    driver.switchTo().window(pw);
			    Thread.sleep(2000);
				
			}
	  }
}