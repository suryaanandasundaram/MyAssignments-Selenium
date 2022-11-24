package com.servicenow.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.servicenow.ui.base.BaseClass;

public class ViewIncidentPage extends BaseClass {
	
	WebElement eleFrame2;
	WebElement eleFrame;

	public ViewIncidentPage(RemoteWebDriver recdriver,Properties recprop)
	{
		this.driver=recdriver;
		this.prop=recprop;
		PageFactory.initElements(driver, prop);
	}
	
	public CreateIncidentPage clickNew()
	{
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		text = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Inident Number "+text);
		return new CreateIncidentPage(driver,prop);
	}
	public ViewIncidentPage searchCreatedIncident()
	{
		driver.switchTo().defaultContent();
		eleFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame2);
		WebElement numberDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(numberDropDown);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text,Keys.ENTER);
		driver.switchTo().defaultContent();
		return this;
	}
	
	public ViewIncidentPage confirmexists()
	{
		driver.switchTo().frame(eleFrame2);
		String text2 = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		System.out.println(text2); 
		return this;
	
	}
	
	public EditIncidentPage clickFirstIncident() throws InterruptedException
	{
	
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		WebElement result = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a"));
		result.click();
		Thread.sleep(1000);
		return new EditIncidentPage(driver,prop);
	}
	
	
	
	
	
	
	
}
