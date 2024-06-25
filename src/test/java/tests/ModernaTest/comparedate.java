package tests.ModernaTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

public class comparedate {

	@Test
	public void f() throws Exception {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("http://ram-gmp-t/ram/default.aspx");
		driver.manage().window().maximize();
		Thread.sleep(8000);

		File src1 = new File("D:\\Selenium Excel\\Assign Schedule Adherence Baseline Date 04-10Jun.xlsx");
		FileInputStream fis = new FileInputStream(src1);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);

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

		int rowcountt1 = sheet1.getLastRowNum() + 1;
		for (int i = 1; i < rowcountt1; i++) {
			String P1 = sheet1.getRow(i).getCell(0).getStringCellValue();
			WebElement search = driver.findElement(By.xpath("//input[@id='txtIdSearch']"));
			search.clear();
			Thread.sleep(2000);
			search.sendKeys(P1);
			Thread.sleep(10000);
			System.out.println(P1);

			Set<String> parenthandle = driver.getWindowHandles();
			Iterator<String> it = parenthandle.iterator();
			String pw = it.next();
			String c1 = it.next();
			driver.switchTo().window(c1);
			Thread.sleep(10000);

			driver.switchTo().frame("childmain");

			WebElement scheduling = driver.findElement(By.xpath("//*[@id='tabControl1_Tab1']"));
			scheduling.click();
			Thread.sleep(2000);
			
			WebElement dateElement1 = driver.findElement(By.id("fld6123016")); 																
			String websiteDate3 = dateElement1.getAttribute("value"); 
																	
			WebElement dateElement2 = driver.findElement(By.id("fld6123017")); 
			String websiteDate4 = dateElement2.getAttribute("value"); 
			
			DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
			
			Date websiteDateObj1 = dateFormat.parse(websiteDate3);
			Date websiteDateObj2 = dateFormat.parse(websiteDate4);


			if (websiteDateObj1.compareTo(websiteDateObj2) >= 0) {
				System.out.println("Website date 1 is greater than or equal to website date 2");
			} else {
				System.out.println("Website date 1 is smaller than website date 2");
			}

		}
	}

}
