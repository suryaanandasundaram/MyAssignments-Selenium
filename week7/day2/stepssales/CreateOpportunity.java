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

public class CreateOpportunity {
	 public ChromeDriver driver;

	
	@Given("Open the Chrome browser,Maximize and set the Time out")
	public void setUpBrowser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");	
		driver = new ChromeDriver(ch);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		driver.findElement(By.id("username")).sendKeys(uname);
	}

	@And("Enter Password as {string}")
	public void enterPassWord(String password)
	{
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("Enter Login in Salesforce")
	public void enterLogin() throws InterruptedException
	{
		driver.findElement(By.id("Login")).click();
	}
	
	@And("Click on toggle menu button from the left corner")
	public void click_on_toggle_menu_button_from_the_left_corner() throws InterruptedException {
	   
		WebElement appLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		appLauncher.click();
		Thread.sleep(8000);
	}

	@And("Click View All and click Sales from App Launcher")
	public void click_view_all_and_click_sales_from_app_launcher() throws InterruptedException {
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		viewAll.click();
		Thread.sleep(3000);
		
		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		sales.click();
		Thread.sleep(3000);
	}

	@And("Click on Opportunity tab")
	public void click_on_opportunity_tab() throws InterruptedException {
	    
		WebElement opp = driver.findElement(By.xpath("//a[@title='Opportunities']"));
        driver.executeScript("arguments[0].click();", opp);
		Thread.sleep(4000);
		
	}

	@And("Click on New button")
	public void click_on_new_button() {
		WebElement newButton = driver.findElement(By.xpath("//div[@title='New']"));
		newButton.click();
	}

	@And("Enter Opportunity name as {string}")
	public void enter_opportunity_name_as(String opportunityName) {
		
		WebElement oppName = driver.findElement(By.xpath("(//input[@class='slds-input'])[4]"));
		oppName.sendKeys(opportunityName);
	   
	}

	@And("Choose close date as Today")
	public void choose_close_date_as_today() throws InterruptedException {
	   
		WebElement closeDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		closeDate.click();
		Thread.sleep(1000);
		WebElement today = driver.findElement(By.xpath("//button[@name='today']"));
		today.click();
	}

	@And("Select Need Analysis as {string}")
	public void select_need_analysis_as(String string) throws InterruptedException {
		WebElement stage = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]"));
		stage.click();
		Thread.sleep(1000);
		
		WebElement needAnalysis = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
		needAnalysis.click();
		
	}

	@When("Click on Save")
	public void click_on_save() {

		WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		save.click();
	}

	@Then("Verify Opportunityname")
	public void verify_opportunityname() {
		WebElement message = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String text = message.getText();
		System.out.println(text);
		
		if(text.contains("was created"))
		{
			System.out.println("Oppotunity was Created");
		}
		
		driver.close();
	}
}
