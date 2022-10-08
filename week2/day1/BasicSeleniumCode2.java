package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicSeleniumCode2 {
	
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main\r\n");
		driver.manage().window().maximize();
		
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
