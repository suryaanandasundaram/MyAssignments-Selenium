package steps;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.servicenow.ui.base.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import runner.BaseClassIncident;

public class CreateIncidentPage extends BaseClassIncident {

	
	@And ("Enter Description as {string}")
	public CreateIncidentPage enterDescription(String desc)
	{
		driver.findElement(By.id("incident.short_description")).sendKeys(desc);
		return this;
	}
	
	@When ("Click submit button")
	public ViewIncidentPage enterSubmit()
	{
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		return new ViewIncidentPage();
	}
	
	
	
}
