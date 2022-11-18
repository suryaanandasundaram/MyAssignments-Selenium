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

public class CreateDashboardTest extends BaseClassSalesTest {

	@And("Enter {string} and select from result list")
	public void cdEnterandSelectFrom(String value) throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("(//input[@type='search'])[3]"));
		search.sendKeys(value);
		Thread.sleep(3000);
		WebElement result = driver.findElement(By.xpath("//b[text()='Dashboards']"));
		result.click();
		Thread.sleep(3000);	
		
	}
	@And("Click on New Dashboard")
	public void cdClickOnNewDashboard() throws InterruptedException
	{
		WebElement newDashboard = driver.findElement(By.xpath("//a[@title='New Dashboard']"));
		newDashboard.click();
		Thread.sleep(2000);
	}
	@And("Enter name as {string}")
	public void cdEnterName(String dashboard) throws InterruptedException
	{
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame1);
		WebElement nameDashBoard = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
		nameDashBoard.sendKeys(dashboard);
		Thread.sleep(2000);
		
	}
	@When("Click on Create")
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
		
		
	}
	
	
	
	
}
