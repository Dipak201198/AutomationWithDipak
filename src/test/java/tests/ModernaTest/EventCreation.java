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


public class EventCreation 
{
	 @Test
	  public void f() throws Exception {
		  ChromeOptions chromeOptions = new ChromeOptions();
		    chromeOptions.addArguments("--remote-allow-origins=*");
		  
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(chromeOptions);

			
			driver.get("http://ram-gmp/ram/default.aspx");
			driver.manage().window().maximize();
			Thread.sleep(5000);
			
			File src1= new File("D:\\Selenium Excel\\Event Bulk Loader (04-07-2023).xlsx");
			FileInputStream fis = new FileInputStream(src1);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet1 =wb.getSheetAt(0);
			 
			int rowcountt1=sheet1.getLastRowNum()+1; 
			
			Select drpCountry = new Select(driver.findElement(By.id("lstAuthType")));
			drpCountry.selectByVisibleText("Moderna (MODERNA)");
			Thread.sleep(2000);
			WebElement userr= driver.findElement(By.id("txtUserName"));
			userr.sendKeys("agopale@modernatx.com");
			Thread.sleep(2000);
			WebElement passw=driver.findElement(By.id("txtPassword"));
			passw.sendKeys("OneUpland@2023");
			Thread.sleep(2000);
			WebElement loginbtn=driver.findElement(By.id("lblButtonbtnLogin"));
			loginbtn.click();
			Thread.sleep(30000);
			
			for(int i=1;i<rowcountt1;i++)
			{
			
			WebElement neww=driver.findElement(By.xpath("//li[@id='menuBar1_Menu1']"));
			neww.click();
			Thread.sleep(3000);
			
			WebElement newevent=driver.findElement(By.xpath("//*[text()='Event']"));
			newevent.click();
			Thread.sleep(8000);
					
			Actions act=new Actions(driver);
			
			driver.switchTo().frame("SysWizardWindow");
			Thread.sleep(4000);
			
			WebElement eventtype=driver.findElement(By.xpath("//input[@id='rbnNewPublicEvent']"));
			eventtype.click(); 
			Thread.sleep(3000);
			
			WebElement next=driver.findElement(By.xpath("//*[@id='btnMidbtnNext']"));
			next.click(); 
			Thread.sleep(3000);
			
			WebElement rectype=driver.findElement(By.xpath("//label[@id='lblCalType']"));
			rectype.click(); 
			Thread.sleep(3000);
					
			next.click(); 
			Thread.sleep(3000);
			
			String P1=sheet1.getRow(i).getCell(1).getStringCellValue();
			WebElement eventname=driver.findElement(By.xpath("//input[@id='fld5112006']"));
			eventname.click();
			eventname.sendKeys(P1);
			Thread.sleep(4000);
			
			next.click(); 
			Thread.sleep(3000);
			
			next.click(); 
			Thread.sleep(3000);
			
			WebElement editevent=driver.findElement(By.xpath("//input[@id='rbRecEdit']"));
			editevent.click(); 
			Thread.sleep(3000);
			
			next.click(); 
			Thread.sleep(8000);
			
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
		    Thread.sleep(6000); 
		
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		
		
		    Row row = sheet1.getRow(i);
			Cell cell = row.createCell(312);
		
			String eventid=driver.findElement(By.xpath("//input[@id='fld5112005']")).getAttribute("value");
	        cell.setCellValue(eventid);
	        System.out.println(cell);
	        Thread.sleep(2000);
			
//			FileOutputStream fos = new FileOutputStream(src1);
//			
//			wb.write(fos);
//			
//			fos.close();
	        
		    int P2=(int)sheet1.getRow(i).getCell(3).getNumericCellValue();
			WebElement duration=driver.findElement(By.xpath("//input[@id='fld5112015']"));
			duration.sendKeys(Integer.toString(P2));
			Thread.sleep(3000);
		    			
			String P3=sheet1.getRow(i).getCell(5).getStringCellValue();
			WebElement assignedvendor=driver.findElement(By.xpath("//input[@id='fld5112017']"));
			assignedvendor.sendKeys(P3);
			Thread.sleep(3000);
		
			String P4=sheet1.getRow(i).getCell(6).getStringCellValue();
			WebElement workrule=driver.findElement(By.xpath("//input[@id='fld5112010']"));
			workrule.sendKeys(P4);
			Thread.sleep(3000);
			
			String P5=sheet1.getRow(i).getCell(7).getStringCellValue();
			WebElement evtdept=driver.findElement(By.xpath("//input[@id='fld5112014']"));
			evtdept.sendKeys(P5);
			Thread.sleep(3000);
					
//			int P7=(int)sheet1.getRow(i).getCell(9).getNumericCellValue();
//			WebElement mfgresource=driver.findElement(By.xpath("//input[@id='fld5113203']"));
//			mfgresource.sendKeys(Integer.toString(P7));
//			Thread.sleep(4000);
			
			String P6=sheet1.getRow(i).getCell(8).getStringCellValue();
			WebElement operatorreq=driver.findElement(By.xpath("//input[@id='fld5112019']"));
			operatorreq.click();
			operatorreq.clear();
			operatorreq.sendKeys(P6);
			Thread.sleep(4000);
			
//			String P8=sheet1.getRow(i).getCell(11).getStringCellValue();
//			WebElement desc=driver.findElement(By.xpath("//*[@id='fld5113043']"));
//			desc.sendKeys(P8);
//			Thread.sleep(4000);
			
			
//			String P9=sheet1.getRow(i).getCell(10).getStringCellValue();
//			WebElement mfgtask=driver.findElement(By.xpath("//*[@id='fld5113243']"));
//			mfgtask.sendKeys(P9);
//			Thread.sleep(4000);
			
			String P21=sheet1.getRow(i).getCell(12).getStringCellValue();
			WebElement sop=driver.findElement(By.xpath("//input[@id='fld5112013']"));
			sop.click();
			sop.clear();
			sop.sendKeys(P21);
			Thread.sleep(3000);
			
			
			WebElement CED=driver.findElement(By.id("tabControl1_Tab1"));
			CED.click();
			Thread.sleep(4000);
			
			String P22=sheet1.getRow(i).getCell(13).getStringCellValue();
			WebElement crange=driver.findElement(By.xpath("//textarea[@id='fld5112343']"));
			crange.click();
			crange.sendKeys(P22);
			Thread.sleep(3000);
			
			String P23=sheet1.getRow(i).getCell(14).getStringCellValue();
			WebElement atol=driver.findElement(By.xpath("//textarea[@id='fld5112443']"));
			atol.click();
			atol.sendKeys(P23);
			Thread.sleep(3000);
			
			String P24=sheet1.getRow(i).getCell(15).getStringCellValue();
			WebElement ctol=driver.findElement(By.xpath("//textarea[@id='fld5112543']"));
			ctol.click();
			ctol.sendKeys(P24);
			Thread.sleep(3000);
			
			String P25=sheet1.getRow(i).getCell(16).getStringCellValue();
			WebElement edetails=driver.findElement(By.xpath("//textarea[@id='fld5112143']"));
			edetails.click();
			edetails.sendKeys(P25);
			Thread.sleep(3000);
			
			
			
		/*
			for(int j=13;j<14;j++)
			{
		    
		    WebElement view=driver.findElement(By.xpath("//*[text()='View']"));
		    view.click();
		    Thread.sleep(8000);
		    
		    WebElement showassetusing=driver.findElement(By.xpath("//*[text()='Show Assets Using']"));
			showassetusing.click(); 
			Thread.sleep(10000);
			
			driver.switchTo().frame("DETAIL_VIEW");
			Thread.sleep(12000);
			
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
		
		    WebElement choosequery=driver.findElement(By.xpath("//li[@id='itemList_MB1_Menu4']"));
		    choosequery.click(); 
			Thread.sleep(10000);
			
			WebElement allasset=driver.findElement(By.xpath("//a[@href=\"javascript: CoolGridUtils.RunSelect('itemList', '1D5536E5-39A4-49EA-8B2D-A5B246F83BAD', 'All Assets');\"]"));
			allasset.click(); 
			Thread.sleep(20000);
					
			WebElement filter=driver.findElement(By.xpath("//*[@id=\"itemList_MB1_Menu1\"]"));
			filter.click(); 
			Thread.sleep(10000);
		     
		    System.out.println(cell);
		    				
		    int data2=(int)sheet1.getRow(i).getCell(j).getNumericCellValue();
		    driver.findElement(By.xpath("//input[@id='itemList:cg_qf_text']")).sendKeys(Integer.toString(data2));
		    System.out.println(data2);
		    Thread.sleep(6000);
		
		    WebElement search=driver.findElement(By.xpath("//*[@id='itemList:cg_qf_searchLink']"));
		    search.click(); 
		    Thread.sleep(6000);
		
		    WebElement aa=driver.findElement(By.xpath("//*[@id='itemList:cg_tbl_body']"));
		    act.moveToElement(aa);
		    act.doubleClick(aa).build().perform();  
		    Thread.sleep(6000);
		
		    WebElement done=driver.findElement(By.xpath("//*[@id='btnMidbtnOK']"));
		    done.click(); 
		    Thread.sleep(3000);
		
		    driver.switchTo().window(c2);
		 	driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.switchTo().frame(0);
		
			Thread.sleep(3000);
			WebElement close=driver.findElement(By.xpath("//*[@id='DETAIL_VIEW_closer']"));
			close.click(); 
			Thread.sleep(3000);

		     }

			
			WebElement view=driver.findElement(By.xpath("//*[text()='View']"));
		    view.click();
		    Thread.sleep(8000);
		    
		    WebElement workplantemplate=driver.findElement(By.xpath("//*[text()='Work Plan Templates']"));
			workplantemplate.click(); 
		    Thread.sleep(4000);
			
			driver.switchTo().frame("EVWPT");
			Thread.sleep(10000);
		
		    
		    WebElement workplantemplateinsert=driver.findElement(By.xpath("//li[@id='grdWPT_MB1_Menu3']"));
		    workplantemplateinsert.click(); 
		    Thread.sleep(10000);
		 	

		    WebElement workplantemplatefilter=driver.findElement(By.xpath("//li[@id='grdAvail_MB1_Menu1']"));
		    workplantemplatefilter.click(); 
		    Thread.sleep(10000);
		    
		    String P11=sheet1.getRow(i).getCell(12).getStringCellValue();
			WebElement worktemplateid=driver.findElement(By.xpath("//input[@id='grdAvail:cg_qf_text']"));
			worktemplateid.sendKeys(P11);
			Thread.sleep(4000);
			
			WebElement filtersearch=driver.findElement(By.xpath("//*[@id='grdAvail:cg_qf_searchLink']"));
			filtersearch.click(); 
		    Thread.sleep(14000);
		    
		    WebElement selectrecord=driver.findElement(By.xpath("//*[@id='grdAvail:cg_tbl_body']"));
		    selectrecord.click(); 
		    Thread.sleep(4000);
		  	    
		    WebElement add=driver.findElement(By.xpath("//*[@id='lblButtonbtnAddWPT']"));
		    add.click(); 
		    Thread.sleep(4000);
		    
		    WebElement closewdw=driver.findElement(By.xpath("//*[@id='wptSelectionDialog_closer']"));
		    closewdw.click(); 
		    Thread.sleep(4000);
		    
		    WebElement closewdw2=driver.findElement(By.xpath("//*[@id='lblButtonbtnOk']"));
		    closewdw2.click(); 
		    Thread.sleep(4000);
		    
		    driver.switchTo().frame(0);
			
			Thread.sleep(3000);
		  */
			WebElement save=driver.findElement(By.xpath("//li[@id='menuBar2_Menu1']"));
			save.click(); 
		    Thread.sleep(6000); 
		
		    WebElement reason=driver.findElement(By.xpath("//input[@id='fld5112600']"));
			reason.sendKeys("New Record");	       
			Thread.sleep(5000);
		   
		    WebElement ok1=driver.findElement(By.xpath("//*[@id='btnMidbtnSubmitAudit']"));
		    ok1.click();
		    Thread.sleep(8000);
		    
			 driver.close();
		    
		    driver.switchTo().window(pw);
		    Thread.sleep(2000);
		    
	      }
		driver.close();	
	  }
}
