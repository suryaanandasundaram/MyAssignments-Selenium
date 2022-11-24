package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods {
	
	public MyHomePage(RemoteWebDriver receiveddriver)
	{
		this.driver=receiveddriver;
	}

	public MyLeadsPage clickLeads()
	{
		driver.findElement(By.linkText(prop.getProperty("MyHomePage.Leads.LinkText"))).click();
		return new MyLeadsPage(driver);
	}
	
	
	
}
