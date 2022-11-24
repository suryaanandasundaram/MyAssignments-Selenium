package steps;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.servicenow.ui.base.BaseClass;

import io.cucumber.java.en.And;
import io.github.sukgu.Shadow;
import runner.BaseClassIncident;

public class WelcomePage extends BaseClassIncident{
	
	
	
	@And("Click on All")
	public WelcomePage clickAll() throws InterruptedException
	{
		shadow = new Shadow(driver);
		shadow.setImplicitWait(40);
		WebElement all = shadow.findElementByXPath("//div[text()='All']");
		all.click();
		return this;
	}
	@And ("Click Incidents in Filter navigator")
	public ViewIncidentPage clickIncidents() throws InterruptedException
	{
		
		shadow.setImplicitWait(50);
		shadow.findElementByXPath("//span[text()='Incidents']").click();
		
		return new ViewIncidentPage();
	}


	
	
	
	
	
	
}
