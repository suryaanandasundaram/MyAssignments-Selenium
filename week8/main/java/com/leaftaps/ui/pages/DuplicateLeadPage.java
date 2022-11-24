package com.leaftaps.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class DuplicateLeadPage extends ProjectSpecificMethods {
	
	public DuplicateLeadPage(RemoteWebDriver receiveddriver,Properties recprop)
	{
		this.driver=receiveddriver;
		this.prop=recprop;
		PageFactory.initElements(receiveddriver,this);
	}
	@FindBy(how=How.NAME,using="submitButton")
	WebElement submitButton;
	
	
	
	public ViewLeadPage clickOnCreateLead()
	{
		submitButton.click();
		return new ViewLeadPage(driver,prop);
	}

}
