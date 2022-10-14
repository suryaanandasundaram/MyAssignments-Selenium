package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
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
		
		WebElement elementSource = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd1 = new Select(elementSource);
		dd1.selectByVisibleText("Employee");
		
		
		WebElement elementIndustry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dd2 = new Select(elementIndustry);
		dd2.selectByValue("IND_FINANCE");
		
		
		WebElement elementOwnership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dd3 = new Select(elementOwnership);
		dd3.selectByIndex(5);
		
}
	
}
