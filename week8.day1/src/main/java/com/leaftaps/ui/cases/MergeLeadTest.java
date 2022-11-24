package com.leaftaps.ui.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.ui.base.ProjectSpecificMethods;
import com.leaftaps.ui.pages.LoginPage;

public class MergeLeadTest extends ProjectSpecificMethods {
	@BeforeTest
	public String setData()
	{
		excelFileName="tc003-MergeLead";
		return excelFileName;
	}
		
		
		
	@Test(dataProvider ="testData")
		public void runMergeLead(String UserName,String PassWord) throws InterruptedException {
		
		System.out.println("Driver from Test "+driver);
		
		LoginPage pg=new LoginPage(driver);
		
		pg.typeUsername(UserName).typePassword(PassWord).clickLoginButton_Positive().clickCRMSFA()
		.clickContacts().clickonMergeContacts().clickOnWidgetofFromContact().clickOnFirstResultingContact()
		.clickOnWidgetofToContact().clickSecondResultingContact().clickOnMergeButton().handleAlert();
		
		
}}
