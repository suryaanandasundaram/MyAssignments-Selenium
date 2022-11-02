package Marathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class SalesforceAdministrator {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();

		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		
		//Launch Salesforce application https://login.salesforce.com/
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Login with username as "ramkumar.ramaiah@testleaf.com " and password as "Password#123"
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		
		
		//Click on Learn More link in Mobile Publisher
		
		WebElement mobilePublisher = driver.findElement(By.xpath("//span[text()='Learn More']"));
		mobilePublisher.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> listOfWindows = new ArrayList<String>(windowHandles);
	    String secondWindow = listOfWindows.get(1);
	    driver.switchTo().window(secondWindow);
	    
	    //Click confirm on Confirm redirect
	    WebElement confirm = driver.findElement(By.xpath("//button[text()='Confirm']"));
	    confirm.click();
	    Thread.sleep(1000);
	    
	    Shadow shadow = new Shadow(driver);
	    shadow.setImplicitWait(10);
	    WebElement learning = shadow.findElementByXPath("//span[text()='Learning']");
	    learning.click();
	    //Mouse hover on Learning On Trailhead
	    WebElement learningOnTrailHead = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
	    
	    Actions action =new Actions(driver);
	    action.moveToElement(learningOnTrailHead).perform();
	   
	    //Clilck on Salesforce Certifications
	    WebElement saleforceCert = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
	    saleforceCert.click();
	    //Navigate to Certification - Administrator Overview window
	    WebElement certAdmin = driver.findElement(By.xpath("//a[text()='Administrator']"));
	    certAdmin.click();
	    
	    String actualTitle = driver.getTitle();
	 String expectedTitle="Certification - Administrator";
	 if(actualTitle.contains(expectedTitle))
	 {
		 System.out.println("Navigated to Administrator Page");
	 }
	  
	 //Verify the Certifications available for Administrator Certifications should be displayed 
	 List<WebElement> list = driver.findElements(By.xpath("//div[text()='Certification']/..//div[@class='credentials-card_title']"));
	 List<String> cert = new ArrayList<String>();
	 for (WebElement webElement : list) {
		cert.add(webElement.getText());
	}
	 
	 for (String s : cert) {
		
		 System.out.println(s);
	}
		
		
		
	}
}
