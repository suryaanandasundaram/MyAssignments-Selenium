package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class MyLeadsPage extends ProjectSpecificMethods {
	
	public MyLeadsPage(RemoteWebDriver receiveddriver )
	{
		this.driver=receiveddriver;
	}
	
	public MyLeadsPage(RemoteWebDriver receiveddriver,String receivedLeadId)
	{
		this.driver=receiveddriver;
		this.leadID=receivedLeadId;
	}

	public CreateLeadPage clickCreateLead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage(driver);
	}
	public FindLeadsPage clickFindLeads()
	{
		driver.findElement(By.linkText("Find Leads")).click();
		return new FindLeadsPage(driver,leadID);
	}
	
	
	
	
}
