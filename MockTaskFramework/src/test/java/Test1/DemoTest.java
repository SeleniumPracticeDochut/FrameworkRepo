package Test1;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mock.darshan.listenerutility.Baseclass;

public class DemoTest {
	
	
	
	@Test(invocationCount = 5, threadPoolSize = 5)
	public void demo1() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(2000);
		
		Assert.fail();
		
	}
@Test	(invocationCount = 5, threadPoolSize = 5)
public void demo2() throws InterruptedException {
	WebDriver driver= new ChromeDriver();

		driver.get("https://www.instagram.com/");
		
		Thread.sleep(2000);
		
		Assert.fail();
		
	}



}
