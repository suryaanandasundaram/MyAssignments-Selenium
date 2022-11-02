package Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromiumdriver().setup();
       //Launch Firefox / Chrome
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
	
		
		//Load https://www.redbus.in/
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Type "Chennai" in the FROM text box 
		WebElement frombox = driver.findElement(By.xpath("//input[@id='src']"));
		frombox.click();
		frombox.sendKeys("Chennai");
		WebElement from = driver.findElement(By.xpath("//input[@id='src']/../ul[@class='autoFill homeSearch']/li[2]"));
		from.click();
		// Type "Bangalore" in the TO text box
		Thread.sleep(2000);
		WebElement tobox = driver.findElement(By.xpath("//input[@id='dest']"));
		tobox.click();
		tobox.sendKeys("Bangalore");
		WebElement to = driver.findElement(By.xpath("//input[@id='dest']/../ul[@class='autoFill homeSearch']/li[2]"));
		to.click();
		// Select tomorrow's date in the Date field
		WebElement calender = driver.findElement(By.xpath("//input[@id='onward_cal']"));
		calender.click();
		
		WebElement date = driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[3]/td[5]"));
		date.click();
		
		// Click Search Buses	
		WebElement searchbuses = driver.findElement(By.id("search_btn"));
		searchbuses.click();
		//Print the number of buses shown as results (104 Buses found)
		WebElement busFound = driver.findElement(By.xpath("//span[@class='f-bold busFound']"));
		String text=busFound.getText();
		System.out.println("Buses Found "+text);
		
		
		//Choose SLEEPER in the left menu 
		WebElement sleeper = driver.findElement(By.xpath("//label[@title='SLEEPER']"));
		sleeper.click();
		
		//Print the name of the second resulting bus
		WebElement secondBus = driver.findElement(By.xpath("//ul[@class='bus-items']/div[2]/li//div[@class='column-two p-right-10 w-30 fl']/div[1]"));
		String text2 = secondBus.getText();
		System.out.println("Second BusName-- "+text2);
		
		Thread.sleep(2000);
		//Click the VIEW SEATS of that bus
		WebElement viewSeats = driver.findElement(By.xpath("//ul[@class='bus-items']/div[2]/li//div[@class='button view-seats fr']"));
		driver.executeScript("arguments[0].click();", viewSeats);
		
		//Take screenshot and close browser
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("D://Testleaf//Selenium//src//Screenshot/busscreenshot.png"));
		System.out.println("Screen shot Captured");
		
		
		
	}		
}
