package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxLG {
	public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/checkbox.xhtml");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	//Basic Checkbox
	WebElement elementCheckBox = driver.findElement(By.xpath("//div[@id='j_idt87:j_idt89']"));
	elementCheckBox.click();
	
	//Notification
	WebElement elementCheckBox1 = driver.findElement(By.xpath("//span[@class='ui-chkbox-label'][text()='Ajax']"));
	elementCheckBox1.click();
	WebElement notification = driver.findElement(By.xpath("//div[@role='alert']"));
	boolean displayed = notification.isDisplayed();
	if(displayed)
		System.out.println("Notification Displayed");
	
	
	//Choose your favorite language(s)
	WebElement elementLanguage1 = driver.findElement(By.xpath("//label[@for='j_idt87:basic:0']"));
	elementLanguage1.click();

	WebElement elementLanguage2 = driver.findElement(By.xpath("//label[@for='j_idt87:basic:1']"));
	elementLanguage2.click();
	
	WebElement elementLanguage3 = driver.findElement(By.xpath("//label[@for='j_idt87:basic:3']"));
	elementLanguage3.click();
	
	//Tri State Checkbox
	
	WebElement elementTriState = driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']/div[2]"));
	elementTriState.click();
	WebElement elementState1 = driver.findElement(By.xpath("//div[@role='alert']"));
	boolean b1 = elementState1.isDisplayed();
	String text = elementState1.getText();
	if(b1)
		System.out.println("State has been Changed "+text);
	
	
	//Toggle Switch
	WebElement toggleSwitch = driver.findElement(By.xpath("//div[@id='j_idt87:j_idt100']"));
	toggleSwitch.click();
	
	//Verify if check box is disabled
	WebElement element = driver.findElement(By.xpath("//div[@class='col-12']/div[@id='j_idt87:j_idt102']/div[1]/input"));
	boolean enabled = element.isEnabled();
	System.out.println(enabled);
	if(enabled)
		System.out.println("The Checkbox is Enabled");
	else
		System.out.println("The Checkbox is Disabled");
	
	//Select Multiple
	WebElement element2 = driver.findElement(By.xpath("//div[@id='j_idt87:multiple']/ul"));
	element2.click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//ul[@class='ui-selectcheckboxmenu-items ui-selectcheckboxmenu-list ui-widget-content ui-widget ui-corner-all ui-helper-reset']/li[1]/div[1]")).click();
	driver.findElement(By.xpath("//ul[@class='ui-selectcheckboxmenu-items ui-selectcheckboxmenu-list ui-widget-content ui-widget ui-corner-all ui-helper-reset']/li[4]/div[1]")).click();
	driver.findElement(By.xpath("//ul[@class='ui-selectcheckboxmenu-items ui-selectcheckboxmenu-list ui-widget-content ui-widget ui-corner-all ui-helper-reset']/li[7]/div[1]")).click();
	element2.click();
}
}