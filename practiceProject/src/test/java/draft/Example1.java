package draft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example1 {
	
	//Example tests to run from xml file as a suite
	@Test()
	public void test1OfExample1() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		System.out.println("test1 Of Example1 is executed and test application launched");
		driver.quit();
	}
	
	@Test()
	public void test2OfExample1() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumhq.org/projects/");
		System.out.println("test2 Of Example1 is executed and SeleniumHQ application launched");
		driver.quit();
	}
	
	@BeforeTest
	public void initializeDriver(){
		System.setProperty("webdriver.chrome.driver","C:/Users/jayak/git/trainingonjenkins/practiceProject/lib/chromedriver.exe");
	}
}
