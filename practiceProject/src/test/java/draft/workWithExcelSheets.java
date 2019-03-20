package draft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class workWithExcelSheets {
	
	String[][] storedCredentials;
	
  // Example for data Reading from Excel
  @Test(dataProvider="readExcelFile")
  public void runAgainstExcelData(String usernameFromExcel, String pwdFromExcel) throws InterruptedException {
	    WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/login/");
		driver.findElement(By.id("email")).sendKeys(usernameFromExcel);
		driver.findElement(By.id("pass")).sendKeys(pwdFromExcel);
		driver.findElement(By.id("loginbutton")).click();
		//Thread.sleep(2000l);
		System.out.println("Logged in with Username ="+usernameFromExcel+" and Password = "+pwdFromExcel);
		driver.quit();
	  
  }
  
  @DataProvider(name="readExcelFile")
  public Object[][] readDataFromExcel(){
	  File excelFile;
	  FileInputStream readableExcel;
	  
	  try {
		excelFile = new File("D:/472/SeleniumTraining/workspace_framework/practiceProject/testResources/testDataExcelFile.xls");
		readableExcel = new FileInputStream(excelFile);
		HSSFWorkbook workbook = new HSSFWorkbook(readableExcel);
		HSSFSheet sheet = workbook.getSheet("accountDetails");
		int numberOfrows = sheet.getPhysicalNumberOfRows();
		System.out.println("Number of rows in the sheet ="+numberOfrows);
		
		Row firstRow = sheet.getRow(0);
		
		// Size is rows X columns
		storedCredentials = new String[numberOfrows][firstRow.getLastCellNum()];
		 
		// Rows iteration (i - row index)
		for (int i = 0; i < numberOfrows; i++) {
			System.out.println("current row number is "+i);
			
			Row currentRow = sheet.getRow(i);
			
			//Columns iteration (j -column index)
			for (int j = 0; j < currentRow.getLastCellNum(); j++) {
				String currentValue = currentRow.getCell(j).getStringCellValue().toString();
					storedCredentials[i][j] = currentValue;
			}			
		}
		
		readableExcel.close();
		
	} catch (FileNotFoundException e) {
		System.out.println("File is Not available at given path");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("Readable data is NOT available in workbook");
		e.printStackTrace();
	}
	return storedCredentials;
  }
  
  
  
  
  
  
  
  
  
  
  //Example for writing data into Excel
  @Test
  public void writeToExcelSheet(){
	  File excelFile;
	  FileInputStream readableExcel;
	  int numberOfrows=0;
	  
	  String[] valuesToBeAddedToSheet = {"value1FromCode", "value2FromCode", "value3FromCode"};
	  
	  try {
		excelFile = new File("D:/472/SeleniumTraining/workspace_framework/practiceProject/testResources/testDataExcelFile.xls");
		readableExcel = new FileInputStream(excelFile);
		HSSFWorkbook workbook = new HSSFWorkbook(readableExcel);
		HSSFSheet sheet = workbook.getSheet("writeDataInThisSheet");
		numberOfrows = sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println("Number of rows in the sheet BEFORE writing data="+numberOfrows);
		
		for (int k = 0; k < valuesToBeAddedToSheet.length; k++) {
			Row newRow = sheet.createRow(numberOfrows+1);
			Cell newCell = newRow.createCell(0);
			newCell.setCellValue(valuesToBeAddedToSheet[k]);
			numberOfrows = numberOfrows+1;
		}
		
		System.out.println("Number of rows in the sheet AFTER writing data="+numberOfrows);
		
		FileOutputStream writableFile = new FileOutputStream(excelFile);
		workbook.write(writableFile);
		
		// Iterate through number of rows
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			System.out.println("current row number is "+i);
			Row currentRow = sheet.getRow(i);
		
			// Iterate through number of columns
			for (int j = 0; j < currentRow.getLastCellNum(); j++) {
				String currentValue = currentRow.getCell(j).getStringCellValue().toString();
				System.out.println("Value at row:"+i+ " and column:"+j+" is = "+currentValue);
			}			
		}
		
		readableExcel.close();
		writableFile.close();
		
		
		
	} catch (FileNotFoundException e) {
		System.out.println("File is Not available at given path");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("Readable data is NOT available in workbook");
		e.printStackTrace();
	}
  }
  
  
  
  
  
  

  @BeforeTest
	public void initializeDriver(){
		System.setProperty("webdriver.chrome.driver", "D:/472/SeleniumTraining/workspace_framework/practiceProject/lib/chromedriver.exe");
	}
}
