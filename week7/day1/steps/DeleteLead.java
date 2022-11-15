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

public class DeleteLead {
	public ChromeDriver driver;

	@Given("DeL-Open the Chrome browser,Maximize and set the Time out")
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@And("DeL-Load the application {string}")
	public void loadUrl(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(1000);
	}

	@And("DeL-Enter Username as {string}")
	public void enterUserName(String uname) {
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys("Demosalesmanager");
	}

	@And("DeL-Enter Password as {string}")
	public void enterPassWord(String password) {
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys(password);
	}

	@And("DeL-Enter Login")
	public void enterLogin() throws InterruptedException {
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		Thread.sleep(1000);
	}

	@And("DeL-Click CRMSFA link")
	public void clickCRM() {
		WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
	}
	
	@And("DeL-Click on Leads")
	public void dlclickOnLeads()
	{
		WebElement elementLeads = driver.findElement(By.linkText("Leads"));
		elementLeads.click();
	}
	
	@And("DeL-Click on Find Leads")
	public void dlClickOnfindLeads()
	{
		WebElement elementFindLead = driver.findElement(By.linkText("Find Leads"));
		elementFindLead.click();
	}
		
	@And("DeL-Click on First resulting result")
	public void dlFirstResultingResult()
	{
		WebElement elementFirst = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]"));
		String text = elementFirst.getText();
		System.out.println(text);
		
		WebElement elementFirst1=driver.findElement(By.linkText(text));
		
		elementFirst1.click();
		System.out.println("The First Resulting lead ID " +text);
	}
		
	@When("DeL-Click on delete")
	public void clickOndelete()
	{
		WebElement elementDelete = driver.findElement(By.linkText("Delete"));
		elementDelete.click();
		
		WebElement elementFindLead1 = driver.findElement(By.linkText("Find Leads"));
		elementFindLead1.click();
			
	}
	
	@Then("DeL-Verify the title of the page")
	public void dlVerifyTitle()
	{
		String title = driver.getTitle();
		if(title.contains("My Leads | opentaps CRM"))
		{
			System.out.println("Deleted successfully");
		}	
		
		driver.close();
	}
	

}
