package tests.ModernaTest;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyPlanneddate {
	 public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";

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

			/*********** Assigned Person *************/

			String assignedperson = sheet1.getRow(i).getCell(3).getStringCellValue();
			WebElement aperson = driver.findElement(By.xpath("//input[@id='fld6123019']"));

			if (aperson != null) {
				String websitedata = aperson.getAttribute("value");
				if (assignedperson.equals(websitedata)) {
					System.out.println("Test Pass(Assigned Person): " + websitedata);
//					System.out.println();

				} else {
					System.out.println(ANSI_RED + "Test Fail(Assigned Person): " + assignedperson + ANSI_RESET);
//					System.out.println();

				}
				

				/************* Planned Start Date & End Date *************/

				String explannedstartdate = sheet1.getRow(i).getCell(1).getStringCellValue();
				String explannedenddate = sheet1.getRow(i).getCell(2).getStringCellValue();
				WebElement webplannedstartdate = driver.findElement(By.id("fld6123016"));
				WebElement webplannedenddate = driver.findElement(By.id("fld6123017"));
				
				if (webplannedstartdate != null || webplannedenddate != null) {
					String websitedata1 = webplannedstartdate.getAttribute("value");
					String websitedata2 = webplannedenddate.getAttribute("value");
					if (explannedstartdate.equals(websitedata1) || explannedenddate.equals(websitedata2)) {
						System.out.println("Test Pass(Planned Start Date): " + websitedata1);
						System.out.println("Test Pass(Planned End Date): " + websitedata2);
						System.out.println();

					} else {
						System.out.println(ANSI_RED + "Test Fail(Planned Start Date): " + explannedstartdate + ANSI_RESET);
						System.out.println(ANSI_RED + "Test Fail(Planned End Date): " + explannedenddate + ANSI_RESET);
						System.out.println();
						
					}
					driver.close();
					driver.switchTo().window(pw);
					Thread.sleep(2000);
				}
			}
		}
	}

}
