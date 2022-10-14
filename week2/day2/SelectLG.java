package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectLG {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("https://www.leafground.com/select.xhtml");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	//Which is your favorite UI Automation tool?
	WebElement toolName = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
	toolName.click();
	Select toolNames =new Select(toolName);
	toolNames.selectByVisibleText("Selenium");
	
	//Choose your preferred country.
	WebElement countryName = driver.findElement(By.xpath("//label[@id='j_idt87:country_label']"));
	countryName.click();
	
	WebElement country1 = driver.findElement(By.xpath("//li[@data-label='India']"));
	country1.click();
	
	
	//Confirm Cities belongs to Country is loaded
	Thread.sleep(3000);
	WebElement cityNames = driver.findElement(By.xpath("//label[@id='j_idt87:city_label']"));
	cityNames.click();
	
	WebElement city1 = driver.findElement(By.xpath("//li[@data-label='Chennai']"));
	city1.click();
	
	//Choose the Course
	Thread.sleep(3000);
	WebElement courseValues = driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']"));
	courseValues.click();
	WebElement courseAppium = driver.findElement(By.xpath("//li[text()='Appium']"));
	courseAppium.click();
	WebElement courseReactJs = driver.findElement(By.xpath("//li[text()='ReactJs']"));
	courseReactJs.click();
	
	courseValues.click();
	Thread.sleep(2000);
	WebElement courseSeleniumWebDriver = driver.findElement(By.xpath("//li[text()='Selenium WebDriver']"));
	courseSeleniumWebDriver.click();
	
	
	//Choose language randomly
	
	WebElement languages = driver.findElement(By.xpath("//label[@id='j_idt87:lang_label']"));
	languages.click();
	Thread.sleep(3000);
	WebElement languageTamil = driver.findElement(By.xpath("//li[text()='Tamil']"));
	languageTamil.click();
	
	//Select 'Two' irrespective of the language chosen
	Thread.sleep(3000);
	WebElement language1 = driver.findElement(By.xpath("//label[@id='j_idt87:value_label']"));
	language1.click();
	Thread.sleep(3000);
	WebElement two = driver.findElement(By.xpath("//ul[@id='j_idt87:value_items']/li[2]"));
	two.click();
	
}
}
