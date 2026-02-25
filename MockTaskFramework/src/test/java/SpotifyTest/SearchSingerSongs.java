package SpotifyTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchSingerSongs {
	
	@Test(dataProvider = "singerNames")
	public void SearchSingerTest(String singer) throws InterruptedException, EncryptedDocumentException, IOException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://open.spotify.com/");
		
		driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys(singer);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a/div[contains(text(),'"+singer+"')]")).click();
		
		Thread.sleep(2000);
		
	List<WebElement>	songs=driver.findElements(By.xpath("//div[@class='contentSpacing']//div/a/div"));
	
	int count= songs.size();
	
	FileInputStream fis= new FileInputStream("./testdata/Book1.xlsx");
	
	Workbook wb= WorkbookFactory.create(fis);
	
	Sheet sh=wb.createSheet(singer);
	
	for(int i=0; i<count; i++) {
		
		String song=songs.get(i).getText();
		
		sh.createRow(i).createCell(0).setCellValue(song);
		
		
		
	}
	
	FileOutputStream fos= new FileOutputStream("./testdata/Book1.xlsx");
	wb.write(fos);
	wb.close();
	
	driver.close();
	
	}
	@DataProvider
	public Object[][] singerNames(){
		
		Object[][] obj= new Object[4][1];
		
		obj[0][0]= "Arjun Janya";
		obj[1][0]="Sudeep";
		obj[2][0]="Sanjith Hegde";
		obj[3][0]="VIJAY PRAKASH";
		
		
		
		
		return obj;
		
	}

}
