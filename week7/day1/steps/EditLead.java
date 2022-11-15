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

public class EditLead {

	public ChromeDriver driver;

	@Given("EL-Open the Chrome browser,Maximize and set the Time out")
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@And("EL-Load the application {string}")
	public void loadUrl(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(1000);
	}

	@And("EL-Enter Username as {string}")
	public void enterUserName(String uname) {
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys("Demosalesmanager");
	}

	@And("EL-Enter Password as {string}")
	public void enterPassWord(String password) {
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys(password);
	}

	@And("EL-Enter Login")
	public void enterLogin() throws InterruptedException {
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		Thread.sleep(1000);
	}

	@And("EL-Click CRMSFA link")
	public void clickCRM() {
		WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
	}

	@And("EL-Click on Leads")
	public void clickOnLeads() {

		WebElement elementLeads = driver.findElement(By.linkText("Leads"));
		elementLeads.click();
	}
	
	@And("EL-Click on Find Leads")
	public void cilckOnCreateLeads() throws InterruptedException
	{
		WebElement elementFindLead = driver.findElement(By.linkText("Find Leads"));
		elementFindLead.click();
		Thread.sleep(1000);
	}
	
	
	@And("EL-Click on the First displayed LeadID")
	public void clickOnFirstDisplayedLeadID()
	{
		WebElement elementFirst = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
	String text = elementFirst.getText();
		System.out.println(text);
		
		WebElement elementFirst1 = driver.findElement(By.linkText(text));
		elementFirst1.click();
	}
	
	@And("EL-Click on Edit Button")
	public void clickOnEditButton()
	{

		WebElement elementEditLead = driver.findElement(By.className("subMenuButton"));
		elementEditLead.click();
	}
	
	@And("EL-Update Company Name as {string}")
	public void updateCompanyName(String cname)
	{
		WebElement elementCompanyName = driver.findElement(By.className("inputBox"));
		elementCompanyName.clear();
		elementCompanyName.sendKeys(cname);
	}
	
	@When("EL-Click on Update Button")
	public void clickOnUpdateButton()
	{
		WebElement elementUpdate = driver.findElement(By.name("submitButton"));
		elementUpdate.click();
	}
	
	@Then("EL-Verify the updated company name")
	public void verifyUpdatedCompanyName()
	{
		WebElement elementNewCompanyName = driver.findElement(By.id("viewLead_companyName_sp"));
		String text1 = elementNewCompanyName.getText();
		
		System.out.println(text1);
		
		driver.close();
	}
	

}
