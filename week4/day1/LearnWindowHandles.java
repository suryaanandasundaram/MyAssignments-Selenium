package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandles {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(op);
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.partialLinkText("FLIGHTS")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> listwindowHandles = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(listwindowHandles.get(1));
		String titleofSecondWindow = driver.getTitle();
		System.out.println("Title of Second window");
		System.out.println(titleofSecondWindow);
		driver.close();
		
		
		driver.switchTo().window(listwindowHandles.get(0));
		String titleofFirstWindow = driver.getTitle();
		System.out.println("Title of First window");
		System.out.println(titleofFirstWindow);
		
	}		
}
