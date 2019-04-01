package draft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example2 {
	
	@Test()
	public void scenario1OfExample2() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/login/");
		System.out.println("scenario1 Of Example2 is executed and Facebook login page launched");
		driver.quit();
	}
	
	@Test()
	public void scenario2OfExample2() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/");
		System.out.println("scenario2 Of Example2 is executed and yahoo login page launched");
		driver.quit();
	}
	
	@BeforeTest
	public void initializeDriver(){
		System.setProperty("webdriver.chrome.driver", "/practiceProject/lib/chromedriver.exe");
	}
}
