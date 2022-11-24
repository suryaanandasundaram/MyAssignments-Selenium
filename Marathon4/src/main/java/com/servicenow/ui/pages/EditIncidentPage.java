package com.servicenow.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.servicenow.ui.base.BaseClass;

public class EditIncidentPage extends BaseClass {

	public EditIncidentPage(RemoteWebDriver recdriver,Properties recprop)
	{
		this.driver=recdriver;
		this.prop=recprop;
		PageFactory.initElements(driver, prop);
	}
	public EditIncidentPage enterDescription(String desc)
	{
		WebElement eleShortDesc = driver.findElement(By.id("incident.short_description"));
		eleShortDesc.clear();
		eleShortDesc.sendKeys(desc);
		return this;
	}
	public EditIncidentPage getNumber()
	{

		WebElement incidentNumber = driver.findElement(By.xpath("//input[@name='incident.number']"));
		String incident = incidentNumber.getAttribute("value");
		System.out.println(incident);
		return this;
	}
	
	public EditIncidentPage enterurgency()
	{

		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select select1 =new Select(urgency);
		select1.selectByVisibleText("1 - High");
		return this;
	}
	
	public EditIncidentPage enterState()
	{
		WebElement state = driver.findElement(By.id("incident.state"));
		Select select2 =new Select(state);
		select2.selectByVisibleText("In Progress");
		return this;
	}
	
	public ViewIncidentPage clickUpdate() throws InterruptedException
	{
		WebElement update = driver.findElement(By.id("sysverb_update_bottom"));
		update.click();
		Thread.sleep(1000);
		return new ViewIncidentPage(driver,prop);
	}
	
	public ViewIncidentPage clickDelete()
	{
		shadow.findElementByXPath("//button[text()='Delete']").click();
		driver.findElement(By.id("ok_button")).click();
		return new ViewIncidentPage(driver,prop);
	}
	
	
}
