package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class FindLeadsPage extends ProjectSpecificMethods {
	

	
public FindLeadsPage(RemoteWebDriver receiveddriver)	
{
	this.driver=receiveddriver;
}

public FindLeadsPage clickOnPhone()
{
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	return this;
}
public FindLeadsPage typePhoneNumber(String pnumber)
{
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	return this;
}
public FindLeadsPage clickonFindLeadsButton() throws InterruptedException
{
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
	return this;
}
public FindLeadsPage storeFirstLeadId()
{
	leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	System.out.println(leadID);
	return this;
}
public ViewLeadPage clickFirstresultingID() throws InterruptedException
{
	
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	Thread.sleep(2000);
	return new ViewLeadPage(driver);
	
}
public FindLeadsPage enterleadID( )
{
	
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	return this;
}
public void validateDisplayedrecords()
{
	String text = driver.findElement(By.className("x-paging-info")).getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
}




}
