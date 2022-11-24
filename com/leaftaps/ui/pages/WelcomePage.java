package com.leaftaps.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class WelcomePage extends ProjectSpecificMethods {
	
	public WelcomePage(RemoteWebDriver receiveddriver, Properties recprop)
	{
		this.driver=receiveddriver;
		this.prop=recprop;
		
		PageFactory.initElements(receiveddriver,this);
	}
	
	@FindBy(how=How.LINK_TEXT,using="CRM/SFA")
	WebElement link;
	
	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit")
	WebElement logout;
	
	

	public MyHomePage clickCRMSFA()
	{
		link.click();
		return new MyHomePage(driver,prop);
	}
	public LoginPage clickLogout()
	{
		logout.click();
		return new LoginPage(driver,prop);
	}
	
	
	
}
