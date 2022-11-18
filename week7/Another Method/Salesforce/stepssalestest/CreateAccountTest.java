package stepssalestest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import hookssalestest.BaseClassSalesTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccountTest extends BaseClassSalesTest {


	@And("Click View All and click Sales from App Launcher")
	public void click_view_all_and_click_sales_from_app_launcher() throws InterruptedException {
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		viewAll.click();
		Thread.sleep(3000);
		
		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		sales.click();
		Thread.sleep(3000);
	}
	
	@And("Click on Account tab")
	public void clickOnAccount() throws InterruptedException
	{
		WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", account);
		Thread.sleep(3000);
	}
	@And("Click on New button")
	public void newbutton() throws InterruptedException
	{
		WebElement newButton = driver.findElement(By.xpath("//a[@title='New']"));
		newButton.click();
		Thread.sleep(3000);
	}
	@And("Enter Account name as {string}")
	public void enterAccountName(String account) throws InterruptedException
	{
		WebElement accountName = driver.findElement(By.xpath("//input[@name='Name']"));
		accountName.sendKeys(account);
		Thread.sleep(1000);	
	}
	@And("Enter Ownership as public")
	public void eneterOwnership() throws InterruptedException
	{
		WebElement ownerShip = driver.findElement(By.xpath("//button[@aria-label='Ownership, --None--']"));
		ownerShip.click();
		Thread.sleep(3000);		
	}
	@When("Click on Save")
	public void clickOnSave()
	{
	WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
	save.click();
	}
	@Then("Verify newly created account name")
	public void verifymessage() {
		WebElement msg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
	    String text = msg.getText();
	    if(text.contains("was created."))
	    {
	    	System.out.println("Account was Created");
	    }
	
	}
	
	
	
	
}
