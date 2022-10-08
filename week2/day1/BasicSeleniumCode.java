package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicSeleniumCode {

public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	driver.close();
	
	WebDriverManager.edgedriver().setup();
	EdgeDriver driver2=new EdgeDriver();
	driver2.get("http://leaftaps.com/opentaps/control/main");
	driver2.manage().window().maximize();
	driver2.close();
	
	
	
}
}
