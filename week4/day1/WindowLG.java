package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowLG {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("https://leafground.com/window.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//Click and Confirm new Window Opens
    String parentWindow = driver.getWindowHandle();
    
    WebElement elementOpen = driver.findElement(By.xpath("//button[contains(@class,'ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only mr-2 mb-2')]"));
    elementOpen.click();
    Set<String> windowHandles = driver.getWindowHandles();
    List<String> windowHandlesList = new ArrayList<String>(windowHandles);
    driver.switchTo().window(windowHandlesList.get(1));
    String title="Window";
    if(title.contains("Window"))
    {
    System.out.println("Title of the Page " +title);
    }
    driver.close();
    driver.switchTo().window(parentWindow);
    
    //Find the number of opened tabs
    WebElement elementOpenMultiple = driver.findElement(By.xpath("//span[text()='Open Multiple']"));
    elementOpenMultiple.click();
    Set<String> windowHandles2 = driver.getWindowHandles();
    int size = windowHandles2.size();
    int noOfOpenedWindows =size-1;
    System.out.println("No of Opened Windows "+noOfOpenedWindows );
    
    for (String string : windowHandles2) {
		
    	if(!string.equals(parentWindow))
    	{
    	driver.switchTo().window(string);
    	driver.close();
    	}
	}
    driver.switchTo().window(parentWindow);
   //Close all windows except Primary
    
    Thread.sleep(3000);
    WebElement CloseWindows = driver.findElement(By.xpath("//span[text()='Close Windows']"));
    CloseWindows.click();
    Set<String> windowHandles3 = driver.getWindowHandles();     
    for (String string : windowHandles3) {
		
    	if(!string.equals(parentWindow))
    	{
    	driver.switchTo().window(string);
    	driver.close();
    	} 	
	}
    
    Set<String> windowHandles5 = driver.getWindowHandles();
    int size3 = windowHandles5.size();
    if(size3==1)
    {
    System.out.println("Closed all Windows Except Primary");
    }
    driver.switchTo().window(parentWindow);
    
   // Wait for 2 new tabs to open
    WebElement OpenWithDelay = driver.findElement(By.xpath("//span[text()='Open with delay']"));
    OpenWithDelay.click();
    Thread.sleep(3000);
    Set<String> windowHandles4 = driver.getWindowHandles();     
    int size2 = windowHandles4.size();
    int noOfOpenedWindows2 =size2-1;
    System.out.println("No of Opened Windows "+noOfOpenedWindows2 );
    
    for (String string : windowHandles4) {
		
    	if(!string.equals(parentWindow))
    	{
    	driver.switchTo().window(string);
    	driver.close();
    	}
	}
    driver.switchTo().window(parentWindow);
    	
}
}
