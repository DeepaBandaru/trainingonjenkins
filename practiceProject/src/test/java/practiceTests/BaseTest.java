package practiceTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	static WebDriver driver;
	
	
	@BeforeTest
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "D:/472/SeleniumTraining/workspace_framework/practiceProject/lib/chromedriver.exe");
	}
	
	@AfterTest
	public static void quit() {
		driver.close();
	}	
}
