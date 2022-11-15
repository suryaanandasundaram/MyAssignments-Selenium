package stepssales;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {
public ChromeDriver driver;

	
	@Given("CA-Open the Chrome browser,Maximize and set the Time out")
	public void setUpBrowser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");	
		driver = new ChromeDriver(ch);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@And("CA-Load the application {string}")
	
	public void loadUrl(String url) throws InterruptedException
	{
		driver.get(url);
		Thread.sleep(1000);
	}
	
	@And("CA-Enter Username as {string}")
	public void enterUserName(String uname)
	{
		driver.findElement(By.id("username")).sendKeys(uname);
	}

	@And("CA-Enter Password as {string}")
	public void enterPassWord(String password)
	{
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("CA-Enter Login in Salesforce")
	public void enterLogin() throws InterruptedException
	{
		driver.findElement(By.id("Login")).click();
	}
	
	@And("CA-Click on toggle menu button from the left corner")
	public void click_on_toggle_menu_button_from_the_left_corner() throws InterruptedException {
	   
		WebElement appLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		appLauncher.click();
		Thread.sleep(8000);
	}

	@And("CA-Click View All and click Sales from App Launcher")
	public void click_view_all_and_click_sales_from_app_launcher() throws InterruptedException {
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		viewAll.click();
		Thread.sleep(3000);
		
		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		sales.click();
		Thread.sleep(3000);
	}
	
	@And("CA-Click on Account tab")
	public void clickOnAccount() throws InterruptedException
	{
		WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", account);
		Thread.sleep(3000);
	}
	@And("CA-Click on New button")
	public void newbutton() throws InterruptedException
	{
		WebElement newButton = driver.findElement(By.xpath("//a[@title='New']"));
		newButton.click();
		Thread.sleep(3000);
	}
	@And("CA-Enter name as {string}")
	public void enterAccountName(String account) throws InterruptedException
	{
		WebElement accountName = driver.findElement(By.xpath("//input[@name='Name']"));
		accountName.sendKeys(account);
		Thread.sleep(1000);	
	}
	@And("CA-Enter Ownership as public")
	public void eneterOwnership() throws InterruptedException
	{
		WebElement ownerShip = driver.findElement(By.xpath("//button[@aria-label='Ownership, --None--']"));
		ownerShip.click();
		Thread.sleep(3000);		
	}
	@When("CA-Click on Save")
	public void clickOnSave()
	{
	WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
	save.click();
	}
	@Then("CA-Verify newly created account name")
	public void verifymessage() {
		WebElement msg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
	    String text = msg.getText();
	    if(text.contains("was created."))
	    {
	    	System.out.println("Account was Created");
	    }
	    
	    driver.close();
	}
	
	
	
	
}
