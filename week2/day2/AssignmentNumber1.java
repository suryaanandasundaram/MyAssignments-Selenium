package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentNumber1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement element1 = driver.findElement(By.linkText("Create New Account"));
		element1.click();
		
		WebElement element2 = driver.findElement(By.name("firstname"));
		element2.sendKeys("Suryaprabha");
		
		WebElement element3 = driver.findElement(By.name("lastname"));
		element3.sendKeys("Prabha");
		
		WebElement element4 = driver.findElement(By.name("reg_email__"));
		element4.sendKeys("9092437972");
		
		WebElement element5 = driver.findElement(By.id("password_step_input"));
		element5.sendKeys("9092437972Surya@");
		
	
		
		WebElement elementDay = driver.findElement(By.id("day"));
		Select dd1 = new Select(elementDay);
		dd1.selectByVisibleText("25");
		
		WebElement elementMonth = driver.findElement(By.id("month"));
		Select dd2 = new Select(elementMonth);
		dd2.selectByVisibleText("Oct");
		
		WebElement elementYear = driver.findElement(By.id("year"));
		Select dd3 = new Select(elementYear);
		dd3.selectByValue("1989");
		
		WebElement element6 = driver.findElement(By.className("_58mt"));
		element6.click();
		
		
	}		 
}
