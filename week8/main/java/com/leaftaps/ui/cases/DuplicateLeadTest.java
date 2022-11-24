package com.leaftaps.ui.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.ui.base.ProjectSpecificMethods;
import com.leaftaps.ui.pages.LoginPage;

public class DuplicateLeadTest extends ProjectSpecificMethods {
	@BeforeTest
	public String setData()
	{
		excelFileName="tc004-DuplicateLead";
		return excelFileName;
	}
		
		
		
	@Test(dataProvider ="testData")
		public void runDuplicateLead(String UserName,String PassWord) throws InterruptedException {
		
		System.out.println("Driver from Test "+driver);
		
		LoginPage pg =new LoginPage(driver,prop);
		
		pg.typeUsername(UserName).typePassword(PassWord).clickLoginButton_Positive().clickCRMSFA()
		.clickLeads().clickFindLeads().clickFirstresultingID().clickOnDuplicate();
		
		
}}
