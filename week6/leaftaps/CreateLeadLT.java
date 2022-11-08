package leaftaps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateLeadLT extends BaseClassLT {
	@Test
	public void runCreateLeadLT ()
	{
		
		
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys("Demosalesmanager");
		
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys("crmsfa");
		
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		
		WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
		
		WebElement elementLeads = driver.findElement(By.linkText("Leads"));
		elementLeads.click();
		
		WebElement elementCreateLead = driver.findElement(By.linkText("Create Lead"));
		elementCreateLead.click();
		
		WebElement elementCompanyName= driver.findElement(By.id("createLeadForm_companyName"));
		elementCompanyName.sendKeys("NewASP");
		
		WebElement elementFirstName= driver.findElement(By.id("createLeadForm_firstName"));
		elementFirstName.sendKeys("Surya");
		
		WebElement elementLastName= driver.findElement(By.id("createLeadForm_lastName"));
		elementLastName.sendKeys("Prabha");
		
		WebElement elementSubmit= driver.findElement(By.className("smallSubmit"));
		elementSubmit.click();
		
		
		
		
	}
}
