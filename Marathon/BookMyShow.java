package Marathon;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BookMyShow {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
       //Launch Firefox / Chrome
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		
		
		
		//Load https://www.redbus.in/
				driver.get("https://in.bookmyshow.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
		//Type the city as "Hyderabad" in Select City
				
				WebElement city = driver.findElement(By.xpath("//div[@class='sc-bhlBdH kTGHzu']/span[text()='Hyderabad']"));
				city.click();
				
		//Confirm the URL has got loaded with Hyderabad
				Thread.sleep(3000);
				String currentUrl = driver.getCurrentUrl();
				
				if(currentUrl.contains("Hyderabad"))
				{
					System.out.println("Url loaded with Hyderabad");
				}
				//Search for your favorite movie
				
				Actions action= new Actions(driver);
				Thread.sleep(3000);
				WebElement search = driver.findElement(By.xpath("//span[text()='Search for Movies, Events, Plays, Sports and Activities']"));		
                action.moveToElement(search).perform();
                action.click().perform();
                Thread.sleep(5000);
                WebElement name = driver.findElement(By.xpath("//input[@placeholder='Search for Movies, Events, Plays, Sports and Activities']"));
                name.sendKeys("Kantara");
				
				WebElement option = driver.findElement(By.xpath("(//div[@class='sc-kAdXeD fZtDlY'])[1]"));
				option.click();
				
				WebElement bookTicket = driver.findElement(By.xpath("(//span[text()='Book tickets'])[1]"));
				bookTicket.click();
				
				
				WebElement firstTheater = driver.findElement(By.xpath("//div[@class='__title'][1]/a"));
				String theaterName = firstTheater.getText();
				System.out.println(theaterName);
				
				WebElement info = driver.findElement(By.xpath("(//div[@class='__title'][1]/div[1]/div[1])[1]"));
				info.click();
				
				Thread.sleep(3000);
				
				List<WebElement> facility = driver.findElements(By.xpath("//div[@class='venue-facility-item']"));
				int size = facility.size();
			
				for(int i=1;i<=size;i++)
				{
					WebElement parking = driver.findElement(By.xpath("//div[@class='venue-facility-item']["+i+"]/div[2]"));
					String text = parking.getText();
					
					if(text.contains("Parking Facility"))
					System.out.println("Parking Facility Available");
					
				}
				
				WebElement closePopup = driver.findElement(By.xpath("//div[@class='cross-container']"));
				closePopup.click();
				
				
				WebElement firstAvailable = driver.findElement(By.xpath("//a[@class='showtime-pill'][1]"));
				firstAvailable.click();
				
				WebElement accept = driver.findElement(By.id("btnPopupAccept"));
				accept.click();
				
				Thread.sleep(2000);
				
				WebElement seat = driver.findElement(By.id("pop_1"));
				seat.click();
				
				WebElement selectSeats = driver.findElement(By.id("proceed-Qty"));
				selectSeats.click();
				
				WebElement firstAvailableSeat = driver.findElement(By.xpath("//a[@class='_available'][1]"));
				firstAvailableSeat.click();
				
				WebElement pay = driver.findElement(By.xpath("(//a[@id='btmcntbook']/span)[1]"));
				pay.click();
				
				Thread.sleep(2000);
				
				WebElement subTotal = driver.findElement(By.id("subTT"));
				String total = subTotal.getText();
				System.out.println("Total "+total);
				
				
				
				
				
				
	}
	
}
