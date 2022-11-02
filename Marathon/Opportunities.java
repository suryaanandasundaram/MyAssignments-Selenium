package Marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opportunities {
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
		
		WebElement elementSales = driver.findElement(By.xpath("//div[@class='slds-app-launcher__tile-body slds-truncate']//p[text()='Sales']"));
		elementSales.click();
		Thread.sleep(5000);
		
		WebElement elementOpportunities = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();",elementOpportunities);
		
		WebElement elementNew = driver.findElement(By.xpath("//div[@title='New']"));
		elementNew.click();
		
		Thread.sleep(3000);
		WebElement elementAccountName = driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']"));
		elementAccountName.sendKeys("Suryaprabha");
		elementAccountName.click();
		
		WebElement elementName = driver.findElement(By.xpath("//li[@class='slds-listbox__item'][1]"));
		elementName.click();
		
		WebElement elementCloseDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		elementCloseDate.sendKeys("10/18/2022");
		
		WebElement elementStage = driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]"));
		driver.executeScript("arguments[0].click();",elementStage);
		
		WebElement elementNeedsAnalysis = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
		elementNeedsAnalysis.click();
		
		
		WebElement elementOppName = driver.findElement(By.xpath("//input[@name='Name']"));
		elementOppName.sendKeys("Suryaprabha");
		Thread.sleep(2000);
		
		WebElement elementSave = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		elementSave.click();
		
		
		WebElement elementMessage = driver.findElement(By.xpath("//div[@role='alertdialog']"));
		String text = elementMessage.getText();
		String message="created";
		if(text.contains(message))
		{
			System.out.println("Opportunity was Created");
		}
		else
		{
			System.out.println("Opportunity is not Created");
		}
		
		
		
	}

}
