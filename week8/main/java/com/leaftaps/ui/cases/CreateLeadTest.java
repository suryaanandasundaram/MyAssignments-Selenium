package com.leaftaps.ui.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.ui.base.ProjectSpecificMethods;
import com.leaftaps.ui.pages.LoginPage;

public class CreateLeadTest extends ProjectSpecificMethods {
	@BeforeTest
	public String setData()
	{
		excelFileName="tc001-CreateLead";
		return excelFileName;
	}
		
			
	@Test(dataProvider ="testData")
		public void runCreateLead(String userName,String passWord, String cname,String fname,String lname) {
		
		System.out.println("Driver from Test "+driver);
			
	LoginPage pg =new LoginPage(driver,prop);
	pg.typeUsername(userName).typePassword(passWord).clickLoginButton_Positive().clickCRMSFA().clickLeads().clickCreateLead()
	.typeCompanyname(cname).typeFirstname(fname).typeLastname(lname).clickCreateLeadButton();
	
	
}}
