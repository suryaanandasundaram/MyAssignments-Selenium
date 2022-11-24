package steps;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.servicenow.ui.base.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import runner.BaseClassIncident;

public class EditIncidentPage extends BaseClassIncident {

	@And("Enter edit Description as {string}")
	public EditIncidentPage enterDescription(String desc)
	{
		WebElement eleShortDesc = driver.findElement(By.id("incident.short_description"));
		eleShortDesc.clear();
		eleShortDesc.sendKeys(desc);
		return this;
	}
	
	@And("Get Incident Number")
	public EditIncidentPage getNumber()
	{

		WebElement incidentNumber = driver.findElement(By.xpath("//input[@name='incident.number']"));
		String incident = incidentNumber.getAttribute("value");
		System.out.println(incident);
		return this;
	}
	
	@And ("Enter urgency as {string}")
	public EditIncidentPage enterurgency(String urg)
	{

		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select select1 =new Select(urgency);
		select1.selectByVisibleText(urg);
		return this;
	}
	
	@And ("Enter state as {string}")
	public EditIncidentPage enterState(String st)
	{
		WebElement state = driver.findElement(By.id("incident.state"));
		Select select2 =new Select(state);
		select2.selectByVisibleText(st);
		return this;
	}
	@When ("Click Update button")
	public ViewIncidentPage clickUpdate() throws InterruptedException
	{
		WebElement update = driver.findElement(By.id("sysverb_update_bottom"));
		update.click();
		Thread.sleep(1000);
		return new ViewIncidentPage();
	}
	@When ("Click delete Button")
	public ViewIncidentPage clickDelete()
	{
		shadow.findElementByXPath("//button[text()='Delete']").click();
		driver.findElement(By.id("ok_button")).click();
		return new ViewIncidentPage();
	}
	
	
}
