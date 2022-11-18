package hookssalestest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassSalesTest extends AbstractTestNGCucumberTests {

public static ChromeDriver driver;

@BeforeMethod
public void beforeMethod() throws InterruptedException
{
	
	WebDriverManager.chromedriver().setup();
	ChromeOptions op =new ChromeOptions();
	op.addArguments("--disable-notifications");
	driver=new ChromeDriver(op);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.get("https://login.salesforce.com");
	Thread.sleep(1000);
	
	driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	driver.findElement(By.id("password")).sendKeys("Testleaf$321");
	driver.findElement(By.id("Login")).click();
	
	WebElement appLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
	appLauncher.click();
	Thread.sleep(8000);
}
	
@AfterMethod
public void afterMethod()
{
	driver.close();
}
	
	
	
}
