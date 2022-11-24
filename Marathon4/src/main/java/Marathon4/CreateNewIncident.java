package Marathon4;


	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
	import io.github.sukgu.Shadow;

	public class CreateNewIncident extends BaseClass {
		
		@BeforeTest
		public void setSheetName()
		{
			filename="tc001-ServiceNow";
			sheet="CreateIncident";
		}
		
		@Test(dataProvider ="Testdata")
		public void runCreateIncident(String uname,String pwd,String desc) throws InterruptedException {
			

			//2. Login with valid credentials username and password 
			//   Create your own credentials
			driver.findElement(By.id("user_name")).sendKeys(uname);
			driver.findElement(By.id("user_password")).sendKeys(pwd);
			driver.findElement(By.id("sysverb_login")).click();

			//3. Click All
			Shadow shadow = new Shadow(driver);
			shadow.setImplicitWait(40);
			WebElement all = shadow.findElementByXPath("//div[text()='All']");
			all.click();
			
			
			//4.Click  Incidents in Filter navigator
			shadow.findElementByXPath("//span[text()='Incidents']").click();
			
			//5. Click on Create new option and fill the mandatory fields
			WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
			driver.switchTo().frame(eleFrame);
			driver.findElement(By.xpath("//button[text()='New']")).click();
			String text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");

			System.out.println("Inident Number "+text2);
			driver.findElement(By.id("incident.short_description")).sendKeys(desc);
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			driver.switchTo().defaultContent();

			//6. Verify the newly created incident by getting the incident number and put it in search field and 
			//   enter then verify the instance number created or not

			WebElement eleFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
			driver.switchTo().frame(eleFrame2);
			WebElement numberDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
			Select numberDD=new Select(numberDropDown);
			numberDD.selectByVisibleText("Number");
			driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
			driver.switchTo().defaultContent();
			
			//// Confirm incident exists !
			driver.switchTo().frame(eleFrame2);
			String text = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
			System.out.println(text); 

		}
	
}
