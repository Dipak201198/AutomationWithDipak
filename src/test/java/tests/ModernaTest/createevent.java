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

public class createevent {

	@Test
	public void f() throws Exception 
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("http://ram-gmp-t/ram/default.aspx");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		File src1 = new File("D:\\Selenium Excel\\Event Bulk Loader.xlsx");
		FileInputStream fis = new FileInputStream(src1);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);

		int rowcountt1 = sheet1.getLastRowNum() + 1;

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
		Thread.sleep(30000);

		for (int i = 1; i < rowcountt1; i++) 
		{

			WebElement neww = driver.findElement(By.xpath("//li[@id='menuBar1_Menu1']"));
			neww.click();
			Thread.sleep(3000);

			WebElement newevent = driver.findElement(By.xpath("//*[text()='Event']"));
			newevent.click();
			Thread.sleep(8000);

			Actions act = new Actions(driver);

			driver.switchTo().frame("SysWizardWindow");
			Thread.sleep(4000);

			WebElement eventtype = driver.findElement(By.xpath("//input[@id='rbnNewPublicEvent']"));
			eventtype.click();
			Thread.sleep(1000);

			WebElement next = driver.findElement(By.xpath("//*[@id='btnMidbtnNext']"));
			next.click();
			Thread.sleep(1000);

			WebElement caltype = driver.findElement(By.xpath("//input[@id='optMaintType']"));
			caltype.click();
			Thread.sleep(1000);

			next.click();
			Thread.sleep(1000);

			String P1 = sheet1.getRow(i).getCell(1).getStringCellValue();
			WebElement eventname = driver.findElement(By.xpath("//input[@id='fld5113006']"));
			eventname.click();
			eventname.sendKeys(P1);
			Thread.sleep(2000);

			next.click();
			Thread.sleep(1000);

			next.click();
			Thread.sleep(1000);

			WebElement editevent = driver.findElement(By.xpath("//input[@id='rbRecEdit']"));
			editevent.click();
			Thread.sleep(1000);

			next.click();
			Thread.sleep(5000);
			
			Set<String> parenthandle= driver.getWindowHandles();
			Iterator<String> it=parenthandle.iterator();
			String pw=it.next();
	        String c1=it.next();
			driver.switchTo().window(c1);
			Thread.sleep(8000);
			
	        driver.switchTo().frame(0);
	        Thread.sleep(2000);
			
			driver.switchTo().frame(0);
			Thread.sleep(2000);
					
			WebElement ok=driver.findElement(By.xpath("//*[@id='btnMidbtnOk']"));
			ok.click(); 
		    Thread.sleep(4000); 
		
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		
		
//		    Row row = sheet1.getRow(i);
//			Cell cell = row.createCell(12);
//		
//			String eventid=driver.findElement(By.xpath("//input[@id='fld5113005']")).getAttribute("value");
//	        cell.setCellValue(eventid);
//	        Thread.sleep(2000);
//			
//			FileOutputStream fos = new FileOutputStream(src1);
//			
//			wb.write(fos);
//			
//			fos.close();
			
			
			String workrule = sheet1.getRow(i).getCell(6).getStringCellValue();
			WebElement workruleMenu = driver.findElement(By.xpath("//input[@id='fld5113010']"));
			workruleMenu.click();
			workruleMenu.sendKeys(workrule);
			Thread.sleep(4000);

			String eventdepartment = sheet1.getRow(i).getCell(7).getStringCellValue();
			WebElement eventDepartmenntMenu = driver.findElement(By.xpath("//input[@id='fld5113014']"));
			eventDepartmenntMenu.click();
			eventDepartmenntMenu.sendKeys(eventdepartment);
			Thread.sleep(4000);

				String manufacturetask = sheet1.getRow(i).getCell(10).getStringCellValue();
				WebElement manufacturetaskMenu = driver.findElement(By.xpath("//textarea[@id='fld5113243']"));
				manufacturetaskMenu.click();
				manufacturetaskMenu.sendKeys(manufacturetask);
				Thread.sleep(7000);
			
			WebElement save=driver.findElement(By.xpath("//li[@id='menuBar2_Menu1']"));
			save.click(); 
		    Thread.sleep(6000); 
		
		    WebElement reason=driver.findElement(By.xpath("//input[@id='fld5113600']"));
			reason.sendKeys("New Record");	       
			Thread.sleep(5000);
		   
		    WebElement ok1=driver.findElement(By.xpath("//*[@id='btnMidbtnSubmitAudit']"));
		    ok1.click();
		    Thread.sleep(8000);
		    
		    
		    //Switch to Frame using id of the frame
	        driver.switchTo().frame("childmain");
	        
	        //Identifying the heading in webelement
	        WebElement frame2Heading= driver.findElement(By.id("form1"));
			
			// Click On View Button
			driver.findElement(By.xpath("//li[@id='menuBar1_Menu2']")).click();
			Thread.sleep(5000);
			 
			// Click On Show Asset Using
			driver.findElement(By.xpath("//a[@data-menuvalue='OPT_ASSETS']")).click();
			Thread.sleep(7000);
		    
//		    WebElement view=driver.findElement(By.xpath("//*[text()='View']"));
//		    view.click();
//		    Thread.sleep(8000);
//		    
//		    WebElement showassetusing=driver.findElement(By.xpath("//*[text()='Show Assets Using']"));
//			showassetusing.click(); 
//			Thread.sleep(10000);
			
			driver.switchTo().frame("DETAIL_VIEW");
			Thread.sleep(12000);
			
			
			// Click On Insert Button
			WebElement insert=driver.findElement(By.xpath("//li[@id='assetList_MB1_Menu1']"));
			insert.click(); 
			Thread.sleep(10000);
			
			Set<String> parenthandle1= driver.getWindowHandles();
			Iterator<String> it1=parenthandle1.iterator();
			String pw1=it1.next();
	        String c2=it1.next();
	        String c3=it1.next();
			driver.switchTo().window(c3);
			Thread.sleep(6000);
			
			driver.switchTo().frame(0);
		    Thread.sleep(2000);
		
		    // Click On Choose Query Button
		    WebElement choosequery=driver.findElement(By.xpath("//li[@id='itemList_MB1_Menu4']"));
		    choosequery.click(); 
			Thread.sleep(10000);
			
			// Click On All Asset Text(Right Side)
			WebElement allasset=driver.findElement(By.xpath("(//a[text()='All Assets'])[2]"));
			allasset.click(); 
			Thread.sleep(20000);
					
			
			// Click On Filter the Record
			WebElement filter=driver.findElement(By.xpath("//a[@title='Quick Find']"));
			filter.click(); 
			Thread.sleep(10000);
		     
//		    System.out.println(cell);
		    
		    // Enter the data in the Filteration Textfield
			
			
		    int assetfilter=(int)sheet1.getRow(i).getCell(12).getNumericCellValue();
		    driver.findElement(By.xpath("//input[@id='itemList:cg_qf_text']")).sendKeys(Integer.toString(assetfilter));
		    System.out.println(assetfilter);
		    Thread.sleep(3000);
		    
		    WebElement searchbutton=driver.findElement(By.xpath("//a[@id='itemList:cg_qf_searchLink']"));
		    searchbutton.click();
			Thread.sleep(4000);
			
			WebElement aa=driver.findElement(By.xpath("//*[@id='itemList:cg_tbl_body']"));
		    act.moveToElement(aa);
		    act.doubleClick(aa).build().perform();  
		    Thread.sleep(3000);
		
		    WebElement done=driver.findElement(By.xpath("//*[@id='btnMidbtnOK']"));
		    done.click(); 
		    Thread.sleep(3000);
		    
		    driver.close();
		    
		    driver.switchTo().window(pw);
		    Thread.sleep(2000);
			
		}

	}

}
