package com.leaftaps.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class FindLeadsPage extends ProjectSpecificMethods {

public FindLeadsPage(RemoteWebDriver receiveddriver,Properties recprop)
{
	this.driver=receiveddriver;
	this.prop=recprop;
	PageFactory.initElements(receiveddriver,this);
}
		
public FindLeadsPage(RemoteWebDriver receiveddriver,String receivedLeadId,Properties recprop)	
{
	this.driver=receiveddriver;
	this.leadID=receivedLeadId;
	this.prop=recprop;
	PageFactory.initElements(receiveddriver,this);
}

@FindBy(how=How.XPATH,using="//span[text()='Phone']")
WebElement phone;

@FindBy(how=How.XPATH,using="//input[@name='phoneNumber']")
WebElement phoneNumber;

@FindBy(how=How.XPATH,using="//button[@id='ext-gen334']")
WebElement findLeads;

@FindBy(how=How.XPATH,using="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
WebElement lead;

@FindBy(how=How.XPATH,using="//input[@name='id']")
WebElement inputlead;

@FindBy(how=How.CLASS_NAME,using="x-paging-info")
WebElement msg;



public FindLeadsPage clickOnPhone()
{
	phone.click();
	return this;
}
public FindLeadsPage typePhoneNumber(String pnumber)
{
	phoneNumber.sendKeys(pnumber);
	return this;
}
public FindLeadsPage clickonFindLeadsButton() throws InterruptedException
{
	findLeads.click();
	Thread.sleep(2000);
	return this;
}
public FindLeadsPage storeFirstLeadId()
{
	leadID = lead.getText();
	System.out.println(leadID);
	return new FindLeadsPage(driver,leadID,prop);
	
}
public ViewLeadPage clickFirstresultingID() throws InterruptedException
{
	
	lead.click();
	Thread.sleep(2000);
	return new ViewLeadPage(driver,leadID,prop);
	
}
public FindLeadsPage enterleadID( )
{
	System.out.println("enter leadID" + leadID);
	inputlead.sendKeys(leadID);
	return this;
}
public void validateDisplayedrecords()
{
	String text = msg.getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
}




}
