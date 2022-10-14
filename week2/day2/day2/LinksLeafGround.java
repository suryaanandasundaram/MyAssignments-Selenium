package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksLeafGround
{
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Take me to dashboard
		WebElement dashboardLink = driver.findElement(By.xpath("//a[text()='Go to Dashboard']"));
		dashboardLink.click();
		driver.navigate().back();
		
		//Find my destination
		WebElement destinationFind = driver.findElement(By.linkText("Find the URL without clicking me."));
		String destinationURL = destinationFind.getAttribute("href");
		System.out.println("Destination URL " +destinationURL);
		
		//Am I broken link?
		WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
		brokenLink.click();
		String title = driver.getTitle();
		if(title.contains("Error 404"))
		    System.out.println("The link is broken");
		else
			System.out.println("The link is not broken");
		driver.navigate().back();
	
		//Duplicate Link
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.tagName("a"));
		int count=0;
		String url="https://www.leafground.com/dashboard.xhtml;";
		
		for(WebElement l:list)
	{
		String link1 = l.getAttribute("href");
		//System.out.println(link1);
		if(link1!=null) {
		if(link1.contains(url))
		count=count+1;
		else
		count=count+0;
	}
		
	}
		System.out.println("There are "+count+ " duplicate links in the page");	
		
		//Count Links
         WebElement link = driver.findElement(By.linkText("How many links in this page?"));
         link.click();
         List<WebElement> list1 = driver.findElements(By.tagName("a"));
         int linkCount = list1.size();
         System.out.println("Link Count "+linkCount);
         driver.navigate().back();
         
         //Count Layout Links
         WebElement linkInLayout = driver.findElement(By.linkText("How many links in this layout?"));
         linkInLayout.click();
         List<WebElement> list2 = driver.findElements(By.tagName("a"));
         int linkCount2 = list2.size();
         System.out.println("Link Count "+linkCount2);
         driver.navigate().back();
		
		
	}


}
