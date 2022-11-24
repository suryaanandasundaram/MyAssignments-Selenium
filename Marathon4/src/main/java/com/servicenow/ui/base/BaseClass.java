package com.servicenow.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import util.ReadExcelData;

public class BaseClass {
	
	public RemoteWebDriver driver;
	public String filename;
	public String sheet;
	public static Shadow shadow;
	public static String text;
	
	public FileInputStream fis;
	public Properties prop;
	
    @Parameters({"url","browser"})
	@BeforeMethod
	public void beforemethod(String url,String browser) throws IOException
	{
    	fis=new FileInputStream("src/main/resources/input.properties");
    	prop=new Properties();
    	prop.load(fis);
    	if(browser.equals("Chrome"))
    	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		
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
