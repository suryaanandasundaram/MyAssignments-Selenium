package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class InputLG {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.leafground.com/input.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		//Type your name
		WebElement elementName = driver.findElement(By.xpath("//input[@id='j_idt88:name']"));
		elementName.clear();
		elementName.sendKeys("Suryaprabha");
		
		//Append Country to this City.
		WebElement elementCity = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt91']"));
		String city = elementCity.getText();
		String country = "- India";
		String newValue = city.concat(country);
		elementCity.sendKeys(newValue);
		
		//Verify if text box is disabled
		WebElement elementEnabled = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt93']"));
		boolean enabled = elementEnabled.isEnabled();
		
		if(enabled)
			System.out.println("The Textbox is Enabled");
		else
			System.out.println("The Textbox is Disabled");
		
		//Clear the typed text.
		WebElement elementClearText = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt95']"));
		elementClearText.clear();
		
		
		//Retrieve the typed text.
		WebElement elementReterive = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt97']"));
		String string1 = elementReterive.getAttribute("value");
		System.out.println(string1);
		
		
		//Type email and Tab. Confirm control moved to next element.
		WebElement elementEmail = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt99']"));
		elementEmail.sendKeys("abc@gmail.com");
		elementEmail.sendKeys(Keys.TAB);
		
		
		//Type about yourself
		WebElement elementYourself = driver.findElement(By.xpath("//textarea[@id='j_idt88:j_idt101']"));
		elementYourself.sendKeys("I am a person who is positive about every aspect of life. There are many things I like to do, to see, and to experience. I like to read, I like to write; I like to think, I like to dream; I like to talk, I like to listen.");
		
		//Text Editor
		WebElement elementTextEditor = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
		elementTextEditor.sendKeys("When you have a dream, you've got to grab it and never let go.");
		elementTextEditor.sendKeys(Keys.CONTROL+"A");
		Thread.sleep(2000);
		WebElement elementBold = driver.findElement(By.xpath("//button[@class='ql-bold']"));
		elementBold.click();
		elementTextEditor.click();
		Thread.sleep(2000);
		
		
		
		//Just Press Enter and confirm error message*

		WebElement elementAge = driver.findElement(By.xpath("//input[@id='j_idt106:thisform:age']"));
		elementAge.sendKeys(Keys.ENTER);
		
		WebElement elementErrorMessage = driver.findElement(By.xpath("//span[@id='j_idt106:thisform:j_idt110_error-detail']"));
		boolean displayed = elementErrorMessage.isDisplayed(); 
		if(displayed)
			System.out.println("The Error message is displayed");
		else
			System.out.println("The Error message is not displayed");
		
		
		//Click and Confirm Label Position Changes

		WebElement elementLabelChange = driver.findElement(By.xpath("//input[@id='j_idt106:float-input']"));
		WebElement elementLabel = driver.findElement(By.xpath("//label[@id='j_idt106:j_idt113']"));
		Point location = elementLabel.getLocation();
		System.out.println(location);
		
		elementLabelChange.click();
		
		Point location1 = elementLabel.getLocation();
		System.out.println(location1);
		
		if(location!=location1)
			System.out.println("The Postion of Username Changed");
		else
		System.out.println("The Postion of Username not chnaged");
		
		//Type your name and choose the third option
		WebElement elementNameType = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		elementNameType.sendKeys("Suryaprabha");
		
		List<WebElement> elementsOptions = driver.findElements(By.xpath("//ul[@class='ui-autocomplete-items ui-autocomplete-list ui-widget-content ui-widget ui-corner-all ui-helper-reset']/li"));
		int count=1;
		for(WebElement e:elementsOptions)
			{
			if(count==3)
				{
				e.click();
				break;
				}
			count++;
			}
		
		
		//Type your DOB (mm/dd/yyyy) and confirm date chosen

		WebElement elementDOB = driver.findElement(By.xpath("//input[@id='j_idt106:j_idt116_input']"));
		elementDOB.sendKeys("2/5/1995");
		String dob = elementDOB.getAttribute("value");
		
		
		System.out.println(dob);
		
		if(dob.contains("2/5/1995"))
			System.out.println("The DOB Selected Correctly");
		else
			System.out.println("The DOB not selected Correctly");
	
	//Type number and spin to confirm value changed
		WebElement elementSpin = driver.findElement(By.xpath("//input[@name='j_idt106:j_idt118_input']"));
		elementSpin.sendKeys("100");
		
	   
		WebElement elementSpin1 = driver.findElement(By.xpath("//span[@class='ui-icon ui-c ui-icon-triangle-1-n']"));
		elementSpin1.click();
		String spinValue=elementSpin.getAttribute("aria-valuenow");
		
		if(spinValue.contains("101"))
			System.out.println("Spin is working");
		else
			System.out.println("Spin is not working");
		
		WebElement elementSlider = driver.findElement(By.xpath("//input[@id='j_idt106:slider']"));
	
		
		WebElement elementSlider0= driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')]"));
		Point location2 = elementSlider0.getLocation();
		elementSlider.sendKeys("75");
		Point location3 = elementSlider0.getLocation();
		
		System.out.println(location2);
		System.out.println(location3);
		
		if(location2!=location3)
			System.out.println("slider moved");
		else
		System.out.println("slider not moved");
		
		
		
		//Click and Confirm Keyboard appears
		WebElement elementKeyboard= driver.findElement(By.xpath("//input[@id='j_idt106:j_idt122']"));
		elementKeyboard.click();
		
		WebElement elementKeyboard1= driver.findElement(By.xpath("//div[@class='keypad-row']"));
		boolean displayed2 = elementKeyboard1.isDisplayed();
		
		//WebElement elementClose = driver.findElement(By.xpath("//button[@title='Close the keypad']"));
		//elementClose.click();
		
		
			
		if(displayed2)
			System.out.println("The KeyBoard is displayed");
		else
			System.out.println("The KeyBoard is not displayed");
		Thread.sleep(3000);
		
		
		//Custom Toolbar
		
		WebElement elementCustomToolBar = driver.findElement(By.xpath("//div[@id='j_idt106:j_idt124_editor']/div[1]"));
		elementCustomToolBar.sendKeys("Checking the Values");
		Thread.sleep(2000);
		elementCustomToolBar.sendKeys(Keys.CONTROL+"A");
		WebElement elementUnderline = driver.findElement(By.xpath("//div[@id='j_idt106:j_idt124']//button[@class='ql-underline']"));
		elementUnderline.click();
		Thread.sleep(2000);
		elementCustomToolBar.click();
	}
}
