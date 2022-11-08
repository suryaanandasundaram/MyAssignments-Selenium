package dataprovider.leaftaps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DPCreateLeadLT extends DPBaseClassLT {
	
	@BeforeTest
	public String setfileName()
	{
		fileName="TC001-DPCreateLead";
		return fileName;
	}
	
	@Test(dataProvider="testDataLT")
	public void runDPCreateLeadLT (String uname,String pwd,String cname,String fname,String lname)
	{
		
		
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys(uname);
		
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys(pwd);
		
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		
		WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
		
		WebElement elementLeads = driver.findElement(By.linkText("Leads"));
		elementLeads.click();
		
		WebElement elementCreateLead = driver.findElement(By.linkText("Create Lead"));
		elementCreateLead.click();
		
		WebElement elementCompanyName= driver.findElement(By.id("createLeadForm_companyName"));
		elementCompanyName.sendKeys(cname);
		
		WebElement elementFirstName= driver.findElement(By.id("createLeadForm_firstName"));
		elementFirstName.sendKeys(fname);
		
		WebElement elementLastName= driver.findElement(By.id("createLeadForm_lastName"));
		elementLastName.sendKeys(lname);
		
		WebElement elementSubmit= driver.findElement(By.className("smallSubmit"));
		elementSubmit.click();
		
		
		
		
	}
}
