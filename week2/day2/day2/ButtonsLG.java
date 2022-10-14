package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonsLG {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.leafground.com/button.xhtml;jsessionid=node01uwse2e3mjhu41g6ob84cjmhcy363172.node0");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement element1 = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
		element1.click();
		
		String title =driver.getTitle();
		System.out.println("The Title of the Page is "+title);
		
		if(title.contains("Dashboard"))
		{
			System.out.println("The Title of the Page is Verified");
		}
		else
		{
			System.out.println("The Title of the Page is not Verified");
		}
		
		//Confirm if the button is disabled.
	    driver.navigate().back();
		WebElement element2 = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt92']"));
		boolean enabled = element2.isEnabled();
		
		if(enabled)
		System.out.println("Enabled");
		else
		System.out.println("Disabled");
	
		
		//Find the position of the Submit button
		WebElement element3 = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt94']"));
		Point location = element3.getLocation();
		System.out.println("Position of the Submit button" +location);
		
		//Find the Save button color
		WebElement element4 = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));
		String cssValue = element4.getCssValue("color");
		System.out.println(cssValue);
		
		
		//Find the height and width of this button
		 WebElement element5 = driver.findElement(By.xpath("(//span[text()='Submit'])[2]"));
		 int height = element5.getSize().getHeight();
		 int width = element5.getSize().getWidth();
		 System.out.println("Height "+height);
		 System.out.println("width "+width);
		
		 //Mouse over and confirm the color changed
		 WebElement element6 = driver.findElement(By.xpath("//span[text()='Success']"));
		 String cssValue1 = element6.getCssValue("background-color");
		 Actions act =new Actions(driver);
		 act.moveToElement(element6);
		 String cssValue2 = element6.getCssValue("background-color");
		 if(cssValue1!=cssValue2)
			 System.out.println("color changed");
		 
	    //Click Image Button and Click on any hidden button
		 WebElement element7 = driver.findElement(By.xpath("//span[text()='Image']"));
		 element7.click();
		 
		 Thread.sleep(1000);
		 WebElement element8 = driver.findElement(By.xpath("//span[text()='Image']"));
		 element8.click();
		 WebElement elementImage = driver.findElement(By.xpath("//img[@id='j_idt88:j_idt102:j_idt104']"));
		 boolean displayed = elementImage.isDisplayed();
		 if(displayed)
			 System.out.println("The Image displayed");
		 element8.click();
		 
		 
		 //How many rounded buttons are there?
		// WebElement element10 = driver.findElement(By.xpath("//div[@class='card ui-fluid']/following-sibling::div[1]"));



	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	}
}
