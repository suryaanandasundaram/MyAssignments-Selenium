package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class DuplicateLeadPage extends ProjectSpecificMethods {
	
	public DuplicateLeadPage(RemoteWebDriver receiveddriver )
	{
		this.driver=receiveddriver;
	}
	public ViewLeadPage clickOnCreateLead()
	{
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}

}
