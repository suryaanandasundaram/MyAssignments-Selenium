package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	//Go to https://www.nykaa.com/
	driver.get("https://www.nykaa.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	Actions action =new Actions(driver);
	//Mouseover on Brands and Search L'Oreal Paris
	WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
	action.moveToElement(brands).perform();
	
	WebElement elementSearch = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
	Thread.sleep(3000);
	elementSearch.sendKeys("L'Oreal Paris");
	//Click L'Oreal Paris
	Thread.sleep(2000);
	WebElement element = driver.findElement(By.xpath("//div[@class='css-ov2o3v']/a"));
	element.click();
	//Check the title contains L'Oreal Paris(Hint-GetTitle)
	String actualTitle = driver.getTitle();
	String expectedTitle="Buy L'Oreal Paris products online at best price on Nykaa | Nykaa";
	
	if(actualTitle.equals(expectedTitle))
	{
		System.out.println("The title is verified");
		System.out.println(actualTitle);
	}
	
	//Click sort By and select customer top rated
	WebElement sortBy = driver.findElement(By.xpath("//span[@class='sort-name']"));
	sortBy.click();
	
	WebElement customerTopRated = driver.findElement(By.xpath("//span[text()='customer top rated']/parent::div/following-sibling::div"));
	customerTopRated.click();
	Thread.sleep(2000);
	
	//Click Category and click Hair->Click haircare->Shampoo
	WebElement category = driver.findElement(By.xpath("//div[@class='filter-open css-1kwl9pj']"));
	category.click();
	
	WebElement categoryOption = driver.findElement(By.xpath("//span[@class='filter-name '][1]"));
	categoryOption.click();
	
	Thread.sleep(2000);
	WebElement hairCare = driver.findElement(By.xpath("//span[@class='filter-name '][1]"));
	hairCare.click();
	
	WebElement shampoo = driver.findElement(By.xpath("(//label[@class='control control-checkbox']/div[2])[1]"));
	shampoo.click();
	//Click->Concern->Color Protection
	Thread.sleep(2000);
	WebElement concern = driver.findElement(By.xpath("//span[text()='Concern']"));
	concern.click();
	
	WebElement colorProtection = driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']/div[2]"));
	colorProtection.click();
	//check whether the Filter is applied with Shampoo
	WebElement filterValue = driver.findElement(By.xpath("//span[@class='filter-value']"));
	String text = filterValue.getText();
	
	if(text=="Shampoo")
	{
		System.out.println("Fliter applied with Shampoo");
	}
	
	//String parentWindow = driver.getWindowHandle();
	//Click on L'Oreal Paris Colour Protect Shampoo
	WebElement product = driver.findElement(By.xpath("//div[@class='css-d5z3ro']/a"));
	product.click();
	
	Set<String> windowHandles = driver.getWindowHandles();
	
	List<String> windowHandleslist = new ArrayList<String>(windowHandles);
	// GO to the new window and select size as 175ml
	driver.switchTo().window(windowHandleslist.get(1));
	
 WebElement size = driver.findElement(By.xpath("//select[@title='SIZE']"));
 Select s=new Select(size);
 s.selectByVisibleText("175ml");
 // Print the MRP of the product
 WebElement MRP = driver.findElement(By.xpath("(//div[@class='css-1d0jf8e']/span[2])[1]"));
	String text2 = MRP.getText();
	System.out.println("MRP of the Product "+text2);
	//Click on ADD to BAG
	WebElement addToTheBag = driver.findElement(By.xpath("//span[@class='btn-text']"));
	addToTheBag.click();
	//Go to Shopping Bag 
	WebElement shoppingBag = driver.findElement(By.xpath("//button[@class='css-g4vs13']"));
	shoppingBag.click();
	Thread.sleep(2000);
	//Print the Grand Total amount
	driver.switchTo().frame(0);

	WebElement grandTotal = driver.findElement(By.xpath("//span[contains(@class,'css-n8gwxi e171rb9k3')]"));
	String text3 = grandTotal.getText();
	
	System.out.println("The Grand Total "+text3);
	//Click Proceed
	WebElement proceed = driver.findElement(By.xpath("//div[@class='css-15vhhhd e25lf6d4']"));
	proceed.click();
	
	driver.switchTo().defaultContent();
	//Click on Continue as Guest
	WebElement continueAsGuest = driver.findElement(By.xpath("//button[@class='btn full big']"));
	continueAsGuest.click();
	
	WebElement total = driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']//span"));
	String text4 = total.getText();
	
	System.out.println(text4);
	//Check if this grand total is the same in step 14
	if(text3.contains(text4))
	{
		System.out.println("Grand Total is same");
	}
	//Close all windows
	driver.close();
	
	
	
	
	
}
}
