package com.leaftaps.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage(RemoteWebDriver receiveddriver,Properties recprop)
	{
		this.driver=receiveddriver;
		this.prop=recprop;
		PageFactory.initElements(receiveddriver,this);
	}
	
	@CacheLookup
	@FindBy(how=How.ID,using="username")
	WebElement userName;
	
	@FindBy(how=How.ID,using="password")
	WebElement passWord;
	
	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit")
	WebElement login;
	
	
	
	
	public LoginPage typeUsername(String uname)
	{
		System.out.println(prop.getProperty("username"));
		
		String property = prop.getProperty("username");
		userName.sendKeys(prop.getProperty("username"));
		return this;
	}
	public LoginPage typePassword(String pwd )
	{
		passWord.sendKeys(prop.getProperty("password"));
		return this;
	}
	
	public WelcomePage clickLoginButton_Positive()
	{
		login.click();
		return new WelcomePage(driver,prop);
	}
	public LoginPage clickLoginButton_Negative()
	{
		login.click();
		return this;
	}
}
