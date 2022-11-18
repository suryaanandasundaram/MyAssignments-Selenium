package stepstest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import hookstest.BaseClassTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;




public class EditLeadTest extends BaseClassTest {
	
	@And("Click on Edit Button")
	public void clickOnEditButton()
	{

		WebElement elementEditLead = driver.findElement(By.className("subMenuButton"));
		elementEditLead.click();
	}
	
	@And("Update Company Name as {string}")
	public void updateCompanyName(String cname)
	{
		WebElement elementCompanyName = driver.findElement(By.className("inputBox"));
		elementCompanyName.clear();
		elementCompanyName.sendKeys(cname);
	}
	
	@When("Click on Update Button")
	public void clickOnUpdateButton()
	{
		WebElement elementUpdate = driver.findElement(By.name("submitButton"));
		elementUpdate.click();
	}
	
	@Then("Verify the updated company name")
	public void verifyUpdatedCompanyName()
	{
		WebElement elementNewCompanyName = driver.findElement(By.id("viewLead_companyName_sp"));
		String text1 = elementNewCompanyName.getText();
		
		System.out.println(text1);
	
	}
	

}
