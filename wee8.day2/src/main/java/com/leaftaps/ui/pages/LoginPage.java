package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage(RemoteWebDriver receiveddriver)
	{
		this.driver=receiveddriver;
		PageFactory.initElements(receiveddriver,this);
	}
	@CacheLookup
	@FindBy(how=How.ID,using="username")
	WebElement Username;
	
	@FindBy(how=How.ID,using="password")
	WebElement PassWord;
	
	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit")
	WebElement Login;
	
	public LoginPage typeUsername(String userName)
	{
		System.out.println("Driver from LoginPage "+driver);
		
		//driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		
		Username.sendKeys(prop.getProperty("username"));
		return this;
	}
	public LoginPage typePassword(String passWord )
	{
		//driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		PassWord.sendKeys(prop.getProperty("password"));
		return this;
	}
	
	public WelcomePage clickLoginButton_Positive()
	{
		//driver.findElement(By.className("decorativeSubmit")).click();
		Login.click();
		return new WelcomePage(driver);
	}
	public LoginPage clickLoginButton_Negative()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		return this;
	}
}
