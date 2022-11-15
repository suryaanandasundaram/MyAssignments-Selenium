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

public class CreateDashboard {

	 public ChromeDriver driver;
	@Given("CD-Open the Chrome browser,Maximize and set the Time out")
	public void cdbrowserSetup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");	
		driver = new ChromeDriver(ch);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@And("CD-Load the application {string}")
	public void cdloadurl(String url) throws InterruptedException
	{
		driver.get(url);
		Thread.sleep(1000);
	}
	@And("CD-Enter Username as {string}")
	public void cdenterUsername(String uname)
	{
		driver.findElement(By.id("username")).sendKeys(uname);
	}
	@And("CD-Enter Password as {string}")
	public void cdenterPassword(String pword)
	{
		driver.findElement(By.id("password")).sendKeys(pword);
	}
	@And("CD-Enter Login in Salesforce")
	public void cdEnterLogin() throws InterruptedException
	{
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
	}
	
	@And("CD-Click on toggle menu button from the left corner")
	public void cdClickOnToggle() throws InterruptedException
	{
		WebElement appLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		appLauncher.click();
		Thread.sleep(8000);
	}
	@And("CD-Enter {string} and select from result list")
	public void cdEnterandSelectFrom(String value) throws InterruptedException
	{
		
		WebElement search = driver.findElement(By.xpath("(//input[@type='search'])[3]"));
		search.sendKeys(value);
		Thread.sleep(3000);
		WebElement result = driver.findElement(By.xpath("//b[text()='Dashboards']"));
		result.click();
		Thread.sleep(3000);	
		
	}
	@And("CD-Click on New Dashboard")
	public void cdClickOnNewDashboard() throws InterruptedException
	{
		WebElement newDashboard = driver.findElement(By.xpath("//a[@title='New Dashboard']"));
		newDashboard.click();
		Thread.sleep(2000);
	}
	@And("CD-Enter name as {string}")
	public void cdEnterName(String dashboard) throws InterruptedException
	{
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame1);
		WebElement nameDashBoard = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
		nameDashBoard.sendKeys(dashboard);
		Thread.sleep(2000);
		
	}
	@When("CD-Click on Create")
	public void cdClickOnCreate()
	{
		
		WebElement create = driver.findElement(By.id("submitBtn"));
		create.click();
		
	}
	
	@Then("Verify newly created Dashboard name")
	public void cdNewlyCreatedDashboardName()
	{
		WebElement dashboardName = driver.findElement(By.xpath("//span[@class='slds-form-element__static slds-grid slds-grid_align-spread']"));
		String text = dashboardName.getText();
		System.out.println(text);
		
		driver.close();
	}
	
	
	
	
}
