package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ServiceNow {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev140943.service-now.com/now/nav/ui/classic/params/target/incident_list.do%3Fcaller_id%3Djavascript%253Ags.getUserID%2528%2529%255Eactive%253Dtrue%255Euniversal_requestISEMPTY%26sysparm_query%3Dcaller_id%253Djavascript%253Ags.getUserID%2528%2529%255Eactive%253Dtrue%255Euniversal_requestISEMPTY%255EEQ%26sysparm_view%3Dess");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement userName = driver.findElement(By.id("user_name"));
		userName.sendKeys("admin");

		WebElement passWord = driver.findElement(By.id("user_password"));
		passWord.sendKeys("i2iECB@/uG4t");

		WebElement login = driver.findElement(By.id("sysverb_login"));
		login.click();
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
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
	
	String text="INC0010019";
		
	
		shadow.setImplicitWait(20);
		WebElement search1 = shadow.findElementByXPath("//div[@class='input-group']//input");
		search1.sendKeys(text);
		Thread.sleep(1000);
		search1.sendKeys(Keys.ENTER);
		
		
		
	}
	
}
