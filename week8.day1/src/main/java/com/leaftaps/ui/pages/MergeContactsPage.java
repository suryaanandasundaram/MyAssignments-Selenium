package com.leaftaps.ui.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class MergeContactsPage extends ProjectSpecificMethods {
	
	Set<String> windowHandles;
	List<String> windowHandlesList;
	String parentwindow;
	Set<String> windowHandles2;
	List<String> windowHandlesList2;
	
	
	
	public MergeContactsPage(RemoteWebDriver receiveddriver )
	{
		this.driver=receiveddriver;
	}
    public MergeContactsPage clickOnWidgetofFromContact()
    {
    	WebElement FromContact = driver.findElement(By.xpath("//img[@alt='Lookup'][1]"));
    	FromContact.click();
    	return this;
    	
    }
    public MergeContactsPage clickOnFirstResultingContact()
      { 
    	parentwindow= driver.getWindowHandle();
    	windowHandles=driver.getWindowHandles();
	    windowHandlesList = new ArrayList<String>(windowHandles);
    	driver.switchTo().window(windowHandlesList.get(1));
    	WebElement elementFrom = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a[1]"));
    	elementFrom.click();
    	driver.switchTo().window(parentwindow);   	
    	return this;
    }
     
    public MergeContactsPage clickOnWidgetofToContact() throws InterruptedException
    {
    	WebElement ToContact = driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]"));
    	Thread.sleep(2000);
    	ToContact.click();
    	return this;
    }
    public MergeContactsPage clickSecondResultingContact() throws InterruptedException
    {
    	 windowHandles2 = driver.getWindowHandles();
    	 windowHandlesList2 = new ArrayList<String>(windowHandles2);
    	 driver.switchTo().window(windowHandlesList2.get(1));
    	 WebElement elementTo = driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a)[2]"));
    	Thread.sleep(2000);
    	elementTo.click();
    	driver.switchTo().window(parentwindow);
    	return this;
    }
    
    public MergeContactsPage clickOnMergeButton()
    {
    	WebElement Merge = driver.findElement(By.xpath("//a[@class='buttonDangerous']"));
    	Merge.click();
    	return this;
    }
    public ViewContactPage handleAlert()
    {
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
    	return new ViewContactPage(driver);
    }
	
	
}
