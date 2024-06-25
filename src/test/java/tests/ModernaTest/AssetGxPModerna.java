package tests.ModernaTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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

public class AssetGxPModerna {
	@Test
	public void f() throws Exception {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("http://ram-gmp/ram/default.aspx");
		driver.manage().window().maximize();
		Thread.sleep(4000);

		Select drpCountry = new Select(driver.findElement(By.id("lstAuthType")));
		drpCountry.selectByVisibleText("Moderna (MODERNA)");
		Thread.sleep(2000);
		WebElement userr = driver.findElement(By.id("txtUserName"));
		userr.sendKeys("agopale@modernatx.com");
		Thread.sleep(2000);
		WebElement passw = driver.findElement(By.id("txtPassword"));
		passw.sendKeys("OneUpland@2023");
		Thread.sleep(2000);
		WebElement loginbtn = driver.findElement(By.id("lblButtonbtnLogin"));
		loginbtn.click();
		Thread.sleep(10000);

		File src1 = new File("D:\\Selenium Excel\\BMRAM_Data INT Loader Round 2(07-07-2023).xlsx");
		FileInputStream fis = new FileInputStream(src1);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);

		int rowcountt = sheet1.getLastRowNum() + 1;

		Thread.sleep(2000);
		Actions act = new Actions(driver);

