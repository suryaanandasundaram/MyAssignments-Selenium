package com.leaftaps.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import utils.ReadExcelData;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods {
	
	public String excelFileName;
	public static String leadID;
	public static Properties prop;
	public FileInputStream fis;
	
   
	public RemoteWebDriver driver;	
	@Parameters({"url","browserName","language"})
	@BeforeMethod
	public void beforeTest(String URL, String browser,String language) throws IOException	
	{
		if(language.equals("english"))
		{
		fis =new FileInputStream("src/main/resources/english.properties");
		}
		else if(language.equals("french"))
		{
		fis =new FileInputStream("src/main/resources/french.properties");
		}
				
	   prop =new Properties();
		prop.load(fis);
		
			
		if(browser.equals("Chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.get(URL);
		
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
			driver.get(URL);
			
		}
		
		else
		{
			System.out.println("Please select Chrome or Edge Browser");
		}
		System.out.println("Driver from ProjectSpecificMethod "+driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	

	@AfterMethod
	public void afterTest()
	{
		driver.close();
	}
	
	@DataProvider(name="testData",indices=0)
	public String[][] sendData() throws IOException
	{
		String[][] data = ReadExcelData.getData(excelFileName);
		
		return data;
				
				
	}
	
}
