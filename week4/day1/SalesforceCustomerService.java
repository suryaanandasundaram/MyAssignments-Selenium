package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceCustomerService {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	
	ChromeOptions op=new ChromeOptions();
	op.addArguments("--disable-notifications");
	
	//Launch the browser
	ChromeDriver driver = new ChromeDriver(op);
	
	//Load the url as https://login.salesforce.com/
	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//Enter the username as ramkumar.ramaiah@testleaf.com
	driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
	
	//Enter the password as Password#123
	driver.findElement(By.id("password")).sendKeys("Password#123");
	
	//click on the login button
	driver.findElement(By.id("Login")).click();
	
	String parentwindow = driver.getWindowHandle();
	Thread.sleep(3000);
	////click on the learn more option in the Mobile publisher
	WebElement learnMore = driver.findElement(By.xpath("//span[text()='Learn More']"));
	learnMore.click();
	
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> list =new ArrayList<String>(windowHandles);
	String secondWindow = list.get(1);
	
	//Switch to the next window using Windowhandles.
	driver.switchTo().window(secondWindow);
	
	//click on the confirm button in the redirecting page
	driver.findElement(By.xpath("//button[text()='Confirm']")).click();
	
	//Get the title
	String title = driver.getTitle();
	System.out.println("Title of the Redirected Page :"+title);
	
	//Get back to the parent window
	driver.switchTo().window(parentwindow);
	//close the browser
	driver.quit();
		
}
}
