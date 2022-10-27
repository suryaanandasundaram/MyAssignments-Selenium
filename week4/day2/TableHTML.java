package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TableHTML {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> table1Rows = driver.findElements(By.xpath("//div[@class='render']/table[1]//tr"));
		int rowSize1 = table1Rows.size();
		System.out.println("No of Rows in Table1 "+rowSize1);
		
		
		List<WebElement> table1Cols = driver.findElements(By.xpath("//div[@class='render']/table[1]//tr//td"));
		int colSize1 = table1Cols.size();
		System.out.println("No of Cols in Table1 "+colSize1);
		
		List<WebElement> table2Rows = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
		int rowSize2 = table2Rows.size();
		System.out.println("No of Rows in Table2 "+rowSize2);
		
		List<WebElement> table2Columns = driver.findElements(By.xpath("//table[@class='attributes-list']//tr[2]/td"));
		int Colsize2 = table2Columns.size();
		System.out.println("No of Cols in Table2 "+Colsize2);
		
		
		
		
		
	}

}
