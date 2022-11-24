package com.leaftaps.ui.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.ui.base.ProjectSpecificMethods;
import com.leaftaps.ui.pages.LoginPage;

public class EditLeadTest extends ProjectSpecificMethods {
	@BeforeTest
	public String setData()
	{
		excelFileName="tc002-EditLead";
		return excelFileName;
	}
		
		
		
	@Test(dataProvider ="testData")
		public void runEditLead(String UserName,String PassWord,String pnumber, String Cname) throws InterruptedException {
		
		System.out.println("Driver from Test "+driver);
		
		LoginPage pg =new LoginPage(driver,prop);
		pg.typeUsername(UserName).typePassword(PassWord).clickLoginButton_Positive().
		clickCRMSFA()
		.clickLeads().clickFindLeads().clickOnPhone().typePhoneNumber(pnumber).clickonFindLeadsButton().storeFirstLeadId().clickFirstresultingID()
		.clickonEdit().updateCompanyName(Cname).clickUpdateButton();
		
	}	
}
