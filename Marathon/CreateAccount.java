package Marathon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromiumdriver().setup();
	
	ChromeOptions ch=new ChromeOptions();
	ch.addArguments("--disable-notifications");
	ChromeDriver driver =new ChromeDriver(ch);
	driver.get("https://login.salesforce.com/?locale=in");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Password#123");
	driver.findElement(By.id("Login")).click();
	
	//Click on toggle menu button from the left corner
	WebElement toggleButton =driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
	toggleButton.click();
	
	
	WebElement viewAllButton=driver.findElement(By.xpath("//button[text()='View All']"));
	viewAllButton.click();
	
	//driver.switchTo().frame(0);
	WebElement elementSales = driver.findElement(By.xpath("//div[@class='slds-app-launcher__tile-body slds-truncate']//p[text()='Sales']"));
	elementSales.click();
	Thread.sleep(5000);
	WebElement elementAccount = driver.findElement(By.xpath("//a[@title='Accounts']"));
	driver.executeScript("arguments[0].click();",elementAccount);
	
	WebElement elementNew = driver.findElement(By.xpath("//div[@title='New']"));
	elementNew.click();
	Thread.sleep(5000);
	
	WebElement elementAccountName = driver.findElement(By.xpath("//input[@name='Name']"));
	elementAccountName.sendKeys("Suryaprabha");
	
	WebElement elementOwnership = driver.findElement(By.xpath("//button[@aria-label=\"Ownership, --None--\"]"));
	driver.executeScript("arguments[0].click();",elementOwnership);
	Thread.sleep(5000);
	WebElement elementPublic = driver.findElement(By.xpath("//span[@title='Public']"));
	elementPublic.click();
	
	WebElement elementSave = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
	elementSave.click();
	
	
	WebElement element = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
	Thread.sleep(2000);
	String text = element.getText();
    System.out.println(text);

String message ="created";
if(text.contains(message))
{
	System.out.println("Account was Created");
}
else
{
	System.out.println("Account is not Created");
}

}
}
