package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods {

	public ViewLeadPage(RemoteWebDriver receiveddriver)
	{
		this.driver=receiveddriver;
	}
	
	public ViewLeadPage(RemoteWebDriver receiveddriver,String receivedLeadId)
	{
		this.driver=receiveddriver;
		this.leadID=receivedLeadId;
	}
	public MyLeadsPage clickonDelete()
	{
		driver.findElement(By.linkText("Delete")).click();
		return new MyLeadsPage(driver,leadID);
	}
	
	public EditLeadPage clickonEdit()
	{
		driver.findElement(By.linkText("Edit")).click();
		return new EditLeadPage(driver);
	}
	public DuplicateLeadPage clickOnDuplicate()
	{
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateLeadPage(driver);
	}
	
}
