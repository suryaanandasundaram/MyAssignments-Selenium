package Marathon4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class EditIncident extends BaseClass {
	
	@BeforeTest
	public void setSheetName()
	{
		filename="tc001-ServiceNow";
		sheet="EditIncident";
	}
	
	
	@Test(dataProvider="Testdata")
public void runEditIncident(String uname,String pwd,String desc) throws InterruptedException {
		
		
		
		//2. Login with valid credentials username and password 
		driver.findElement(By.id("user_name")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.id("sysverb_login")).click();
		
		
		//3. Click All
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(40);
		shadow.findElementByXPath("//div[@id='all']").click();
		
		//4.Click  Incidents in Filter navigator
		shadow.findElementByXPath("//span[text()='Incidents']").click();
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		WebElement result = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a"));
		result.click();
		Thread.sleep(1000);
		
		
		
		WebElement incidentNumber = driver.findElement(By.xpath("//input[@name='incident.number']"));
		String incident = incidentNumber.getAttribute("value");
		
		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select select1 =new Select(urgency);
		select1.selectByVisibleText("1 - High");
		
		WebElement state = driver.findElement(By.id("incident.state"));
		Select select2 =new Select(state);
		select2.selectByVisibleText("In Progress");
		
		

		WebElement eleShortDesc = driver.findElement(By.id("incident.short_description"));
		eleShortDesc.clear();
		eleShortDesc.sendKeys(desc);
		
		
		WebElement update = driver.findElement(By.id("sysverb_update_bottom"));
		update.click();
		Thread.sleep(1000);
		
		
		
	}
}
