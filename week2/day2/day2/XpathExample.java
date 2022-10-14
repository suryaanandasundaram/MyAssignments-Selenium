package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathExample {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		WebElement elementUserName = driver.findElement(By.xpath("//input[@id='username']"));
		elementUserName.sendKeys("Demosalesmanager");
		
		WebElement elementPassWord = driver.findElement(By.xpath("//input[contains(@name,'PASS')]"));
		elementPassWord.sendKeys("crmsfa");
		
		WebElement elementLogin = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		elementLogin.click();
		
		WebElement elementLink = driver.findElement(By.xpath("//a[contains(text( ),'CRM/SFA')]"));
		elementLink.click();
		
}
}
