package servicenow;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	RemoteWebDriver driver;
	@Parameters({"url","browserName"})
	@BeforeMethod
	public void beforeTest(String url,String browserName)
	{
		if(browserName.equals("Chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.get(url);
		
		}
		else if(browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
			driver.get(url);
			
		}
		
		else
		{
			System.out.println("Please select Chrome or Edge Browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	

	@AfterMethod
	public void afterTest()
	{
		driver.close();
	}
	
	
}
