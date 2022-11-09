package marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelSalesforce;

public class SalesforceBaseClass {
	
	public RemoteWebDriver driver;
	public String fileName;
	
	
	
	@Parameters({"url","browserName","userNameValue","passWord"})
	@BeforeMethod
	public void beforeMethod(String url,String browserName,String userNameValue,String passWord )
	{
		if(browserName.equals("Chrome"))
		{
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(ch);		
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys(userNameValue);
		driver.findElement(By.id("password")).sendKeys(passWord);
		driver.findElement(By.id("Login")).click();
		
		}
		else if(browserName.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions ed = new EdgeOptions();
			ed.addArguments("--disable-notifications");
			
			driver = new EdgeDriver(ed);	
			driver.get(url);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.findElement(By.id("username")).sendKeys(userNameValue);
			driver.findElement(By.id("password")).sendKeys(passWord);
			driver.findElement(By.id("Login")).click();
			
		}
		
		else
		{
			System.out.println("Please select Chrome or Edge Browser");
		}
		
		
	}
	
	@AfterMethod
	public void afterMethod() 
	{
		driver.close();
	}
	
	@DataProvider(name="SalesforceTestdata")
	public String[][] sendData() throws IOException
	{
		String data[][]=ReadExcelSalesforce.readExceldata(fileName);
		return data;
	}
	
	
		
	}
	

	

