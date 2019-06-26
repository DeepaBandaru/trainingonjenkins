package draft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterizationUsingXMLfilesExample {
	
	@Test()
	@Parameters({"username", "password"})
	public void test1(String givenUserName, String givenPassword) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/472/SeleniumTraining/workspace_framework/practiceProject/lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/login/");
		driver.findElement(By.id("email")).sendKeys(givenUserName);
		driver.findElement(By.id("pass")).sendKeys(givenPassword);
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000l);
		System.out.println("test 1 executed");
		//This a simple Example
		driver.quit();
	}
}
