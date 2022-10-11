package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentNumber2 {
	
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
	
	WebElement elementFindLead = driver.findElement(By.linkText("Find Leads"));
	elementFindLead.click();
	
	WebElement elementFirst = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]"));
	String text = elementFirst.getText();
	System.out.println(text);
	
	
	WebElement elementFirst1 = driver.findElement(By.linkText(text));
	elementFirst1.click();
	
	
	String title =driver.getTitle();
	System.out.println("The Title of the Page is  "+title);
	
	if(title.contains("Find Leads"))
	{
		System.out.println("The Title of the Page is Verified");
	}
	else
	{
		System.out.println("The Title of the Page is not Verified");
	}
	
	WebElement elementEditLead = driver.findElement(By.className("subMenuButton"));
	elementEditLead.click();
	
	WebElement elementCompanyName = driver.findElement(By.className("inputBox"));
	elementCompanyName.clear();
	elementCompanyName.sendKeys("ABCZ");
	
	WebElement elementUpdate = driver.findElement(By.name("submitButton"));
	elementUpdate.click();
	

	WebElement elementNewCompanyName = driver.findElement(By.id("viewLead_companyName_sp"));
	String text1 = elementNewCompanyName.getText();
	
	System.out.println(text1);
	
	if(text1.contains("ABCZ"))
	{
		System.out.println("The New Company Name Updated");
	}
	else
	{
		System.out.println("The New Company Name is not Updated");
	}
	
	driver.close();
	
}
}
