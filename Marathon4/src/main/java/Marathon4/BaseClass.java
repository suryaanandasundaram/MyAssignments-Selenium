package Marathon4;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public RemoteWebDriver driver;
	public String filename;
	public String sheet;
	
    @Parameters({"url","browser"})
	@BeforeMethod
	public void beforemethod(String urlvalue,String browserValue)

	{
    	
    	System.out.println(urlvalue);
    	System.out.println(browserValue);
    	if(browserValue.equals("Chrome"))
    	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(urlvalue); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    	}
	}
    @AfterMethod
    public void afterMethod()
    {
    	driver.close();
    }
	
	@DataProvider(name="Testdata")
	public String[][] readData() throws IOException
	{  
		String data[][] =ReadExcelData.setData(filename, sheet);
		
		return data;
	}
}
