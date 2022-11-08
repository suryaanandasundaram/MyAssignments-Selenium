package servicenow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class DeleteIncidentServiceNow extends BaseClass{
	@Test
	public  void runDeleteIncident() throws InterruptedException {

	
		WebElement userName = driver.findElement(By.id("user_name"));
		userName.sendKeys("admin");

		WebElement passWord = driver.findElement(By.id("user_password"));
		passWord.sendKeys("i2iECB@/uG4t");
		
		
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
		filter.sendKeys("Incident");
		Thread.sleep(500);
		filter.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		WebElement findElementByXPath = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(findElementByXPath);
		
		WebElement result = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a"));
		result.click();
		Thread.sleep(1000);
		
		WebElement incidentNumber = driver.findElement(By.xpath("//input[@name='incident.number']"));
		String incident = incidentNumber.getAttribute("value");
		System.out.println(incident);
		
		WebElement delete = driver.findElement(By.id("sysverb_delete"));
		delete.click();
		Thread.sleep(1000);
		
		WebElement confirmDelete = driver.findElement(By.id("ok_button"));
		confirmDelete.click();
		Thread.sleep(3000);
		
		WebElement search2 = driver.findElement(By.xpath("(//input[@class='form-control'][1])[1]"));
		search2.sendKeys(incident);	
		Thread.sleep(500);
		search2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		
		WebElement element = driver.findElement(By.xpath("//div[@class='list2_empty-state-list']"));
		String text = element.getText();
		System.out.println(text);
		
		if(text.contains("No records"))
		{
			System.out.println("Record deleted successfully");
		}
		
		
		
	}
}
