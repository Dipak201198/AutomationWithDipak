package tests.ModernaTest;

import java.io.File;
import java.io.FileInputStream;

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

public class FailureHierarchy 
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

		Select drpCountry = new Select(driver.findElement(By.id("lstAuthType")));
		drpCountry.selectByVisibleText("Moderna (MODERNA)");
		Thread.sleep(2000);
		WebElement userr = driver.findElement(By.id("txtUserName"));
		userr.sendKeys("vbabu@modernatx.com");
		Thread.sleep(2000);
		WebElement passw = driver.findElement(By.id("txtPassword"));
		passw.sendKeys("mRNAmed@2023");
		Thread.sleep(2000);
		WebElement loginbtn = driver.findElement(By.id("lblButtonbtnLogin"));
		loginbtn.click();
		Thread.sleep(20000);
		
		
		File src1 = new File("D:\\Selenium Excel\\FailureHierarchy.xlsx");
		FileInputStream fis = new FileInputStream(src1);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		
		
		WebElement P1 = driver.findElement(By.xpath("//*[text()='Go To']"));
		P1.click();
		Thread.sleep(2000);
		
		WebElement sysconfig = driver.findElement(By.xpath("//a[text()='System Configuration']"));
		sysconfig.click();
		Thread.sleep(4000);
		
		Actions act=new Actions(driver);
		
		WebElement security=driver.findElement(By.xpath("//a[text()='Security']"));
		act.moveToElement(security);
    	act.doubleClick(security).build().perform();  
		Thread.sleep(2000);
		
		WebElement sites=driver.findElement(By.xpath("//a[text()='Sites']"));
		act.moveToElement(sites);
    	act.doubleClick(sites).build().perform();  
		Thread.sleep(5000);
		
		WebElement moderna=driver.findElement(By.xpath("//a[text()='MODERNA']"));
		act.moveToElement(moderna);
    	act.doubleClick(moderna).build().perform();  
		Thread.sleep(5000);
		
		WebElement datatrees=driver.findElement(By.xpath("//a[text()='Data Trees']"));
		act.moveToElement(datatrees);
    	act.doubleClick(datatrees).build().perform();  
		Thread.sleep(5000);
		
		driver.switchTo().frame("panelView2_Panel8_Body");
		Thread.sleep(5000);
		
		WebElement treename=driver.findElement(By.xpath("(//div[text()='Work Failure Tree (P/C/R)'])[1]"));
    	treename.click();
		Thread.sleep(5000);
		
		WebElement failuretree=driver.findElement(By.xpath("/html/body/form/div[5]/div[2]/ul/li/a"));
		failuretree.click();
		Thread.sleep(5000);
		
		WebElement newproblem=driver.findElement(By.xpath("/html/body/form/div[5]/div[1]/ul/li[2]/a"));
		newproblem.click();
		Thread.sleep(5000);
		
		driver.switchTo().frame("TN_EDIT_DIALOG");
		Thread.sleep(5000);
		
		String P2 = sheet1.getRow(1).getCell(0).getStringCellValue();
		WebElement problemex = driver.findElement(By.xpath("//input[@name='fld99999']"));
		problemex.sendKeys(P2);
		Thread.sleep(2000);
		
		String P3 = sheet1.getRow(1).getCell(1).getStringCellValue();
		WebElement problemdesc = driver.findElement(By.xpath("/html/body/form/div[3]/div/table/tbody/tr[3]/td[2]/div/table/tbody/tr/td[1]/textarea"));
		problemdesc.sendKeys(P3);
		Thread.sleep(2000);

/*
		Select insertAfter = new Select(driver.findElement(By.id("ddlInsertBelow")));
		insertAfter.selectByVisibleText("Software");
		Thread.sleep(2000);
*/
		
		
		
	}

}
