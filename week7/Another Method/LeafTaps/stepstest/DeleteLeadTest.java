package stepstest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import hookstest.BaseClassTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadTest extends BaseClassTest
{
	
	
	@And("Click on Find Leads")
	public void dlClickOnfindLeads()
	{
		WebElement elementFindLead = driver.findElement(By.linkText("Find Leads"));
		elementFindLead.click();
	}
		
	@And("Click on First resulting result")
	public void dlFirstResultingResult()
	{
		WebElement elementFirst = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]"));
		String text = elementFirst.getText();
		System.out.println(text);
		
		WebElement elementFirst1=driver.findElement(By.linkText(text));
		
		elementFirst1.click();
		System.out.println("The First Resulting lead ID " +text);
	}
		
	@When("Click on delete")
	public void clickOndelete()
	{
		WebElement elementDelete = driver.findElement(By.linkText("Delete"));
		elementDelete.click();
		
		WebElement elementFindLead1 = driver.findElement(By.linkText("Find Leads"));
		elementFindLead1.click();
			
	}
	
	@Then("Verify the title of the page after delete")
	public void dlVerifyTitle()
	{
		String title = driver.getTitle();
		if(title.contains("My Leads | opentaps CRM"))
		{
			System.out.println("Deleted successfully");
		}	
	
	}
	

}
