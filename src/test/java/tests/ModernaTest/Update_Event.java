package tests.ModernaTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Update_Event 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver-win64_18_04_2024\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--window-size=1920, 1080");
        options.addArguments("--disable-infobars");
        WebDriver driver = new ChromeDriver(options);
			driver.get("http://ram-gmp-t/ram/default.aspx");
			driver.manage().window().maximize();
			Thread.sleep(8000);
			
			File src1= new File("C:\\Users\\Deepak\\Downloads\\Script AgilentGxP_Update_Interval.xlsx");
			FileInputStream fis = new FileInputStream(src1);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet1 =wb.getSheetAt(0);
			
			int rowcountt1=sheet1.getLastRowNum()+1;
			
			Select drpCountry = new Select(driver.findElement(By.id("lstAuthType")));
			drpCountry.selectByVisibleText("Moderna (MODERNA)");
			Thread.sleep(2000);
			WebElement userr = driver.findElement(By.id("txtUserName"));
			userr.sendKeys("agopale@modernatx.com");
			Thread.sleep(2000);
			WebElement passw = driver.findElement(By.id("txtPassword"));
			passw.sendKeys("mRNAmed@2025");
			Thread.sleep(2000);
			WebElement loginbtn = driver.findElement(By.id("lblButtonbtnLogin"));
			loginbtn.click();
			Thread.sleep(20000);
			
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
				
			    String eventid = sheet1.getRow(i).getCell(4).getStringCellValue();
			    WebElement link = driver.findElement(By.xpath("//div[text()='" + eventid + "']"));
			    action.contextClick(link).perform();
				
			    
			    // Click on Edit link on the displayed menu options
			    WebElement element = driver.findElement(By.xpath("//a[text()='Edit Schedule']"));
			    element.click();
			    Thread.sleep(5000);
			    
			    Set<String> parenthandle1= driver.getWindowHandles();
			    Iterator<String> it2=parenthandle1.iterator();
				String pw1=it2.next();
		        String c12=it2.next();
		        String c13=it2.next();
			    driver.switchTo().window(c13);
			    Thread.sleep(5000);
			    
			    driver.switchTo().frame(0);
				Thread.sleep(3000);
				
				/*
				String eduedate=sheet1.getRow(i).getCell(6).getStringCellValue();
				WebElement edd=driver.findElement(By.xpath("//input[@id='fld4506']")); 
				edd.click();
				edd.clear();
				Thread.sleep(1000);
				edd.sendKeys(eduedate);
				Thread.sleep(3000);
				*/
				
				Select frequency = new Select(driver.findElement(By.id("ucSchedParms_ddlScheduleType")));
				frequency.selectByVisibleText("Monthly - End of Month");
				Thread.sleep(3000);
				
				
				String interval=sheet1.getRow(i).getCell(2).getStringCellValue();
				WebElement ival=driver.findElement(By.xpath("//input[@id='ucSchedParms_fld900001']")); 
				ival.click();
				ival.clear();
				Thread.sleep(1000);
				ival.sendKeys(interval);
				Thread.sleep(3000);
				
			
				WebElement save = driver.findElement(By.xpath("//li[@id='menuBar2_Menu1']"));
				save.click();
				Thread.sleep(4000);

				WebElement reason = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input"));  
				reason.sendKeys("Modification to an existing record");
				Thread.sleep(3000);

				WebElement ok = driver.findElement(By.xpath("//span[@id='lblButtonbtnSubmitAudit']"));
				ok.click();
				Thread.sleep(5000);
				
				driver.close();
				
				driver.switchTo().window(c12);
				driver.close();
				
				driver.switchTo().window(pw);
				Thread.sleep(2000);
 
			}
		

	}

}
