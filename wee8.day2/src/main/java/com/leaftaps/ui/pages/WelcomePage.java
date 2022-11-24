package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class WelcomePage extends ProjectSpecificMethods {
	
	public WelcomePage(RemoteWebDriver receiveddriver)
	{
		this.driver=receiveddriver;
	}

	public MyHomePage clickCRMSFA()
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage(driver);
	}
	public LoginPage clickLogout()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		return new LoginPage(driver);
	}
	
	
	
}
