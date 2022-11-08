package dataprovider.servicenow;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.sukgu.Shadow;

public class DPUpdateIncidentServiceNow extends DPServiceNowBaseClass {
	
	@BeforeTest
	public String setDPCreateIncident()
	{
		fileName="TC002-UpdateIncident";
		return fileName;
	}
	
	
	@Test(dataProvider= "servicenowTestData")
	public void runDPUpdateIncident(String uname,String pwd,String filtervalue,String incidentNumberValue, String urgencyValue,String stateValue) throws InterruptedException {

		
		WebElement userName = driver.findElement(By.id("user_name"));
		userName.sendKeys(uname);

		WebElement passWord = driver.findElement(By.id("user_password"));
		passWord.sendKeys(pwd);
		
		
		WebElement login = driver.findElement(By.id("sysverb_login"));
		login.click();

		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(30);
		WebElement all = shadow.findElementByXPath("//div[text()='All']");
		all.click();
		Actions action =new Actions(driver);

		WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
		action.moveToElement(filter);
		action.click();
		filter.sendKeys(filtervalue);
		Thread.sleep(500);
		filter.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement findElementByXPath = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(findElementByXPath);
		
		WebElement search2 = driver.findElement(By.xpath("(//input[@class='form-control'][1])[1]"));
		search2.sendKeys(incidentNumberValue);	
		Thread.sleep(500);
		search2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
				
		WebElement result = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a"));
		result.click();
		Thread.sleep(1000);
		
		WebElement incidentNumber = driver.findElement(By.xpath("//input[@name='incident.number']"));
		String incident = incidentNumber.getAttribute("value");
		
		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select select1 =new Select(urgency);
		select1.selectByVisibleText(urgencyValue);
		
		WebElement state = driver.findElement(By.id("incident.state"));
		Select select2 =new Select(state);
		select2.selectByVisibleText(stateValue);
		
		WebElement update = driver.findElement(By.id("sysverb_update_bottom"));
		update.click();
		Thread.sleep(1000);
		
		
		WebElement search3 = driver.findElement(By.xpath("//input[@class='form-control'][1]"));
		search3.sendKeys(incident);
		Thread.sleep(500);
		search3.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		WebElement result2 = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a"));
		result2.click();
		Thread.sleep(1000);
		
		WebElement updatedstate = driver.findElement(By.xpath("(//ul[@class='sn-widget-list sn-widget-list-table']/li[1]/span[2]/span[1])[1]"));
		String textState = updatedstate.getText();
		System.out.println("State "+textState);
		
		WebElement updatedpriority = driver.findElement(By.xpath("(//ul[@class='sn-widget-list sn-widget-list-table']/li[2]/span[2]/span[1])[1]"));
		String textPriority = updatedpriority.getText();
		System.out.println("Priority "+textPriority);
		
		
		
	}

}
