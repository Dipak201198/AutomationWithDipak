package tests.ModernaTest;

import java.io.File;
import java.io.FileInputStream;
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

public class AssetparentchildHeirarchy {
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

		File src1 = new File("D:\\Selenium Excel\\Main Sheet of NonGxP Assets by Pawel.xlsx");
		FileInputStream fis = new FileInputStream(src1);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);

		int rowcountt = sheet1.getLastRowNum() + 1;

		Thread.sleep(2000);
		Actions act = new Actions(driver);

		for (int i = 1; i < rowcountt; i++) {

			int P1 = (int) sheet1.getRow(i).getCell(0).getNumericCellValue();
			WebElement search = driver.findElement(By.xpath("//input[@id='txtIdSearch']"));
			search.clear();
			Thread.sleep(2000);
			search.sendKeys(Integer.toString(P1));
			Thread.sleep(10000);

			Set<String> parenthandle = driver.getWindowHandles();
			Iterator<String> it = parenthandle.iterator();
			String pw = it.next();
			String c1 = it.next();
			driver.switchTo().window(c1);
			Thread.sleep(10000);

			driver.switchTo().frame("childmain");

			WebElement view = driver.findElement(By.xpath("//*[text()='View']"));
			view.click();
			Thread.sleep(2000);

			WebElement hierarchy = driver.findElement(By.xpath("//*[text()='Hierarchy']"));
			hierarchy.click();
			Thread.sleep(10000);

			driver.switchTo().frame(0);
			Thread.sleep(2000);

			for (int j = 1; j < 127; j++) {

				Row row = sheet1.getRow(i);
				Cell cell = row.getCell(j);
				System.out.println(cell);

				int P12 = (int) sheet1.getRow(i).getCell(j).getNumericCellValue();

				if (P12 > 0) {

					WebElement addnew = driver.findElement(By.xpath("//*[@id='btnAddComponent']"));
					addnew.click();
					Thread.sleep(12000);

					WebElement filter = driver.findElement(By.xpath("//li[@id='itemList_MB1_Menu1']"));
					filter.click();
					Thread.sleep(12000);

					int P2 = (int) sheet1.getRow(i).getCell(j).getNumericCellValue();
					WebElement assetid = driver.findElement(By.xpath("//input[@id='itemList:cg_qf_text']"));
					assetid.sendKeys(Integer.toString(P2));
					Thread.sleep(4000);

					WebElement search1 = driver.findElement(By.xpath("//*[@id='itemList:cg_qf_searchLink']"));
					search1.click();
					Thread.sleep(12000);

					WebElement click1 = driver.findElement(By.xpath("//*[@id='itemList:cg_tbl_body']"));
					click1.click();
					Thread.sleep(8000);

					WebElement ok = driver.findElement(By.xpath("//*[@id='btnMidbtnAdd']"));
					ok.click();
					Thread.sleep(6000);

					WebElement reason = driver.findElement(By.xpath("//input[@id='fld4101088']"));
					reason.sendKeys("Asset Induction  ");
					Thread.sleep(4000);

					WebElement ok1 = driver.findElement(By.xpath("//*[@id='btnLeftbtnSubmitAudit']"));
					ok1.click();
					Thread.sleep(6000);

					WebElement filter2 = driver.findElement(By.xpath("//li[@id='itemList_MB1_Menu1']"));
					filter2.click();
					Thread.sleep(14000);

					WebElement close = driver.findElement(By.xpath("//*[@id='selectionDialog_closer']"));
					close.click();
					Thread.sleep(6000);

				}


			}
			driver.close();

			driver.switchTo().window(pw);
			Thread.sleep(3000);

		}
	}
}
