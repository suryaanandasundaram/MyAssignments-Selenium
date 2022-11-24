package com.leaftaps.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods {

	public ViewLeadPage(RemoteWebDriver receiveddriver,Properties recprop)
	{
		this.driver=receiveddriver;
		this.prop=recprop;
		PageFactory.initElements(receiveddriver,this);
	}
	
	public ViewLeadPage(RemoteWebDriver receiveddriver,String leadId,Properties recprop)
	{
		this.prop=recprop;
		this.driver=receiveddriver;
		this.leadID=leadId;
		PageFactory.initElements(receiveddriver,this);
	}
	public MyLeadsPage clickonDelete() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.linkText(prop.getProperty("ViewLeadsPage.Delete.LinkText"))).click();
		return new MyLeadsPage(driver,leadID,prop);
	}
	
	public EditLeadPage clickonEdit()
	{
		driver.findElement(By.linkText(prop.getProperty("ViewLeadsPage.Edit.LinkText"))).click();
		return new EditLeadPage(driver,prop);
	}
	public DuplicateLeadPage clickOnDuplicate()
	{
		driver.findElement(By.linkText(prop.getProperty("ViewLeadsPage.Duplicate.LinkText"))).click();
		return new DuplicateLeadPage(driver,prop);
	}
	
}
