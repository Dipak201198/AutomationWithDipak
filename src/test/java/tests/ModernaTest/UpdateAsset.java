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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateAsset 
{
	@Test
	  public void f() throws Exception 
	  {
		  ChromeOptions chromeOptions = new ChromeOptions();
		  chromeOptions.addArguments("--remote-allow-origins=*");
		  
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(chromeOptions);
			driver.get("http://ram-gmp-t/ram/default.aspx");
			driver.manage().window().maximize();
			Thread.sleep(8000);
			
			File src1= new File("D:\\Selenium Excel\\CWR-Week21-2023-1805-141541.xlsx");
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
				Thread.sleep(20000);
				System.out.println(P1);
				
				Set<String> parenthandle= driver.getWindowHandles();
				Iterator<String> it=parenthandle.iterator();
				String pw=it.next();
		        String c1=it.next();
				driver.switchTo().window(c1);
		        Thread.sleep(5000);
		              
		        driver.switchTo().frame("childmain");
		      
		        driver.findElement(By.xpath("//a[@title='Edit']")).click();
		    	Thread.sleep(5000);
		    	
		    	driver.switchTo().frame(0);
		    	Thread.sleep(2000);
		    	
		    	/*
		        WebElement scheduling=driver.findElement(By.xpath("//li[@id='tabControl1_Tab1']")); 
		        scheduling.click();
		    	Thread.sleep(2000);
		    	*/
		       /*
				String manufacturer=sheet1.getRow(i).getCell(1).getStringCellValue();
				WebElement manu1=driver.findElement(By.xpath("//input[@id='fld4101012']"));
				manu1.click();
				manu1.clear();
				Thread.sleep(2000);
				manu1.sendKeys(manufacturer);
				Thread.sleep(8000);
				*/
				String department=sheet1.getRow(i).getCell(12).getStringCellValue();
				WebElement dept1=driver.findElement(By.xpath("//input[@id='fld4100008']"));
				dept1.click();
				dept1.clear();
				Thread.sleep(2000);
				dept1.sendKeys(department);
				Thread.sleep(8000);
				
		    	
				WebElement save=driver.findElement(By.xpath("//li[@id='menuBar2_Menu1']"));
				save.click();
				Thread.sleep(8000);
								
				WebElement reason=driver.findElement(By.xpath("//input[@id='fld4100088']"));
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
