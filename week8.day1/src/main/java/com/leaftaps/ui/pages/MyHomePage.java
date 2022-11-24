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
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeadsPage(driver);
	}
	
	public ContactPage clickContacts()
	{
		WebElement elementContacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
		elementContacts.click();
		return new ContactPage(driver);
	}
	
	
}
