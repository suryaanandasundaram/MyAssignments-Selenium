package com.leaftaps.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods {
	
	public CreateLeadPage(RemoteWebDriver receiveddriver, Properties recprop)
	{
		this.driver=receiveddriver;
		this.prop=recprop;
		PageFactory.initElements(receiveddriver,this);
	}
	@FindBy(how=How.ID,using="createLeadForm_companyName")
	WebElement companyName;
	
	@FindBy(how=How.ID,using="createLeadForm_firstName")
	WebElement firstName;
	
	@FindBy(how=How.ID,using="createLeadForm_lastName")
	WebElement lastName;
	
	@FindBy(how=How.NAME,using="submitButton")
	WebElement submitButton;
	
	

	public CreateLeadPage typeCompanyname(String cname)
	{
		companyName.sendKeys(cname);
		return this;
		
	}
	public CreateLeadPage typeFirstname(String fname)
	{
		firstName.sendKeys(fname);
		return this;
		
	}
	
	public CreateLeadPage typeLastname(String lname)
	{
		lastName.sendKeys(lname);
		return this;
	}
	
	public ViewLeadPage clickCreateLeadButton()
	{
		submitButton.click();
		return new ViewLeadPage(driver,prop);
	}
	
}
