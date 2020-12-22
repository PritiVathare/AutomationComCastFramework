package com.comcast.conatcttest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.commonutils.ExcelUtility;
import com.comcast.commonutils.FileUtility;
import com.comcast.commonutils.JavaUtils;
import com.comcast.commonutils.WebDriverUTils;

public class CreateNewLeadByAssignTo
{
	@Test
	public  void CreateNewLeadByAssignTo() throws Throwable {
		WebDriverUTils wLib=new WebDriverUTils();
		FileUtility fLib=new FileUtility(); 
		ExcelUtility elib=new ExcelUtility();
		
		//Common Data
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		String BROWSER=fLib.getPropertyKeyValue("browser");

		//Test Data
		String LastName=elib.getExcelData("Lead", "tc_01", "LastName")+JavaUtils.getRanDomData();
		String LeadCompany=elib.getExcelData("Lead", "tc_01", "LeadCompany");
		String AssignTo=elib.getExcelData("Lead", "tc_01", "AssignTo");
		
		//step 1- login to app
		WebDriver driver;
		if(BROWSER.equals("chrome"))
				{
		driver=new ChromeDriver();
		}
		else {
			if(BROWSER.equals("firefox"))
			{
				driver=new FirefoxDriver();
			}
		
		else 
			if(BROWSER.equals("ie"))
			{
				driver=new InternetExplorerDriver();
			}
			else 
				{
					driver=new ChromeDriver();
				}
	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.name("company")).sendKeys(LeadCompany);
		
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		
		String actLeadSuccessfulMsg=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(actLeadSuccessfulMsg.contains(LastName));
		
		//logout the application
		WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.moveMouseToElemnet(driver,wb);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
}
