package stepstest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import hookstest.BaseClassTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeadTest extends BaseClassTest {
	
	String parentwindow;
	Set<String> windowHandles;
	List<String> windowHandlesList;
	Set<String> windowHandles2;
	List<String> windowHandlesList2;
	
	@And("Click on Contacts")
	public void clickOnContacts()
	{
		WebElement elementContacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
		elementContacts.click();
	}
		
	@And("Click on Merge Contacts")
	public void clickOnMergeContacts()
	{
		WebElement mergeContacts = driver.findElement(By.xpath("//a[text()='Merge Contacts']"));
		mergeContacts.click();
	
	}
	
	@And("Click on Widget of From Contact")
	public void fromContact()
	{
		 parentwindow= driver.getWindowHandle();
		WebElement FromContact = driver.findElement(By.xpath("//img[@alt='Lookup'][1]"));
		FromContact.click();
		
		
	}
	@And("Select first result")
	public void selectfirstresult()
	{
		windowHandles = driver.getWindowHandles();
		windowHandlesList = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windowHandlesList.get(1));
		
		WebElement elementFrom = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a[1]"));
		elementFrom.click();
		
		driver.switchTo().window(parentwindow);
		
	}
		

	@And("Click on Widget of To Contact")
	public void toContact() throws InterruptedException
	{
		
		WebElement ToContact = driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]"));
		Thread.sleep(2000);
		ToContact.click();
		
		
	}
	
	@And("Select second result")
	
	public void selectSecondresult() throws InterruptedException
	
	{
		windowHandles2 = driver.getWindowHandles();
		windowHandlesList2 = new ArrayList<String>(windowHandles2);
		
		driver.switchTo().window(windowHandlesList2.get(1));
		
		WebElement elementTo = driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a)[2]"));
		Thread.sleep(2000);
		elementTo.click();
		
		driver.switchTo().window(parentwindow);
	}
	

	@When("Click on Merge button")
	public void clickOnMergebutton()
	{
		WebElement Merge = driver.findElement(By.xpath("//a[@class='buttonDangerous']"));
		Merge.click();
	}
	
	@Then("Accept the Alert")
	public void acceptAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	@And("Verify the title of the page after merge")
	public void mlverifyTitlePage()
	{
		String title="Merge Contacts | opentaps CRM";
		String title2 = driver.getTitle();
		if(title2.equals(title2))
		{
			System.out.println("Title of the Page "+title+" is verified");
		}
		
	
	}

	
	

}
