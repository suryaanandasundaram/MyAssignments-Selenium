package dataprovider.leaftaps;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DPMergeLeadLT extends DPBaseClassLT{
	
	@BeforeTest
	public String setfileName()
	{
		fileName="TC004-DPMergeLead";
		return fileName;
	}
	
	
	
	@Test(dataProvider="testDataLT")
public  void runDPMergeLeadLT(String uname,String pwd) throws InterruptedException {
	
	//Enter UserName and Password Using Id Locator
	WebElement elementUserName = driver.findElement(By.id("username"));
	elementUserName.sendKeys(uname);
	
	WebElement elementPassWord = driver.findElement(By.id("password"));
	elementPassWord.sendKeys(pwd);
	
	//Click on Login Button using Class Locator
	WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
	elementLogin.click();
	
	//Click on CRM/SFA Link
	WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
	elementLink.click();
	
	//Click on contacts Button
	WebElement elementContacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
	elementContacts.click();
	
	//Click on Merge Contacts using Xpath Locator
	WebElement mergeContacts = driver.findElement(By.xpath("//a[text()='Merge Contacts']"));
	mergeContacts.click();
	
	String parentwindow= driver.getWindowHandle();
	
	// Click on Widget of From Contact	
	WebElement FromContact = driver.findElement(By.xpath("//img[@alt='Lookup'][1]"));
	FromContact.click();
	
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> windowHandlesList = new ArrayList<String>(windowHandles);
	
	driver.switchTo().window(windowHandlesList.get(1));
	//Click on First Resulting Contact
	WebElement elementFrom = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a[1]"));
	elementFrom.click();
	
	driver.switchTo().window(parentwindow);
	//Click on Widget of To Contact
	WebElement ToContact = driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]"));
	Thread.sleep(2000);
	ToContact.click();
	
	Set<String> windowHandles2 = driver.getWindowHandles();
	List<String> windowHandlesList2 = new ArrayList<String>(windowHandles2);
	
	driver.switchTo().window(windowHandlesList2.get(1));
	
	//Click on Second Resulting Contact
	WebElement elementTo = driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a)[2]"));
	Thread.sleep(2000);
	elementTo.click();
	
	driver.switchTo().window(parentwindow);
	
	//Click on Merge button using Xpath Locator
	WebElement Merge = driver.findElement(By.xpath("//a[@class='buttonDangerous']"));
	Merge.click();
	
	// Accept the Alert
	Alert alert = driver.switchTo().alert();
	alert.accept();
	
	// Verify the title of the page
	String title="Merge Contacts | opentaps CRM";
	String title2 = driver.getTitle();
	if(title2.equals(title2))
	{
		System.out.println("Title of the Page "+title+" is verified");
	}
		
	
}
}
