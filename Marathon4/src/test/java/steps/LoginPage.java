package steps;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.servicenow.ui.base.BaseClass;

import io.cucumber.java.en.And;
import runner.BaseClassIncident;

public class LoginPage extends BaseClassIncident {
	
	
	@And("Enter Username as {string}")
	public LoginPage enterUsername(String username)

	{ 
		driver.findElement(By.id("user_name")).sendKeys(username);
		return this;
	}
	
	@And ("Enter Password as {string}")
	public LoginPage enterPassword(String pwd)
	{
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		return this;
	}
	
	@And ("Click Login")
	public WelcomePage clickLogin() throws InterruptedException
	{
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(3000);
		return new WelcomePage();
	}
	
	
	
	
	
	
}
