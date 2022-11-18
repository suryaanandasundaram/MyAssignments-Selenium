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

public class DuplicateLeadTest extends BaseClassTest {

	
//	@And("Click on Find Leads")
//	public void cilckOnCreateLeads() throws InterruptedException
//	{
//		WebElement elementFindLead = driver.findElement(By.linkText("Find Leads"));
//		elementFindLead.click();
//		Thread.sleep(1000);
//	}
	
	@And("Click on Phone")
	public void clickOnPhone()
	{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@And("Enter Phonenumber as {string}")
	public void enterPhonenumber(String pnumber)
	{
		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pnumber);
	}
	@And("Click on Find Leads Button")
	public void dlClickFindleadsButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}
	@And("Click on the First displayed LeadID")
	public void dlClickFirstdusplayedLeadId()
	{
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@And("Click on DuplicateLead Button")
	public void dlDuplicateLead()
	{
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	@When("Click on CreateLead button in the page")
	public void dlCreateLeadButton()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("Verify the created lead")
	public void verifyDuplicateLead()
	{

		String actualTitle = driver.getTitle();
		
		if(actualTitle.contains("View Lead | opentaps CRM"))
		{
			System.out.println("New Lead Created");
		}
	
	}
	
	
	
	
	
}
