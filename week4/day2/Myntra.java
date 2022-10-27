package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch =new ChromeOptions();
		
		ChromeDriver driver = new ChromeDriver(ch);
		
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action =new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath("(//div[@class='desktop-navLink']/a)[1]"));
		action.moveToElement(findElement).perform();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Jeans'][1]")).click();
		
		WebElement findElement2 = driver.findElement(By.xpath("(//label[@class='vertical-filters-label common-customCheckbox']/input)[1]"));
		driver.executeScript("arguments[0].click();",findElement2);
		
		
		
	}

}
