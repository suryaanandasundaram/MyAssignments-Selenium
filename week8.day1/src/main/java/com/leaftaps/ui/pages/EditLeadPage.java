package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class EditLeadPage extends ProjectSpecificMethods{

	public EditLeadPage(RemoteWebDriver receiveddriver)
	{
		this.driver=receiveddriver;
	}
	public EditLeadPage updateCompanyName(String cname)
	{
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
		return this;
	}
	public ViewLeadPage clickUpdateButton()
	{
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}
	
	
	
	
	
	
	
}
