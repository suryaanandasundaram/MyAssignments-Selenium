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


public class CreateLeadTest extends BaseClassTest {
    
	
@And("Click on Create Leads")
public void cilckOnCreateLeads()
{
	WebElement elementCreateLead = driver.findElement(By.linkText("Create Lead"));
	elementCreateLead.click();
}

@And("Enter Company Name as {string}")
public void enterCompanyName(String cname)
{
	WebElement elementCompanyName= driver.findElement(By.id("createLeadForm_companyName"));
	elementCompanyName.sendKeys(cname);
}
@And("Enter FirstName as {string}")
public void enterFirstName(String fname)
{
	WebElement elementFirstName= driver.findElement(By.id("createLeadForm_firstName"));
	elementFirstName.sendKeys(fname);
}

@And("Enter LastName as {string}")
public void enterLastName(String lname)
{
	WebElement elementLastName= driver.findElement(By.id("createLeadForm_lastName"));
	elementLastName.sendKeys(lname);
}	

@When("Click on CreateLead button")
public void clickOnCreateButton()
{
	WebElement elementSubmit= driver.findElement(By.className("smallSubmit"));
	elementSubmit.click();
	
}

@Then("Verify new lead created with given details")
public void verifyLead()
{
	String actualTitle = driver.getTitle();
	
	if(actualTitle.contains("View Lead | opentaps CRM"))
	{
		System.out.println("New Lead Created");
	}
	
}

@Then("Verify the error message")
public void errorMessage()
{
	WebElement errorMsg = driver.findElement(By.xpath("//div[@class='errorMessageHeader']"));
	String text = errorMsg.getText();
	System.out.println(text);
	

}

	
}
