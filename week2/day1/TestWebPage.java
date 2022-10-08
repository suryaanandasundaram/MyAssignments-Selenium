package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebPage {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	
	WebElement elementUserName = driver.findElement(By.id("username"));
	elementUserName.sendKeys("Demosalesmanager");
	
	WebElement elementPassWord = driver.findElement(By.id("password"));
	elementPassWord.sendKeys("crmsfa");
	
	WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
	elementLogin.click();
	
	WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
	elementLink.click();
	
	WebElement elementLeads = driver.findElement(By.linkText("Leads"));
	elementLeads.click();
	
	WebElement elementCreateLead = driver.findElement(By.linkText("Create Lead"));
	elementCreateLead.click();
	
	WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
	elementCompanyName.sendKeys("ARMS");
	
	WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
	elementFirstName.sendKeys("Suryaprabha");
	
	WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
	elementLastName.sendKeys("Anandasundaram");
	
	WebElement elementFirstNameLocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
	elementFirstNameLocal.sendKeys("Surya");
	
	WebElement elementDepartment = driver.findElement(By.id("createLeadForm_departmentName"));
	elementDepartment.sendKeys("CSE");
	
	WebElement elementDescription = driver.findElement(By.id("createLeadForm_description"));
	elementDescription.sendKeys("Passed with Distinction");
	
	WebElement elementEmail = driver.findElement(By.id("createLeadForm_primaryEmail"));
	elementEmail.sendKeys("suryaanandasundaram@gmail.com");
	
	WebElement elementCreate = driver.findElement(By.className("smallSubmit"));
	elementCreate.click();
	
	WebElement elementEdit = driver.findElement(By.linkText("Edit"));
	elementEdit.click();
	
	WebElement elementDescriptionUpdate = driver.findElement(By.id("updateLeadForm_description"));
	elementDescriptionUpdate.clear();
	
	WebElement elementImportantNote = driver.findElement(By.id("updateLeadForm_importantNote"));
	elementImportantNote.sendKeys("Scholarship granted");
	
	WebElement elementUpdate = driver.findElement(By.className("smallSubmit"));
	elementUpdate.click();
	
	String title =driver.getTitle();
	System.out.println("The Title of the Page is  "+title);
	
	if(title.contains("View Lead"))
	{
		System.out.println("The Title of the Page is Verified");
	}
	else
	{
		System.out.println("The Title of the Page is not Verified");
	}
	
driver.close();
}
}
