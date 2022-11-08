package week6.day1;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestngSample {
		public  ChromeDriver	driver;
		@Test
		 public void loginPage() {
			  WebDriverManager.chromedriver().setup();
			 	driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://leaftaps.com/opentaps/control/main");
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				 driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				driver.findElement(By.className("decorativeSubmit")).click();
				
				driver.findElement(By.linkText("CRM/SFA")).click();
				
				String Title=driver.getTitle();
				System.out.println(Title);
			
			  
		       }  
	}

