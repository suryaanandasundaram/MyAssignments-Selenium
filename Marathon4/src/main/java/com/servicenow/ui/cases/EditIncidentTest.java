package com.servicenow.ui.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.servicenow.ui.base.BaseClass;
import com.servicenow.ui.pages.LoginPage;


public class EditIncidentTest extends BaseClass {
	
	@BeforeTest
	public void setSheetName()
	{
		filename="tc001-ServiceNow";
		sheet="EditIncident";
	}
	
	@Test(dataProvider ="Testdata")
	public void runCreateIncident(String uname,String pwd,String desc) throws InterruptedException{
		
		LoginPage pg =new LoginPage(driver,prop);
		pg.enterUsername(uname)
		.enterPassword(pwd)
		.clickLogin()
		.clickAll()
		.clickIncidents()
		.clickFirstIncident()
		.getNumber()
		.enterDescription(desc)
		.enterState()
		.enterurgency()
		.clickUpdate();
		
		
		
	}

}
