package com.leaftaps.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods {
	
	public MyHomePage(RemoteWebDriver receiveddriver,Properties recprop)
	{
		this.driver=receiveddriver;
		this.prop=recprop;
		PageFactory.initElements(receiveddriver,this);
	}

	
	public MyLeadsPage clickLeads()
	{
		driver.findElement(By.linkText(prop.getProperty("MyHomePage.Leads.LinkText"))).click();
		return new MyLeadsPage(driver,prop);
	}
	
	public ContactPage clickContacts()
	{
		WebElement elementContacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
		elementContacts.click();
		return new ContactPage(driver,prop);
	}
	
	
}
