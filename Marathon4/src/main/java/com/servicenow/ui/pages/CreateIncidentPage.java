package com.servicenow.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.servicenow.ui.base.BaseClass;

public class CreateIncidentPage extends BaseClass {

	public CreateIncidentPage(RemoteWebDriver recdriver,Properties recprop)
	{
		this.driver=recdriver;
		this.prop=recprop;
		PageFactory.initElements(driver, prop);
	}
	
	public CreateIncidentPage enterDescription(String desc)
	{
		driver.findElement(By.id("incident.short_description")).sendKeys(desc);
		return this;
	}
	
	public ViewIncidentPage enterSubmit()
	{
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		return new ViewIncidentPage(driver,prop);
	}
	
	
	
}
