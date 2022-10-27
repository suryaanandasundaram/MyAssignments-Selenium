package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Launch https://www.snapdeal.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions action =new Actions(driver);
		//Go to Mens Fashion
		WebElement element = driver.findElement(By.xpath("//span[@class='catText'][1]"));
		action.moveToElement(element).perform();
		//Go to Sports Shoes
		WebElement sportsShoe = driver.findElement(By.xpath("//span[text()='Sports Shoes'][1]"));
		sportsShoe.click();
		
		//Get the count of the sports shoes
		WebElement count = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		String text2 = count.getText();
		
		System.out.println("The Count of Shoes "+text2);
		
		//Click Training shoes
		WebElement trainingShoes = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		trainingShoes.click();
		//Sort by Low to High
		WebElement sortBy = driver.findElement(By.xpath("//div[@class='sort-selected']"));
		sortBy.click();
		
		Thread.sleep(2000);
		WebElement lowToHigh = driver.findElement(By.xpath("//li[@class='search-li'][1]"));
		lowToHigh.click();
		Thread.sleep(2000);
		
		List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	   //Check if the items displayed are sorted correctly
		
		List<String> priceValues = new ArrayList<String>();
		for (WebElement webElement : findElements) {
			Thread.sleep(2000);
			String value= (webElement.getAttribute("data-price"));
			System.out.println(value);
			priceValues.add(value);
						
		}
		boolean flag=false;
		 
		 for(int i=1;i<priceValues.size();i++)
		 {
			 String pre=priceValues.get(i-1);
			 String current =priceValues.get(i);
			 
			 int pre1 = Integer.parseInt(pre);
			 int current1 =Integer.parseInt(current);
			 
			 if(current1>=pre1)
			 {
				 flag=true;
			 }		 
		 }
		
		 if(flag)
		 {
			 System.out.println("Filter-applied correctly");
		 }
		 else
		 {   System.out.println("Filter not applied");
			 
		 }
			
		//Select the price range (900-1200)
		WebElement fromValue = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromValue.clear();
		fromValue.sendKeys("600");
		WebElement toValue = driver.findElement(By.xpath("//input[@name='toVal']"));
		toValue.clear();
		toValue.sendKeys("1200");
		Thread.sleep(2000);
		WebElement go = driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']"));
		go.click();
		Thread.sleep(4000);
		
		
		//Filter with color Navy 
		WebElement colorFilter = driver.findElement(By.xpath("//label[@for='Color_s-Navy']"));
		colorFilter.click();
		//verify the all applied filters 
		
		for(int i=1;i<=2;i++)
		{
			String text = driver.findElement(By.xpath("(//div[contains(@class,'navFiltersPill')]/a)["+i+"]")).getText();
			System.out.println(text);
			Thread.sleep(2000);
		
		}
		 
		//Mouse Hover on first resulting Training shoes
		 WebElement firstResultingShoe = driver.findElement(By.xpath("//div[@class='col-xs-6 last-no-border  favDp product-tuple-listing js-tuple ']"));
		action.moveToElement(firstResultingShoe).perform();
		//click QuickView button
		Thread.sleep(3000);
		WebElement quickView = driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']"));
		quickView.click();
		//Print the cost and the discount percentage
		WebElement Price = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		String Pricetext = Price.getText();
		System.out.println("Cost Of the Shoe "+Pricetext);
		
		WebElement discount = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		String discountText = discount.getText();
		System.out.println("Discount% Of the Shoe "+discountText);
		Thread.sleep(2000);
		
		//Take the snapshot of the shoes.
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("D://Testleaf//Selenium//src//Screenshot/testfile.png"));
		System.out.println("Screen shot Captured");
		 
//Close the current window		 
driver.close();
//Close the main window
driver.quit();
	}

}
