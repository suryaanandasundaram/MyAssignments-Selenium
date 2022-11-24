package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class ContactPage extends ProjectSpecificMethods {

	public ContactPage(RemoteWebDriver receiveddriver)
	{
		this.driver=receiveddriver;
	}
	
	public MergeContactsPage clickonMergeContacts()
	{
		WebElement mergeContacts = driver.findElement(By.xpath("//a[text()='Merge Contacts']"));
		mergeContacts.click();
		return new MergeContactsPage(driver);
	}
	
	
	
}
