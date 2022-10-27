package week4.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DragLG {
public static void main(String[] args) throws InterruptedException{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();

	driver.get("https://www.leafground.com/drag.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Actions action =new Actions(driver);
	
	//Draggable
	WebElement draggable = driver.findElement(By.xpath("//div[contains(@class,'ui-panel-titlebar ui-widget-header ui-helper-clearfix ui-corner-all')]"));
	Point location = draggable.getLocation();
	System.out.println(location);
	action.dragAndDropBy(draggable, 140, 182).perform();
	
	//Droppable
	WebElement source = driver.findElement(By.xpath("//div[@id='form:drag_content']/p"));
	WebElement target = driver.findElement(By.xpath("//div[@id='form:drop_content']/p"));	
	action.dragAndDrop(source, target).perform();
	
	//Draggable Columns
WebElement col3 = driver.findElement(By.xpath("(//div[@class='ui-datatable-tablewrapper']/table//th[3])[1]"));
WebElement col1 = driver.findElement(By.xpath("(//div[@class='ui-datatable-tablewrapper']/table//th[1])[1]"));
action.dragAndDrop(col3, col1).perform();


 
//Draggable Rows
WebElement row1 = driver.findElement(By.xpath("(//div[@class='ui-datatable-tablewrapper']/table/tbody/tr[1]/td[1])[2]"));
WebElement row3 = driver.findElement(By.xpath("(//div[@class='ui-datatable-tablewrapper']/table/tbody/tr[5]/td[2])[2]"));

action.clickAndHold(row1).moveToElement(row3).release(row3).release(row1).perform();

//action.moveToElement(row1).pause(Duration.ofSeconds(1)).clickAndHold(row1).pause(Duration.ofSeconds(5))
//.moveToElement(row3).pause(Duration.ofSeconds(4)).release(row3).click().build().perform();

//Resize Image
Thread.sleep(2000);
WebElement image = driver.findElement(By.xpath("//img[@id='form:logo']"));
action.dragAndDropBy(image,10,5).perform();

//Progress Bar

WebElement progressBar = driver.findElement(By.xpath("//span[@class='ui-button-text ui-c'][1]"));
progressBar.click();
Thread.sleep(5000);
WebElement percentage = driver.findElement(By.xpath("//div[@id='form:j_idt121']/div[2]"));
String text = percentage.getText();
System.out.println(text);

//Range Slider
WebElement range1 = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]"));
WebElement range2 = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][2]"));

action.dragAndDropBy(range1, 15, 5).perform();
action.dragAndDropBy(range2, 15, 5).perform();	

Thread.sleep(2000);
WebElement findElement = driver.findElement(By.xpath("//span[@id='form:displayRange']"));
String text2 = findElement.getText();
System.out.println(text2);
}
}
