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


public class CreateLead  {
    public ChromeDriver driver;
	
	@Given("Open the Chrome browser,Maximize and set the Time out")
	public void setUpBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@And("Load the application {string}")
	public void loadUrl(String url) throws InterruptedException
	{
		driver.get(url);
		Thread.sleep(1000);
	}

	@And("Enter Username as {string}")
	public void enterUserName(String uname)
	{
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys("Demosalesmanager");
	}

	@And("Enter Password as {string}")
	public void enterPassWord(String password)
	{
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys(password);
	}

	@And("Enter Login")
	public void enterLogin() throws InterruptedException
	{
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		Thread.sleep(1000);
	}

	@And("Click CRMSFA link")
	public void clickCRM()
	{
		WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
	}

	@And("Click on Leads")
	public void clickOnLeads()
	{

		WebElement elementLeads = driver.findElement(By.linkText("Leads"));
		elementLeads.click();
	}

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
@And("Close the Browser")
public void closeBrowser()
{
	driver.close();
}
	
}
