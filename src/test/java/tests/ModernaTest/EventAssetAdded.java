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

public class EventAssetAdded {
	
	@Test
	public void f() throws Exception {
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
		Thread.sleep(10000);
		
		
		File src1 = new File("C:\\Selenium Excel\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(src1);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);

		int rowcountt1 = sheet1.getLastRowNum() + 1;

		for (int i = 1; i < rowcountt1; i++) {
			
			String P1 = sheet1.getRow(i).getCell(0).getStringCellValue();
			WebElement search = driver.findElement(By.xpath("//input[@id='txtIdSearch']"));
			search.clear();
			Thread.sleep(2000);
			search.sendKeys(P1);
			Thread.sleep(8000);
			System.out.println(P1);
			
			WebElement WO = driver.findElement(By.xpath("/html/body/form/div[5]/div[1]/div[2]/span/div/table/tbody/tr[1]/td[2]"));
			Thread.sleep(1000);
			WO.click();
			Thread.sleep(2000);
			
			
			Set<String> parenthandle = driver.getWindowHandles();
			Iterator<String> it = parenthandle.iterator();
			String pw = it.next();
			String c1 = it.next();
			driver.switchTo().window(c1);
			Thread.sleep(5000);
			
			driver.switchTo().frame("childmain");
			
			driver.findElement(By.xpath("//*[@id=\"menuBar1_Menu2\"]/a")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id=\"menuBar1_Menu2_Options\"]/a[1]")).click();
			Thread.sleep(5000);
			
			driver.switchTo().frame("DETAIL_VIEW");
			
			driver.findElement(By.xpath("//*[@id=\"assetList_MB1_Menu1\"]/a/img")).click();
			Thread.sleep(5000);
			
			//Switch to Frame
			Set<String> parenthandle1= driver.getWindowHandles();
			Iterator<String> it1=parenthandle1.iterator();
			String pw1=it1.next();
	        String c2=it1.next();
	        String c3=it1.next();
			driver.switchTo().window(c3);
			Thread.sleep(6000);
			
			driver.switchTo().frame(0);
	    	Thread.sleep(2000);
			
	    	WebElement choosequery=driver.findElement(By.xpath("//li[@id='itemList_MB1_Menu4']"));
	    	choosequery.click(); 
			Thread.sleep(10000);
			

			WebElement allasset=driver.findElement(By.xpath("//a[@href=\"javascript: CoolGridUtils.RunSelect('itemList', '1D5536E5-39A4-49EA-8B2D-A5B246F83BAD', 'All Assets');\"]"));
			allasset.click(); 
			Thread.sleep(20000);
					
			WebElement filter=driver.findElement(By.xpath("//a[@title='Quick Find']"));
			filter.click(); 
			Thread.sleep(10000);
			
			
			String P2 = sheet1.getRow(i).getCell(1).getStringCellValue();
			WebElement filterasset = driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr/td[3]/input[1]")); 
			Thread.sleep(2000);
			filterasset.sendKeys(P2);
			Thread.sleep(2000);
		
		    WebElement searchasset=driver.findElement(By.xpath("//*[@id='itemList:cg_qf_searchLink']"));
		    searchasset.click();
		    Thread.sleep(6000);
		    
		    WebElement aa=driver.findElement(By.xpath("//*[@id='itemList:cg_tbl_body']"));
		    Thread.sleep(5000);
			Actions act = new Actions(driver);
			Thread.sleep(5000);
			act.doubleClick(aa).build().perform();
			Thread.sleep(5000);
			
			WebElement done=driver.findElement(By.xpath("//span[@id='lblButtonbtnOK']"));
		    done.click(); 
			Thread.sleep(3000);
			
		    WebElement ok=driver.findElement(By.xpath("//*[@id='btnMidbtnOK']"));
	        ok.click(); 
		    Thread.sleep(3000);
		    
		    
		    
		    
		}
	}


}
