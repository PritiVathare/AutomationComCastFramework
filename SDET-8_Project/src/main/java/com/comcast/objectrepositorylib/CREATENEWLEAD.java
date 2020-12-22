package com.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.commonutils.WebDriverUTils;
 
	public class CREATENEWLEAD extends WebDriverUTils
	{

		WebDriver driver;

		public CREATENEWLEAD(WebDriver driver) { 

			this.driver = driver;

			PageFactory.initElements(driver, this);

		}

		@FindBy(name = "lastname")
		private WebElement leadLastNameEdt;

		@FindBy(name = "company")

		private WebElement CompanyName;

		@FindBy(xpath = "(//input[@type='radio'])[1]")

		private WebElement AssignTo;

		@FindBy(xpath = "(//input[@type='submit'])[1]\")")

		private WebElement Save;

		

		public WebElement getLeadLastNameEdt() {

			return leadLastNameEdt;

		}

		public WebElement getcompanyName() {

			return CompanyName;

		}

	 public WebElement getassignTo() {

			return AssignTo;

		}

		/**

		 *  used to create org with mandatory feilds  

		 * @param orgName

		 */

		public void creatLead(String leadName) {

			leadLastNameEdt.sendKeys(leadName);

			Save.click();

		}

		/**

		 * used create orgnization with below parameter

		 * @param orgName

		 * @param indsutry

		 * @param type

		 * @param rating

		 */

		public void creatLead(String leadName , String companyName, String AssignToo) {

			leadLastNameEdt.sendKeys(leadName);

			select(CompanyName, companyName);

			select(AssignTo, AssignToo);


			Save.click();

		}

		

	}

