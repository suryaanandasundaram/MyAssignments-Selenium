package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage(RemoteWebDriver receiveddriver)
	{
		this.driver=receiveddriver;
	}
	
	public LoginPage typeUsername(String userName)
	{
		System.out.println("Driver from LoginPage "+driver);
		driver.findElement(By.id("username")).sendKeys(userName);
		return this;
	}
	public LoginPage typePassword(String passWord )
	{
		driver.findElement(By.id("password")).sendKeys(passWord);
		return this;
	}
	
	public WelcomePage clickLoginButton_Positive()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		return new WelcomePage(driver);
	}
	public LoginPage clickLoginButton_Negative()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		return this;
	}
}
