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

public class SalesforceArchitect {
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
	    
	    WebElement learningOnTrailHead = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
	    
	    Actions action =new Actions(driver);
	    action.moveToElement(learningOnTrailHead).perform();
	    
	  //Clilck on Salesforce Certifications
	    WebElement saleforceCert = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
	    saleforceCert.click();
	    
	    Thread.sleep(2000);
	    //Choose Your Role as Salesforce Architect
	    WebElement salesforceArchitect = driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]"));
	    driver.executeScript("arguments[0].click();", salesforceArchitect);
	    
	   //Get the Text(Summary) of Salesforce Architect 
	    System.out.println("Text(Summary) of Salesforce Architect ");
	    System.out.println("****************************************");
	    WebElement summary = driver.findElement(By.xpath("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']"));    
	    System.out.println(summary.getText());
	    
	    //Get the List of Salesforce Architect Certifications Available
	    List<WebElement> certList = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
	    
	    
	    System.out.println("\n****************************************");
	    System.out.println("List of Salesforce Architect Certifications Available");
	    for (WebElement webElement : certList) {
			
	    	String text =webElement.getText();
	    	System.out.println(text);
		}
	    
	    
	    //Click on Application Architect 
	   WebElement appArchitect = driver.findElement(By.xpath("//div[@class='credentials-card_title']/a[text()='Application Architect']")) ;
	   appArchitect.click();
	  
	    
	   //Get the List of Certifications available
	   List<WebElement> certAvailable = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
	   
	   
	   System.out.println("****************************************");
	    System.out.println("List of Certifications available");
	   for (WebElement webElement : certAvailable) {
			
	    	String text =webElement.getText();
	    	System.out.println(text);
		}
	
	}
}
