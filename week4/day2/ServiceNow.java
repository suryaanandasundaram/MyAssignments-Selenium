package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://dev141516.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("India@123");
		
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		
		WebElement findElement = driver.findElement(By.xpath("//input[@id='filter']"));
		findElement.sendKeys("Incident",Keys.ENTER);
		
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		
		
		
	}

}
