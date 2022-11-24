package com.leaftaps.ui.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.ui.base.ProjectSpecificMethods;
import com.leaftaps.ui.pages.LoginPage;

public class DeleteLeadTest extends ProjectSpecificMethods{
	

	@BeforeTest
	public String setData()
	{
		excelFileName="tc005-DeleteLead";
		return excelFileName;
	}
	
	
	@Test(dataProvider ="testData")
	public  void runDeleteLead(String userName,String password,String pnumber) throws InterruptedException{
		LoginPage pg =new LoginPage(driver,prop);
		pg.typeUsername(userName).typePassword(password).clickLoginButton_Positive().clickCRMSFA()
		.clickLeads()
		.clickFindLeads()
		.clickOnPhone()
		.typePhoneNumber(pnumber)
		.clickonFindLeadsButton()
		.storeFirstLeadId()
		.clickFirstresultingID()
		.clickonDelete()
		.clickFindLeads()
		.enterleadID()
		.clickonFindLeadsButton()
		.validateDisplayedrecords();
		
	}

}
