package Marathon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTask {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();

		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();

		// Click on toggle menu button from the left corner
		WebElement toggleButton = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		toggleButton.click();

	Thread.sleep(2000);
		WebElement viewAllButton = driver.findElement(By.xpath("//button[text()='View All']"));
		viewAllButton.click();

		Thread.sleep(3000);
		WebElement elementSearch = driver.findElement(By.xpath("//input[@class='slds-input']"));
		elementSearch.sendKeys("Task");

		Thread.sleep(3000);
		WebElement elementTask = driver.findElement(By.xpath("//a[@data-label='Tasks']"));
		driver.executeScript("arguments[0].click();", elementTask);
		
		
		Thread.sleep(3000);
		WebElement dropDown = driver.findElement(By.xpath("//a[@title='Show one more action']"));
		dropDown.click();
		
		Thread.sleep(3000);
		WebElement elementNewTask = driver.findElement(By.xpath("//div[@title='New Task']"));
		driver.executeScript("arguments[0].click();",elementNewTask);
		
		Thread.sleep(3000);
		
		WebElement elementSubject = driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']"));
		elementSubject.sendKeys("Bootcamp");
		
		WebElement elementStatus = driver.findElement(By.xpath("//a[text()='Not Started']"));
		driver.executeScript("arguments[0].click();", elementStatus);
		
		WebElement elementStatus1 = driver.findElement(By.xpath("//a[@title='Waiting on someone else']"));
		elementStatus1.click();
		
		WebElement elementSave = driver.findElement(By.xpath("//button[@title='Save']"));
		elementSave.click();
		
		
		WebElement element = driver.findElement(By.xpath("//div[@role='alertdialog']"));
		Thread.sleep(2000);
		String text = element.getText();
	    

	String message ="created";
	if(text.contains(message))
	{
		System.out.println("Task is Created");
	}
	else
	{
		System.out.println("Task is not Created");
	}

	}
		
		
		
	}

