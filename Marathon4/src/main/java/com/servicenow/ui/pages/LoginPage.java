package com.servicenow.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.servicenow.ui.base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage(RemoteWebDriver recdriver,Properties recprop)
	{
		this.driver=recdriver;
		this.prop=recprop;
		
	}
	
	public LoginPage enterUsername(String username)

	{ 
		driver.findElement(By.id("user_name")).sendKeys(prop.getProperty("username"));
		return this;
	}
	
	public LoginPage enterPassword(String pwd)
	{
		driver.findElement(By.id("user_password")).sendKeys(prop.getProperty("password"));
		return this;
	}
	
	public WelcomePage clickLogin() throws InterruptedException
	{
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(3000);
		return new WelcomePage(driver,prop);
	}
	
	
	
	
	
	
}
