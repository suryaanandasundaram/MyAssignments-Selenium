package com.servicenow.ui.pages;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.servicenow.ui.base.BaseClass;

import io.github.sukgu.Shadow;

public class WelcomePage extends BaseClass{
	
	public WelcomePage(RemoteWebDriver recdriver,Properties recprop)
	{
		this.driver=recdriver;
		this.prop=recprop;
		
	}
	
	
	public WelcomePage clickAll() throws InterruptedException
	{
		shadow = new Shadow(driver);
		shadow.setImplicitWait(40);
		WebElement all = shadow.findElementByXPath("//div[text()='All']");
		all.click();
		return this;
	}
	
	public ViewIncidentPage clickIncidents() throws InterruptedException
	{
		
		shadow.setImplicitWait(50);
		shadow.findElementByXPath("//span[text()='Incidents']").click();
		
		return new ViewIncidentPage(driver,prop);
	}


	
	
	
	
	
	
}
