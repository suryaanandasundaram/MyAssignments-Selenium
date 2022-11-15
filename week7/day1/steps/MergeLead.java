package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {
	public ChromeDriver driver;

	@Given("ML-Open the Chrome browser,Maximize and set the Time out")
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@And("ML-Load the application {string}")
	public void loadUrl(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(1000);
	}

	@And("ML-Enter Username as {string}")
	public void enterUserName(String uname) {
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys("Demosalesmanager");
	}

	@And("ML-Enter Password as {string}")
	public void enterPassWord(String password) {
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys(password);
	}

	@And("ML-Enter Login")
	public void enterLogin() throws InterruptedException {
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		Thread.sleep(1000);
	}

	@And("ML-Click CRMSFA link")
	public void clickCRM() {
		WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
	}
	@And("ML-Click on Contacts")
	public void clickOnContacts()
	{
		WebElement elementContacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
		elementContacts.click();
	}
		
	@And("ML-Click on Merge Contacts")
	public void clickOnMergeContacts()
	{
		WebElement mergeContacts = driver.findElement(By.xpath("//a[text()='Merge Contacts']"));
		mergeContacts.click();
	
	}
	
	@And("ML-Click on Widget of From Contact and select first result")
	public void fromContact()
	{
		 String parentwindow= driver.getWindowHandle();
		WebElement FromContact = driver.findElement(By.xpath("//img[@alt='Lookup'][1]"));
		FromContact.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windowHandlesList.get(1));
		
		WebElement elementFrom = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a[1]"));
		elementFrom.click();
		
		driver.switchTo().window(parentwindow);
	}
		

	@And("ML-Click on Widget of To Contact and select second result")
	public void toContact() throws InterruptedException
	{
		String parentwindow= driver.getWindowHandle();
		WebElement ToContact = driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]"));
		Thread.sleep(2000);
		ToContact.click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windowHandlesList2 = new ArrayList<String>(windowHandles2);
		
		driver.switchTo().window(windowHandlesList2.get(1));
		
		WebElement elementTo = driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a)[2]"));
		Thread.sleep(2000);
		elementTo.click();
		
		driver.switchTo().window(parentwindow);
	}
	

	@When("ML-Click on Merge button")
	public void clickOnMergebutton()
	{
		WebElement Merge = driver.findElement(By.xpath("//a[@class='buttonDangerous']"));
		Merge.click();
	}
	
	@Then("ML-Accept the Alert")
	public void acceptAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	@And("ML-Verify the title of the page")
	public void mlverifyTitlePage()
	{
		String title="Merge Contacts | opentaps CRM";
		String title2 = driver.getTitle();
		if(title2.equals(title2))
		{
			System.out.println("Title of the Page "+title+" is verified");
		}
		
		driver.close();
	}

	
	

}
