package tests.ModernaTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ModernaPlannneddate 
{
	
	@Test
	  public void f() throws Exception 
	  {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
			driver.get("http://ram-gmp-t/ram/default.aspx");
			driver.manage().window().maximize();
			Thread.sleep(8000);
			
			File src1= new File("D:\\Selenium Excel\\Assign Schedule Adherence Baseline Date 04-10Jun.xlsx");
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
			
			for(int i=1;i<rowcountt1;i++)
			{
				String P1=sheet1.getRow(i).getCell(0).getStringCellValue();
				WebElement search=driver.findElement(By.xpath("//input[@id='txtIdSearch']"));
				search.clear();
				Thread.sleep(2000);
				search.sendKeys(P1);
				Thread.sleep(10000);
				System.out.println(P1);
				
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
		    		
		    	
		    	// This is close because script used for Asset Owner
				
				 
		    	WebElement scheduling=driver.findElement(By.xpath("//li[@id='tabControl1_Tab1']"));
				scheduling.click(); 
				Thread.sleep(2000);
				 
		    	
		     
				String plannedstartdate=sheet1.getRow(i).getCell(1).getStringCellValue();
				WebElement startdate1=driver.findElement(By.xpath("//input[@id='fld6123016']"));  
				startdate1.click();
				startdate1.clear();
				Thread.sleep(2000);
				startdate1.sendKeys(plannedstartdate);
				Thread.sleep(8000);
				
				
				String plannedenddate=sheet1.getRow(i).getCell(2).getStringCellValue();
				WebElement enddate1=driver.findElement(By.xpath("//input[@id='fld6123017']"));
				enddate1.click();
				enddate1.clear();
				Thread.sleep(2000);
				enddate1.sendKeys(plannedenddate); 
				Thread.sleep(8000);
				
				
				WebElement save=driver.findElement(By.xpath("//li[@id='menuBar2_Menu1']"));
				save.click();
				Thread.sleep(8000);
								
				WebElement reason=driver.findElement(By.xpath("//input[@id='fld6123600']"));      
				reason.sendKeys("Modification to an existing record");	       
				Thread.sleep(4000);
				
			    WebElement ok=driver.findElement(By.xpath("//span[@id='lblButtonbtnSubmitAudit']"));
			    ok.click();
			    Thread.sleep(7000);
			    
			    driver.close();
		        driver.switchTo().window(pw);
				Thread.sleep(2000); 
				
		      }
			
	  }
	

}