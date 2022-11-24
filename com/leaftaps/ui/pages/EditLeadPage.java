package com.leaftaps.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class EditLeadPage extends ProjectSpecificMethods{

	public EditLeadPage(RemoteWebDriver receiveddriver,Properties recprop)
	{
		this.driver=receiveddriver;
		this.prop=recprop;
		PageFactory.initElements(receiveddriver,this);
	}
	
	@FindBy(how=How.ID,using="updateLeadForm_companyName")
	WebElement updateCompanyName;
	
	@FindBy(how=How.NAME,using="submitButton")
	WebElement submitButton;
	
	
	public EditLeadPage updateCompanyName(String cname)
	{
		updateCompanyName.sendKeys(cname);
		return this;
	}
	public ViewLeadPage clickUpdateButton()
	{
		submitButton.click();
		return new ViewLeadPage(driver,prop);
	}
	
	
	
	
	
	
	
}
