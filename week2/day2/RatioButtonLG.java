package week2.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class RatioButtonLG {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Your most favorite browser
		WebElement elementBrowser = driver.findElement(By.xpath("//label[@for='j_idt87:console1:0']"));
		elementBrowser.click();
		
		//UnSelectable
		WebElement elementCity1 = driver.findElement(By.xpath("//label[@for='j_idt87:city2:0']"));
		boolean enabled1 = elementCity1.isEnabled();
		if(enabled1)
			System.out.println("We can select First Value");
		
		WebElement elementCity2 = driver.findElement(By.xpath("//label[@for='j_idt87:city2:1']"));
		boolean enabled2 = elementCity2.isEnabled();
		if(enabled2)
			System.out.println("We can select Second Value");
		
		WebElement elementCity3 = driver.findElement(By.xpath("//label[@for='j_idt87:city2:2']"));
		boolean enabled3 = elementCity3.isEnabled();
		if(enabled3)
			System.out.println("We can select Third Value");
		
		
		//Find the default select radio button
		 WebElement elementBrowser1 = driver.findElement(By.xpath("//input[@id='j_idt87:console2:0']"));
		 WebElement elementBrowser2 = driver.findElement(By.xpath("//input[@id='j_idt87:console2:1']"));
		 WebElement elementBrowser3 = driver.findElement(By.xpath("//input[@id='j_idt87:console2:2']"));
		 WebElement elementBrowser4 = driver.findElement(By.xpath("//input[@id='j_idt87:console2:3']"));
		 
		//table[@id='j_idt87:console2']/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]
		//table[@id='j_idt87:console2']/tbody[1]/tr[1]/td[2]/div[1]/div[2]
		 
		 List<WebElement> list = new ArrayList<WebElement>();
		 list.add(elementBrowser1);
		 list.add(elementBrowser2);
		 list.add(elementBrowser3);
		 list.add(elementBrowser4);
		 
		//System.out.println(elementBrowser3.getAttribute("checked"));
		//System.out.println(elementBrowser3.getText());

		 for(WebElement l:list)
		 {
			 
			   boolean b1 = l.isSelected();
			 
			 if(b1) 
			 {
				System.out.println("Default Selected Value is "+l.getAttribute("value"));
		 }
			 }
		 
		 
		 //Select the age group (only if not selected)
		 WebElement ageGroup1 = driver.findElement(By.xpath("//input[@id='j_idt87:age:0']"));		
		 WebElement ageGroup2 = driver.findElement(By.xpath("//input[@id='j_idt87:age:1']"));
		 WebElement ageGroup3 = driver.findElement(By.xpath("//input[@id='j_idt87:age:2']"));
		
		 
		 List<WebElement> newlist = new ArrayList<WebElement>();
		 newlist.add(ageGroup1);
		 newlist.add(ageGroup2);
		 newlist.add(ageGroup3);
		 int count=0;
		 for(WebElement l:newlist)
		 {
			 boolean b = l.isSelected();
			 if(b==true)
			 { 
			   count=count+1;
			   System.out.println("Default selected Value " +l.getAttribute("value")); 
			 }
		 }
		 
		 if(count==1)
		 {   Thread.sleep(3000);
			 //ageGroup3.click();
		 }
		 
		
	}	
		
}
