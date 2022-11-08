package dataprovider.leaftaps;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelLeafTaps;

public class DPBaseClassLT {
	RemoteWebDriver driver;
	public String fileName;
	
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
	
	@DataProvider(name="testDataLT")
	public String[][] providedata() throws IOException
	{
		String[][] data = ReadExcelLeafTaps.readData(fileName);
		return data;
		
	}
	
	
	
	
}
