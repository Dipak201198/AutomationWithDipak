/* Test Script of Maintenance Event for Event Creation with asset adds in Event */

package tests.ModernaTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Event {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://ram-gmp-t/ram/default.aspx");

		// Maximize window size of browser
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@onchange='UpdateLoginForm();']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[text()='Moderna (MODERNA)']")).click();
		Thread.sleep(5000);
		// Enter your login email id
		driver.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("agopale@modernatx.com");
		Thread.sleep(5000);

		// Enter your login password
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("OneUpland@2023");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@id='btnMidbtnLogin']")).click();
		Thread.sleep(10000);

//	driver.findElement(By.xpath("//a[text()='Go To']")).click();
//	Thread.sleep(5000);
//	
//	driver.findElement(By.xpath("//a[@data-menuvalue='OPT_QUERY']")).click();
//	Thread.sleep(5000);

		File file = new File("D:\\Selenium Excel\\Event Bulk Loader.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowcountt = sheet.getLastRowNum() + 1;

		for (int i = 1; i < rowcountt; i++) {
			WebElement neww = driver.findElement(By.xpath("//*[text()='New'][1]"));
			neww.click();
			Thread.sleep(2000);

			WebElement Event = driver.findElement(By.xpath("(//*[text()='Event'])"));
			Thread.sleep(5000);

			Actions act = new Actions(driver);
			Thread.sleep(5000);
			act.doubleClick(Event).build().perform();
			Thread.sleep(5000);

//	driver.switchTo().frame("SysWizardWindow");
//	
//	driver.findElement(By.xpath("//div[@id='panelView1_ToggleBar']")).click();
//	
//	WebElement eventtype=driver.findElement(By.xpath("//*[text()='Shared']"));
//	eventtype.click();
//	Thread.sleep(2000);

//	WebElement MaintenanceEvent= driver.findElement(By.xpath("(//a[text()='Maintenance Event'])[1]"));
//	Thread.sleep(5000);
//	act.doubleClick(MaintenanceEvent).build().perform();
//	Thread.sleep(5000);
//	
//	WebElement AllMaintenanceEvents= driver.findElement(By.xpath("//a[text()='All Maintenance Events']//parent::li"));
//	Thread.sleep(5000);
//	act.doubleClick(AllMaintenanceEvents).build().perform();
//	Thread.sleep(6000);
//	
//	driver.switchTo().frame("panelView2_Panel3_Body");
//	Thread.sleep(5000);
//	
//	WebElement newEvent= driver.findElement(By.xpath("//li[@id='itemList_MB1_Menu3']"));
//	Thread.sleep(5000);
//	act.doubleClick(newEvent).build().perform();
//	Thread.sleep(5000);

			// switch to frame pop-up
			driver.switchTo().parentFrame();
			driver.switchTo().frame("SysWizardWindow");

			Thread.sleep(8000);
			driver.findElement(By.xpath("//label[text()='Shared']//parent::span//input")).click();

			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='Next']")).click();

			Thread.sleep(8000);
			// clicked on maintenance radio button
			driver.findElement(By.xpath("(//input[@name='EventType'])[4]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(1000);

			// Enter the Event Name in Provided by Excel
			WebElement eventname = driver.findElement(By.xpath("//input[@id='fld5113006']"));

			String cellValue = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(cellValue);
			eventname.sendKeys(cellValue);
			Thread.sleep(5000);

			// Click the Next Button After Entering the Event Name
			driver.findElement(By.xpath("//span[@id='lblButtonbtnNext']")).click();
			Thread.sleep(1000);

			// Click the Next Button After Selecting the Rule Name
			driver.findElement(By.xpath("//span[@id='lblButtonbtnNext']")).click();
			Thread.sleep(1000);

			// Select the Wizard to complete the adding the Events
			driver.findElement(By.xpath("(//input[@name='rbRecOptions'])[2]")).click();
			Thread.sleep(1000);

			// Click the Finish Button for Completing the Event
			driver.findElement(By.xpath("//*[text()='Finish']")).click();
			Thread.sleep(5000);

			// switch to frame pop-up
			String parent = driver.getWindowHandle();

			Set<String> s = driver.getWindowHandles();

			// Now iterate using Iterator
			Iterator<String> I1 = s.iterator();

			while (I1.hasNext()) {
				String child_window = I1.next();

				if (!parent.equals(child_window))

					driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

//		driver.manage().window().maximize();

			}
			driver.switchTo().parentFrame();
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			Thread.sleep(5000);

			// Click the Finish Button for Completing the Event
			driver.findElement(By.xpath("//label[@id='lblQuestion']//parent::div//following::a[@id='btnOk']")).click();
			Thread.sleep(5000);

			// switch to frame pop-up
			// Switch to Frame using id of the frame
			driver.switchTo().frame("childmain");

			// Identifying the heading in webelement
			WebElement frame1Heading = driver.findElement(By.id("form1"));

			// Identifying the heading in webelement

			Row row = sheet.getRow(i);
			Cell cell = row.createCell(12);

			String eventid = driver.findElement(By.xpath("//input[@id='fld5113005']")).getAttribute("value");
			cell.setCellValue(eventid);
			Thread.sleep(2000);

			FileOutputStream fos = new FileOutputStream(file);

			workbook.write(fos);

			fos.close();

			Thread.sleep(2000);

			String workrule = sheet.getRow(i).getCell(6).getStringCellValue();
			WebElement workruleMenu = driver.findElement(By.xpath("//input[@id='fld5113010']"));
			workruleMenu.click();
			workruleMenu.sendKeys(workrule);
			Thread.sleep(4000);

			String eventdepartment = sheet.getRow(i).getCell(7).getStringCellValue();
			WebElement eventDepartmenntMenu = driver.findElement(By.xpath("//input[@id='fld5113014']"));
			eventDepartmenntMenu.click();
			eventDepartmenntMenu.sendKeys(eventdepartment);
			Thread.sleep(4000);

			String manufacturetask = sheet.getRow(i).getCell(10).getStringCellValue();
			WebElement manufacturetaskMenu = driver.findElement(By.xpath("//textarea[@id='fld5113243']"));
			manufacturetaskMenu.click();
			manufacturetaskMenu.sendKeys(manufacturetask);
			Thread.sleep(7000);

			// Click On save button.
			driver.findElement(By.xpath("//a[@title='Save']")).click();
			Thread.sleep(5000);

			// Select Reason
			driver.findElement(By.xpath("//input[@id='fld5113600']")).sendKeys("New Record");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[@id='lblButtonbtnSubmitAudit']")).click();
			Thread.sleep(5000);

//		//Switch to Frame using id of the frame
//        driver.switchTo().frame("childmain");
//        
//        //Identifying the heading in webelement
//        WebElement frame2Heading= driver.findElement(By.id("form1"));
//		
//		
//		// Click On View Button
//		driver.findElement(By.xpath("//li[@id='menuBar1_Menu2']")).click();
//		Thread.sleep(5000);
//		
//		// Click On Show Asset Using
//		driver.findElement(By.xpath("//a[@data-menuvalue='OPT_ASSETS']")).click();
//		Thread.sleep(7000);
//		
//			
//		driver.switchTo().parentFrame();
//		driver.switchTo().frame(0);
//		driver.switchTo().frame(0);
//		
//		//Click On Insert Button
//		driver.findElement(By.xpath("//li[@id='assetList_MB1_Menu1']")).click();
//		Thread.sleep(5000);
//		
//		//Switch to Frame
//		driver.switchTo().parentFrame();
//		driver.switchTo().frame(0);
//		driver.switchTo().frame(0);
//		driver.switchTo().frame(1);
//		
////		driver.switchTo().frame(driver.findElement(By.webLocator('frame-web-locator-property')));
//		
//    	//Click On Choose Query Button
//		driver.findElement(By.xpath("//a[@title='Choose Query']")).click();
//		Thread.sleep(6000);
//		
//	
//		
//		/*
//		//Switch to Frame using id of the frame
//        driver.switchTo().frame("childmain");
//        
//        //Identifying the heading in webelement
//        WebElement frame5Heading= driver.findElement(By.id("itemList:cg_ss_dialog"));
//        
//      //Click On All Asset Text(Right Side)
//        driver.findElement(By.xpath("(//a[text()='All Assets'])[2]")).click();
//        Thread.sleep(5000);
//		*/

			// Close the Browser
			driver.close();
//		
		}
		// Close the Browser
		driver.close();

	}
}
