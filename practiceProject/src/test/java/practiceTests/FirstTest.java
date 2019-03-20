package practiceTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{

	@Test(priority=3)
	public void test1() {
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("dress");
		driver.findElement(By.cssSelector("input#search_query_top")).sendKeys(Keys.ENTER);
		System.out.println("test 1 executed");
	}

	@Test(priority=0)
	public static void test2() {
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php/");
		driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("fancy");
		driver.findElement(By.cssSelector("input#search_query_top")).sendKeys(Keys.ENTER);
		System.out.println("test 2 executed");
	}

		@Test(priority=2)
	public static void test3() {
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("perfume");
		driver.findElement(By.cssSelector("input#search_query_top")).sendKeys(Keys.ENTER);
		System.out.println("test 3 executed");
	}

	@Test(priority=1, dependsOnMethods={"d1", "d2"})
	public static void test4() {
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("skirt");
		driver.findElement(By.cssSelector("input#search_query_top")).sendKeys(Keys.ENTER);
		System.out.println("test 4 executed");
	}
	
	/*@DataProvider
	public String testData(){
		String[] data = {"data 1", "data 2", "data 3", "data 4"};
		
	}*/
	
	@Test
	public void d1(){
		System.out.println("d1 executed");
	}
	
	@Test
	public void d2(){
		System.out.println("d2 executed");
	}
}
