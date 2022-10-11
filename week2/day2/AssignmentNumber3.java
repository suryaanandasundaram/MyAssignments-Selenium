package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentNumber3 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
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
		
		WebElement elementFindLead = driver.findElement(By.linkText("Find Leads"));
		elementFindLead.click();
		
	
		WebElement elementFirst = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]"));
		String text = elementFirst.getText();
		System.out.println(text);
		
		WebElement elementFirst1=driver.findElement(By.linkText(text));
		
		elementFirst1.click();
		
	
		
		System.out.println("The First Resulting lead ID " +text);
		
		
		WebElement elementDelete = driver.findElement(By.linkText("Delete"));
		elementDelete.click();
		
		WebElement elementFindLead1 = driver.findElement(By.linkText("Find Leads"));
		elementFindLead1.click();
		
		WebElement elementFindLeadId = driver.findElement(By.name("id"));
		elementFindLeadId.sendKeys(text);
		
		WebElement elementFindLeads = driver.findElement(By.xpath("//table[@id='ext-gen242']"));
		elementFindLeads.click();
		
		
		
		
	WebElement elementDisplay = driver.findElement(By.xpath("//div[text()='No records to display']"));
	
	//WebElement elementDisplay = driver.findElement(By.linkText("No records to display"));
	String string1 = elementDisplay.getText();
	
		
	
	System.out.println(string1);
	
		if(string1.contains("No records to display"))
		{
			System.out.println("This message confirms the successful deletion");
		}
		
		else
		{
			System.out.println("The record is not deleted ");
		}
		
		driver.close();
}
}
