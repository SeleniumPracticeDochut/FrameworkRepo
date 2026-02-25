package com.mock.darshan.listenerutility;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Baseclass {
	public WebDriver driver;
	static WebDriver sdriver;
	@BeforeClass
	public void launchBrowser() {
		
		driver= new ChromeDriver();
		sdriver= driver;
	}
	
	
	@AfterClass
	
	public void closeBrowser() {
		
		driver.close();
	}
	
}
