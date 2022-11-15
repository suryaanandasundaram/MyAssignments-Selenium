package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public ChromeDriver driver;

	@Given("DL-Open the Chrome browser,Maximize and set the Time out")
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@And("DL-Load the application {string}")
	public void loadUrl(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(1000);
	}

	@And("DL-Enter Username as {string}")
	public void enterUserName(String uname) {
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys("Demosalesmanager");
	}

	@And("DL-Enter Password as {string}")
	public void enterPassWord(String password) {
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys(password);
	}

	@And("DL-Enter Login")
	public void enterLogin() throws InterruptedException {
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		Thread.sleep(1000);
	}

	@And("DL-Click CRMSFA link")
	public void clickCRM() {
		WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
	}

	@And("DL-Click on Leads")
	public void clickOnLeads() {

		WebElement elementLeads = driver.findElement(By.linkText("Leads"));
		elementLeads.click();
	}
	@And("DL-Click on Find Leads")
	public void cilckOnCreateLeads() throws InterruptedException
	{
		WebElement elementFindLead = driver.findElement(By.linkText("Find Leads"));
		elementFindLead.click();
		Thread.sleep(1000);
	}
	
	@And("DL-Click on Phone")
	public void clickOnPhone()
	{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@And("DL-Enter Phonenumber as {string}")
	public void enterPhonenumber(String pnumber)
	{
		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pnumber);
	}
	@And("DL-Click on Find Leads Button")
	public void dlClickFindleadsButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}
	@And("DL-Click on the First displayed LeadID")
	public void dlClickFirstdusplayedLeadId()
	{
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@And("DL-Click on DuplicateLead Button")
	public void dlDuplicateLead()
	{
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	@When("DL-Click on CreateLead button")
	public void dlCreateLeadButton()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("DL-Verify the created lead")
	public void verifyDuplicateLead()
	{

		String actualTitle = driver.getTitle();
		
		if(actualTitle.contains("View Lead | opentaps CRM"))
		{
			System.out.println("New Lead Created");
		}
		driver.close();
	}
	
	
	
	
	
}
