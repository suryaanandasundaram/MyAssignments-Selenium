package runner;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import util.ReadExcelData;

public class BaseClassIncident extends AbstractTestNGCucumberTests {

		
		public static RemoteWebDriver driver;
		
		public static Shadow shadow;
		public static String text;
		   
		@BeforeMethod
		public void beforemethod() throws IOException
		{
	    	
	    	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://dev138589.service-now.com/"); 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			
	    	
		}
	    @AfterMethod
	    public void afterMethod()
	    {
	    	driver.close();
	    }
		
		
	}

