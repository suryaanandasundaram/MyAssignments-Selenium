package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement stationFrom = driver.findElement(By.id("txtStationFrom"));
		stationFrom.clear();
		stationFrom.sendKeys("ms");
		stationFrom.sendKeys(Keys.ENTER);
		

		WebElement stationTo = driver.findElement(By.id("txtStationTo"));
		stationTo.clear();
		stationTo.sendKeys("mdu");
		stationTo.sendKeys(Keys.ENTER);
		
 WebElement sortOnDate = driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']"));
 sortOnDate.click();
 Thread.sleep(2000);
 List<WebElement> trainNames = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr/td[2]"));
 int size = trainNames.size();
 
 List<String> trainNameslist = new ArrayList<String>();
 
 
 for(int i=2;i<=size;i++)
 {
	 String text = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr["+i+"]/td[2]")).getText();
	// System.out.println(text);
	 trainNameslist.add(text);
	  
 }
 
 Set<String> trainNamesset =new LinkedHashSet<String>();;
 
 for(String ch:trainNameslist)
 {
	Boolean b= trainNamesset.add(ch);
	if(!b)
	{
		System.out.println(ch);
	}
 }
 
 int size2 = trainNameslist.size();
 int size3 = trainNamesset.size();
 
// System.out.println(size2);
// System.out.println(size3);
 
 if(size2==size3)
 {
	 System.out.println("No Duplicates");
 }
 
		
		
	}

}
