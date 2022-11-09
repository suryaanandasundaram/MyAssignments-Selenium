package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateOpportunity extends SalesforceBaseClass{
	@BeforeTest
	public String setData()
	{
		fileName="tc002-SalesforceOpportunity";
		return fileName;
	}
	
@Test(dataProvider="SalesforceTestdata")
	public void runCreateQuestion(String opportunityName,String amountValue) throws InterruptedException 
{
	
	Thread.sleep(6000);
	//Click on the App Launcher (dots)
	WebElement appLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
	appLauncher.click();
	Thread.sleep(6000);
	
	WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
	viewAll.click();
	
	WebElement search = driver.findElement(By.xpath("//input[@class='slds-input']"));
	search.sendKeys("Content");
	
	Thread.sleep(2000);
	
	WebElement content = driver.findElement(By.xpath("//mark[text()='Content']"));
	content.click();
	Thread.sleep(8000);
	WebElement viewAllKey = driver.findElement(By.xpath("//span[@class='viewAllLabel'][text()='View All Key Deals']"));
	viewAllKey.click();
	Thread.sleep(2000);
	
	WebElement opp = driver.findElement(By.xpath("//span[@class='triggerLinkText selectedListView slds-page-header__title slds-truncate slds-p-right--xx-small uiOutputText']"));
	opp.click();
	Thread.sleep(2000);
	
	WebElement allOpp = driver.findElement(By.xpath("(//a[@role='option'])[1]"));
	allOpp.click();
	Thread.sleep(3000);
	
	WebElement newButton = driver.findElement(By.xpath("//div[@title='New']"));
	newButton.click();
	
	
	WebElement oppName = driver.findElement(By.xpath("(//input[@class='slds-input'])[4]"));
	oppName.sendKeys(opportunityName);
	
	
	WebElement type = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]"));
	type.click();
	Thread.sleep(1000);
	WebElement newCustomer = driver.findElement(By.xpath("//span[@class='slds-truncate'][text()='New Customer']"));
	newCustomer.click();
	
	WebElement leadSource = driver.findElement(By.xpath("(//span[@class='slds-truncate'][text()='--None--'])[3]"));
	leadSource.click();
	Thread.sleep(1000);
	WebElement partner = driver.findElement(By.xpath("//span[@title='Partner Referral']"));
	partner.click();
	Thread.sleep(2000);
	
	
	WebElement amount = driver.findElement(By.xpath("//input[@name='Amount']"));
	amount.sendKeys(amountValue);
	Thread.sleep(2000);
	
	WebElement closeDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
	closeDate.click();
	Thread.sleep(1000);
	
	WebElement nextMonth = driver.findElement(By.xpath("//button[@title='Next Month']"));
	nextMonth.click();
	Thread.sleep(1000);
	WebElement date = driver.findElement(By.xpath("//span[@class='slds-day'][text()='20']"));
	date.click();
	
	WebElement stage = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]"));
	stage.click();
	Thread.sleep(1000);
	
	WebElement needAnalysis = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
	needAnalysis.click();
	
	
	WebElement primaryCS = driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[2]"));
	primaryCS.click();
	Thread.sleep(2000);
	WebElement firstOption = driver.findElement(By.xpath("(//li[@class='slds-listbox__item'])[2]"));
	firstOption.click();
	
	WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
	save.click();
	
	
	WebElement message = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
	String text = message.getText();
	System.out.println(text);
	
	if(text.contains("was created"))
	{
		System.out.println("Oppotunity was Created");
	}
	
}		
}
