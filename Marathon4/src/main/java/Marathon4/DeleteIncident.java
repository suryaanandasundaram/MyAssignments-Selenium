package Marathon4;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
public class DeleteIncident extends BaseClass
{
	@BeforeTest
	public void setSheetName()
	{
		filename="tc001-ServiceNow";
		sheet="DeleteIncident";
	}
		
	@Test(dataProvider="Testdata")
	public void runDeleteIncident(String uname,String pwd) throws InterruptedException {

	
		
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
		
		//5. Delete the incident
		shadow.findElementByXPath("//button[text()='Delete']").click();
		driver.findElement(By.id("ok_button")).click();
		
		
		//6. Verify the deleted incident

	}
}