		for (int i = 1; i < rowcountt; i++) {

			WebElement neww = driver.findElement(By.xpath("//*[text()='New'][1]"));
			neww.click();
			Thread.sleep(2000);

			WebElement asset = driver.findElement(By.xpath("//*[text()='Asset']"));
			asset.click();
			Thread.sleep(2000);

			driver.switchTo().frame("SysWizardWindow");

			WebElement system = driver.findElement(By.xpath("//input[@id='optSystemType']"));
			system.click();
			Thread.sleep(2000);

			WebElement next = driver.findElement(By.xpath("//*[@id='lblButtonbtnNext']"));
			next.click();
			Thread.sleep(4000);

			WebElement next1 = driver.findElement(By.xpath("//*[@id='lblButtonbtnNext']"));
			next1.click();
			Thread.sleep(4000);

			next1.click();
			Thread.sleep(4000);

			WebElement editasset = driver.findElement(By.xpath("//*[@id='lblRecEdit']"));
			editasset.click();
			Thread.sleep(4000);

			next1.click();
			Thread.sleep(4000);

			Set<String> parenthandle = driver.getWindowHandles();
			Iterator<String> it = parenthandle.iterator();
			String pw = it.next();
			String c1 = it.next();
			driver.switchTo().window(c1);
			Thread.sleep(8000);

			driver.switchTo().frame("childmain");
			Thread.sleep(5000);

			Row row = sheet1.getRow(i);
			Cell cell = row.createCell(21);

			String assetid = driver.findElement(By.xpath("//*[@id='fld4101006']")).getAttribute("value");
			cell.setCellValue(assetid);
			System.out.println(cell);
			Thread.sleep(2000);

//			FileOutputStream fos = new FileOutputStream(src1);
//
//			wb.write(fos);
//
//			fos.close();

//			Thread.sleep(2000);

			String P2 = sheet1.getRow(i).getCell(7).getStringCellValue();
			WebElement equtag = driver.findElement(By.xpath("//input[@id='fld4101026']")); // Equipment/Instrument Tag
			equtag.sendKeys(P2);
			Thread.sleep(2000);

			String P3 = sheet1.getRow(i).getCell(1).getStringCellValue();
			WebElement site = driver.findElement(By.xpath("//input[@id='fld4101023']")); // Site
			site.click();
			site.sendKeys(P3);
			Thread.sleep(4000);

			String P5 = sheet1.getRow(i).getCell(8).getStringCellValue();
			WebElement desc = driver.findElement(By.xpath("//*[@id='fld4101010']")); // Asset Description
			desc.sendKeys(P5);
			Thread.sleep(2000);

			String P6 = sheet1.getRow(i).getCell(2).getStringCellValue();
			WebElement ramresponsibility = driver.findElement(By.xpath("//input[@id='fld4101028']")); // RAM //
																										// Responsibility
			ramresponsibility.click();
			ramresponsibility.sendKeys(P6);
			Thread.sleep(4000);

			String P10 = sheet1.getRow(i).getCell(9).getStringCellValue();
			WebElement assettype = driver.findElement(By.xpath("//input[@id='fld4101030']")); // Asset Type
			assettype.click();
			assettype.sendKeys(P10);
			Thread.sleep(4000);

			String P9 = sheet1.getRow(i).getCell(3).getStringCellValue();
			WebElement department = driver.findElement(By.xpath("//input[@id='fld4101008']")); // Department
			department.click();
			department.sendKeys(P9);
			Thread.sleep(4000);
/*
			String P99 = sheet1.getRow(i).getCell(6).getStringCellValue();
			WebElement parentsysname = driver.findElement(By.xpath("//input[@id='fld4101024']")); // Parent System Name
			parentsysname.click();
			parentsysname.sendKeys(P99);
			Thread.sleep(4000);
*/
			String P122 = sheet1.getRow(i).getCell(18).getStringCellValue();
			WebElement impact = driver.findElement(By.xpath("//input[@id='fld4101209']")); // Impact
			impact.click();
			impact.sendKeys(P122);
			Thread.sleep(4000);

			String P8 = sheet1.getRow(i).getCell(4).getStringCellValue();
			WebElement assetowner = driver.findElement(By.xpath("//input[@id='fld4101009']")); // Asset Owner
			assetowner.click();
			assetowner.sendKeys(P8);
			Thread.sleep(4000);

			String P126 = sheet1.getRow(i).getCell(0).getStringCellValue();
			WebElement comments = driver.findElement(By.xpath("//*[@id='fld4101043']")); // Comments
			comments.sendKeys(P126);
			Thread.sleep(2000);

			String P11 = sheet1.getRow(i).getCell(17).getStringCellValue();
			WebElement classification = driver.findElement(By.xpath("//input[@id='fld4101018']")); // Classification
			classification.click();
			classification.sendKeys(P11);
			Thread.sleep(4000);
			
			String P134 = sheet1.getRow(i).getCell(14).getStringCellValue();
			WebElement model = driver.findElement(By.xpath("//input[@id='fld4101014']")); // Model
			model.click();
			model.sendKeys(P134);
			Thread.sleep(4000);

			String P133 = sheet1.getRow(i).getCell(13).getStringCellValue();
			WebElement manufacturer = driver.findElement(By.xpath("//input[@id='fld4101012']")); // Manufacturer
			manufacturer.click();
			manufacturer.sendKeys(P133);
			Thread.sleep(4000);

			

			WebElement location = driver.findElement(By.xpath("//*[@id='btn4101011']")); // Location
			location.click();
			Thread.sleep(4000);

			driver.switchTo().frame("cfLocation");

			String P123 = sheet1.getRow(i).getCell(10).getStringCellValue();
			WebElement sitelocation = driver.findElement(By.linkText(P123));
			act.moveToElement(sitelocation);
			act.doubleClick(sitelocation).build().perform();
			Thread.sleep(3000);

			String P124 = sheet1.getRow(i).getCell(11).getStringCellValue();
			WebElement sitelocation1 = driver.findElement(By.linkText(P124));
			act.moveToElement(sitelocation1);
			sitelocation1.click();
			act.doubleClick(sitelocation1).build().perform();
			Thread.sleep(3000);
/*
			String P125 = sheet1.getRow(i).getCell(12).getStringCellValue();
			WebElement sitelocation2 = driver.findElement(By.linkText(P125));
			act.moveToElement(sitelocation2);
			sitelocation2.click();
			act.doubleClick(sitelocation2).build().perform();
			Thread.sleep(3000);
*/
			WebElement ok = driver.findElement(By.xpath("//*[@id='btnMidbtnOK']")); // Location OK

			ok.click();
			Thread.sleep(4000);

			driver.switchTo().frame("childmain");
			Thread.sleep(2000);

			WebElement save = driver.findElement(By.xpath("//li[@id='menuBar2_Menu1']"));
			save.click();
			Thread.sleep(5000);

			WebElement reason = driver.findElement(By.xpath("//input[@id='fld4101088']"));
			reason.sendKeys("Asset Induction");
			Thread.sleep(2000);

			WebElement ok1 = driver.findElement(By.xpath("//*[@id='lblButtonbtnSubmitAudit']"));
			ok1.click();
			Thread.sleep(8000);

			driver.switchTo().frame("childmain");
			Thread.sleep(2000);

			WebElement action = driver.findElement(By.xpath("//*[@id='menuBar1_Menu1']"));
			action.click();
			Thread.sleep(6000);

			WebElement statuschange = driver.findElement(By.linkText("Change Status"));
			statuschange.click();
			Thread.sleep(2000);

			driver.switchTo().frame("STATUSCHANGE");
			Thread.sleep(2000);

			WebElement commentss = driver.findElement(By.xpath("//*[@id='fldtxtComments']"));
			commentss.sendKeys(P126); 
			Thread.sleep(4000);

			WebElement ok2 = driver.findElement(By.xpath("//*[@id='lblButtonbtnApply']"));
			ok2.click();
			Thread.sleep(6000);

			driver.close();

			Thread.sleep(2000);

			driver.switchTo().window(pw);
			Thread.sleep(2000);

		}

	}

}
