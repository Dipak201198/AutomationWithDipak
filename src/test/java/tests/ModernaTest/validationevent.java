package tests.ModernaTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class validationevent 
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();


	driver.get("http://ram-gmp-t/ram/default.aspx");
	
	// Maximize window size of browser
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@onchange='UpdateLoginForm();']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[text()='Moderna (MODERNA)']")).click();
		Thread.sleep(5000);
		// Enter your login email id
		driver.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("vbabu@modernatx.com");
		Thread.sleep(5000);

		// Enter your login password
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("ModNorBos@789");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@id='btnMidbtnLogin']")).click();
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//a[text()='Go To']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[@data-menuvalue='OPT_QUERY']")).click();
		Thread.sleep(5000);
		
		WebElement Event = driver.findElement(By.xpath("(//a[text()='Events'])"));
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		act.doubleClick(Event).build().perform();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@id='panelView1_ToggleBar']")).click();
		
		WebElement MaintenanceEvent= driver.findElement(By.xpath("(//a[text()='Validation Event'])[1]"));
		Thread.sleep(5000);
		act.doubleClick(MaintenanceEvent).build().perform();
		Thread.sleep(5000);
		
		WebElement AllMaintenanceEvents= driver.findElement(By.xpath("//a[text()='All Validation Events']//parent::li"));
		Thread.sleep(5000);
		act.doubleClick(AllMaintenanceEvents).build().perform();
		Thread.sleep(6000);
		
		driver.switchTo().frame("panelView2_Panel3_Body");
		Thread.sleep(5000);
		
		WebElement newEvent= driver.findElement(By.xpath("//li[@id='itemList_MB1_Menu3']"));
		Thread.sleep(5000);
		act.doubleClick(newEvent).build().perform();
		Thread.sleep(5000);
		
		//switch to frame pop-up
		driver.switchTo().parentFrame();
		driver.switchTo().frame("SysWizardWindow");

		Thread.sleep(8000);
		driver.findElement(By.xpath("//label[text()='Shared']//parent::span//input")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();

		Thread.sleep(8000);
		//clicked on maintenance radio button
		driver.findElement(By.xpath("(//input[@name='EventType'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		
		// Enter the Event Name in Provided by Excel 
		WebElement searchWorkOrder= driver.findElement(By.xpath("//input[@id='fld5113006']"));
		
		File file =new File("D:\\Tested File-PlannedStartEnd.xlsx");
//		File file =new File("D:\\Selenium Excel\\Event Bulk Loader.xlsx");
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheetAt(0);

		String cellValue= sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(cellValue);
		searchWorkOrder.sendKeys(cellValue);
		Thread.sleep(10000);
		
		// Click the Next Button After Entering the Event Name
		driver.findElement(By.xpath("//span[@id='lblButtonbtnNext']")).click();
		Thread.sleep(5000);
		
		// Click the Next Button After Selecting the Rule Name
		driver.findElement(By.xpath("//span[@id='lblButtonbtnNext']")).click();
		Thread.sleep(5000);
		
		// Select the Wizard to complete the adding the Events
		driver.findElement(By.xpath("(//input[@name='rbRecOptions'])[2]")).click();
		Thread.sleep(6000);
		
		// Click the Finish Button for Completing the Event
		driver.findElement(By.xpath("//*[text()='Finish']")).click();
		Thread.sleep(5000);
		
		//switch to frame pop-up
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child_window=I1.next();

			if(!parent.equals(child_window))

			driver.switchTo().window(child_window);

			System.out.println(driver.switchTo().window(child_window).getTitle());

//			driver.manage().window().maximize();

		}
			driver.switchTo().parentFrame();
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			Thread.sleep(5000);
			
			// Click the Finish Button for Completing the Event
			driver.findElement(By.xpath("//label[@id='lblQuestion']//parent::div//following::a[@id='btnOk']")).click();
			Thread.sleep(5000);
		
			
			
			driver.close();
	
	
	
	
	}

}
