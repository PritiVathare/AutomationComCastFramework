package com.comcast.conatcttest;




import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.comcast.commonutils.BaseClass;

import com.comcast.commonutils.JavaUtils;

import com.comcast.objectrepositorylib.Contacts;

import com.comcast.objectrepositorylib.CreateNewConatct;

import com.comcast.objectrepositorylib.Home;



@Listeners(com.comcast.commonutils.ListenerImplemenation.class)

public class CreateCoantctTest  extends BaseClass{



	@Test(groups = "SmokeTest")

	public void createConatct() throws Throwable {



		/*Test  Data*/

		String contactLastNAme  = elib.getExcelData("Contact", "tc_02", "LastName")+JavaUtils.getRanDomData();



			/*step 2 : navigate to  Organization page */

			Home hp = new Home(driver);

			hp.getContactLnk().click();

			

			/*step 3: navigate to create Contact Page*/

			Contacts cp = new Contacts(driver);

			cp.getCreateOrgImg().click();

			

			/*step 4 create Conatct with Org Name*/

			CreateNewConatct cnc = new CreateNewConatct(driver);

			cnc.createContact(contactLastNAme);		 

	}



}