package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL https://www.chittorgarh.com/
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		Click on stock market
		WebElement stockmarket = driver.findElement(By.id("navbtn_stockmarket"));
		stockmarket.click();
//		 Click on NSE bulk Deals
		WebElement nseBulkDeals = driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']"));
		nseBulkDeals.click();
//		Get all the Security names
		List<WebElement> security = driver.findElements(
				By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr/td[3]"));
		int size = security.size();

		List<String> securityNames = new ArrayList<String>();

		for (int i = 1; i <= size; i++) {
			String text = driver.findElement(By
					.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr[" + i + "]/td[3]"))
					.getText();
			securityNames.add(text);

		}
		System.out.println("Security Names in the Table");
		System.out.println("*****************************************");
		for (String string : securityNames) {

			System.out.println(string);
		}

		int listSize = securityNames.size();
		Set<String> DuplicatesecurityNames = new LinkedHashSet<String>();
		
//		Ensure whether there are duplicate Security names
		Set<String> securityNamessset = new LinkedHashSet<String>();
		for (String string : securityNames) {
			boolean b = securityNamessset.add(string);
			if (!b) {
				DuplicatesecurityNames.add(string);
			}
		}
		System.out.println("*****************************************");
		System.out.println("Duplicate Security Names in the Table");
		System.out.println("*****************************************");

		for (String string : DuplicatesecurityNames) {

			System.out.println(string);
		}

		int setSize = securityNamessset.size();

		if (listSize == setSize) {
			System.out.println("No Duplicate Security Names");
		} 
	}

}
