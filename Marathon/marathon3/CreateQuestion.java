package marathon3;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class CreateQuestion extends SalesforceBaseClass {

	@BeforeTest
	public String setData()
	{
		fileName="tc001-SalesforceQuestion";
		return fileName;
	}
	
@Test(dataProvider="SalesforceTestdata")
	public void runCreateQuestion(String questionValue,String descValue) throws InterruptedException 
{
	
	Thread.sleep(2000);
	//Click on the App Launcher (dots)
	WebElement appLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
	appLauncher.click();
	Thread.sleep(2000);
	
	WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
	viewAll.click();
	
	WebElement search = driver.findElement(By.xpath("//input[@class='slds-input']"));
	search.sendKeys("Content");
	
	Thread.sleep(2000);
	
	WebElement content = driver.findElement(By.xpath("//mark[text()='Content']"));
	content.click();
	Thread.sleep(2000);
	
	WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
	driver.executeScript("arguments[0].click();", chatter);
	Thread.sleep(1000);
	
	String title = driver.getTitle();
	if(title.contains("Chatter Home | Salesforce"))
	{
		System.out.println("Title is verified");
	}
	
	WebElement questionTag = driver.findElement(By.xpath("//span[text()='Question']"));
	questionTag.click();
	Thread.sleep(2000);
	
	
	WebElement question = driver.findElement(By.xpath("//textarea[@role='textbox']"));
	question.sendKeys(questionValue);
	
	WebElement desc = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow']/p"));
	desc.sendKeys(descValue);
	
	WebElement ask = driver.findElement(By.xpath("//button[text()='Ask']"));
	ask.click();
	
	Thread.sleep(3000);
	
	WebElement confirm = driver.findElement(By.xpath("//div[@class='cuf-body cuf-questionTitle forceChatterFeedBodyQuestionWithoutAnswer'][1]/span"));
	String text = confirm.getText();
	
	if(text.contains(questionValue))
	{
		System.out.println("Question appered");
	}
		
}		
}
