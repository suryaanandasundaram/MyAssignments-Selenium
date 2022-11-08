package servicenow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import io.github.sukgu.Shadow;

public class CreateIncidentServiceNow extends BaseClass {
	@Test
	public void runCreateIncident() throws InterruptedException {

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
		

		WebElement newButton = driver.findElement(By.xpath("//button[@id='sysverb_new']"));
		driver.executeScript("arguments[0].click();", newButton);

		WebElement shortDesc = driver.findElement(By.xpath("//input[@id='incident.short_description']"));
		shortDesc.sendKeys("Test_ShortDescription");
		Thread.sleep(2000);
		
		WebElement incidentNumber = driver.findElement(By.xpath("//input[@name='incident.number']"));
		String incident = incidentNumber.getAttribute("value");

		WebElement submit = driver.findElement(By.id("sysverb_insert_bottom"));
		submit.click();
		
		WebElement sort = driver.findElement(By.xpath("//a[@class='column_head list_hdrcell table-col-header'][text()='Number']/span"));
		driver.executeScript("arguments[0].click();", sort);
        Thread.sleep(2000);
		
		WebElement newlyCreatedIncident = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]"));
		String createdIncident = newlyCreatedIncident.getText();
		
		System.out.println(createdIncident);
		System.out.println(incident);

		if (incident.contains(createdIncident)) {
			System.out.println("New incident Created  " + incident);
		} else {
			System.out.println("New Incident is not Created");
		}

	}
}
