package com.leaftaps.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class MyLeadsPage extends ProjectSpecificMethods {
	
	public MyLeadsPage(RemoteWebDriver receiveddriver,Properties recprop)
	{
		this.driver=receiveddriver;
		this.prop=recprop;
		PageFactory.initElements(receiveddriver,this);
	}
	
	public MyLeadsPage(RemoteWebDriver receiveddriver,String receivedLeadId,Properties recprop)
	{
		this.driver=receiveddriver;
		this.leadID=receivedLeadId;
		this.prop=recprop;
		PageFactory.initElements(driver, prop);
	}

	public CreateLeadPage clickCreateLead()
	{
		driver.findElement(By.linkText(prop.getProperty("MyLeadPage.CreateLead.LinkText"))).click();
		return new CreateLeadPage(driver,prop);
	}
	public FindLeadsPage clickFindLeads()
	{
		driver.findElement(By.linkText(prop.getProperty("MyLeadPage.FindLeads.LinkText"))).click();
		return new FindLeadsPage(driver,leadID,prop);
	}
	
	
	
	
}
