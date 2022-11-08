package dataprovider.leaftaps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DPEditLeadLT extends DPBaseClassLT{
	
	@BeforeTest
	public String setfileName()
	{
		fileName="TC002-DPEditLead";
		return fileName;
	}
	
	
	
	@Test(dataProvider="testDataLT")
	public void runDPEditLeadLT(String uname,String pwd,String cname) throws InterruptedException {
	
	
	WebElement elementUserName = driver.findElement(By.id("username"));
	elementUserName.sendKeys(uname);
	
	WebElement elementPassWord = driver.findElement(By.id("password"));
	elementPassWord.sendKeys(pwd);
	
	WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
	elementLogin.click();
	
	WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
	elementLink.click();
	
	WebElement elementLeads = driver.findElement(By.linkText("Leads"));
	elementLeads.click();
	
	WebElement elementFindLead = driver.findElement(By.linkText("Find Leads"));
	elementFindLead.click();
	
	WebElement elementFirst = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
	String text = elementFirst.getText();
	System.out.println(text);
	
	
	WebElement elementFirst1 = driver.findElement(By.linkText(text));
	elementFirst1.click();
	
	
	String title =driver.getTitle();
	System.out.println("The Title of the Page is  "+title);
	
	if(title.contains("Find Leads"))
	{
		System.out.println("The Title of the Page is Verified");
	}
	else
	{
		System.out.println("The Title of the Page is not Verified");
	}
	
	WebElement elementEditLead = driver.findElement(By.xpath("//a[text()='Edit']"));
	elementEditLead.click();
	
	WebElement elementCompanyName = driver.findElement(By.className("inputBox"));
	elementCompanyName.clear();
	elementCompanyName.sendKeys(cname);
	
	WebElement elementUpdate = driver.findElement(By.name("submitButton"));
	elementUpdate.click();
	
   
	
	
}
}
