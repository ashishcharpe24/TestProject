package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PreReq {


	public static WebDriver driver;

	// test for git
//	public String Readpropertyfile(String value) throws IOException
//	{
//		FileInputStream file = new FileInputStream("C:\\Users\\acharpe\\eclipse-workspace\\AdmissionDwight\\config.properties");
//		Properties prop = new Properties();
//		prop.load(file);
//		
//		return prop.getProperty(value);
//		
//	}
	
	
	public void Browserselection() throws IOException
	{
		String browserName = "chrome";
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions sslerr = new ChromeOptions();
			sslerr.setAcceptInsecureCerts(true);
			sslerr.addArguments("--disable-web-security");
			sslerr.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(sslerr);
			
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions sslerr = new EdgeOptions();
			sslerr.setAcceptInsecureCerts(true);
			driver = new EdgeDriver(sslerr);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public String readExcelFile(int row , int col) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\acharpe\\Desktop\\StudentListForDwilight.xlsx");
		Sheet data = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = data.getRow(row).getCell(col).getStringCellValue();
		return value;
	}
}
