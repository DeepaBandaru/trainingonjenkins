package practiceTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	//WebDriver driver;
	// This test is for practicekjadhk
	@Test(description="This test is for practicing TestNG features", dataProvider="getData")
	public void test1(String currentSearchKeyword) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		WebElement  searchbox =driver.findElement(By.cssSelector("input.ac_input"));
		searchbox.sendKeys(currentSearchKeyword);
		Thread.sleep(2000l);
		driver.findElement(By.cssSelector("button[name='submit_search']")).click();
		//searchbox.sendKeys(Keys.ENTER);
		System.out.println("Test 1 excuted for "+currentSearchKeyword);
		driver.quit();
	}
	
	
	@DataProvider(name="getData", parallel=true)
	public Object[] sendData(){
		// Read data
		String[] allSearchKeywords = {"dress", "perfume", "pants"};
		
		// Send data
		return allSearchKeywords;
	}
	
	
	
/*	@Test(enabled=true, priority=2)
	public void test2(){
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.cssSelector("input.ac_input")).sendKeys("perfume");
		driver.findElement(By.cssSelector("input.ac_input")).sendKeys(Keys.ENTER);
		System.out.println("Test 2 excuted");	
	}
	
	@Test(priority=1)
	public void test3(){
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.cssSelector("input.ac_input")).sendKeys("pants");
		driver.findElement(By.cssSelector("input.ac_input")).sendKeys(Keys.ENTER);
		System.out.println("Test 3 excuted");
	}*/
	
	@Test()
	public void prereq1(){
		System.out.println("prereq - 1 excuted");
	}
	
	@Test()
	public void prereq2(){
		System.out.println("prereq - 2 excuted");
	}
	
	
	@BeforeTest
	public void initializeDriver(){
		System.setProperty("webdriver.chrome.driver", "D:/472/SeleniumTraining/workspace_framework/practiceProject/lib/chromedriver.exe");
		//driver = new ChromeDriver();
	}
	
	@AfterTest
	public void closeApplication(){
		//driver.close();
	}
}
