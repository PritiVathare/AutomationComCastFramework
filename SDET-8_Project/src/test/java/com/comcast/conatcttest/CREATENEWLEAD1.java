package com.comcast.conatcttest;


import com.comcast.commonutils.WebDriverUTils;
import com.comcast.objectrepositorylib.CREATENEWLEAD;
import com.comcast.objectrepositorylib.Home;
import com.comcast.objectrepositorylib.Lead;
import com.comcast.objectrepositorylib.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.commonutils.ExcelUtility;
import com.comcast.commonutils.FileUtility;
import com.comcast.commonutils.JavaUtils;

public class CREATENEWLEAD1
{
	

	@Test
	public  void CREATENEWLEAD1() throws Throwable {
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
		
		//step 1- login to app

		Login lp=new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		lp.getLoginButton().click();
		
		//step 2- create lead
		Home hp=new Home(driver);
		hp.getLeadsLnk().click();
		
		// step 3- navigate to lead page
		Lead lead=new Lead(driver);
		lead.getCreateLeadImg().click();
		
		//step 4-create lead
		CREATENEWLEAD cnl=new CREATENEWLEAD(driver);
		cnl.creatLead(LastName, LeadCompany, AssignTo);		
		
	}

}
}






















