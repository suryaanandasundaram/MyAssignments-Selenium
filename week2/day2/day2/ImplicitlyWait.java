package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWait {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	
	WebElement element1 = driver.findElement(By.linkText("Create New Account"));
	element1.click();
	
	WebElement element2 = driver.findElement(By.name("firstname"));
	element2.sendKeys("Suryaprabha");
	
	WebElement element3 = driver.findElement(By.name("lastname"));
	element3.sendKeys("Prabha");
	
}
}
