package Test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class SampleTest {
	
	@Test
	public void readDataFromXl() throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./testdata/Book1.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
	String	data=wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		System.out.println(data);
	}
	@Test
	public void readDataJson() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser par= new JSONParser();
		Object obj= par.parse(new FileReader("./testdata/appCommonData.JSON"));
		
		JSONObject jobj=(JSONObject)obj;
		
	String url	=(String) jobj.get("url");
		System.out.println("url is: "+ url);
	}
	@Test
	public void readDataFromProperty() throws IOException {
		
		FileInputStream fis= new FileInputStream("./testdata/commondata.properties");

		Properties prop= new Properties();
		
		prop.load(fis);
		
		
		
		System.out.println(prop.get("url"));
		
		
		
	}
	@Test
	public void readDataFromXML(XmlTest test) {
		
		String name= test.getParameter("name");
		
		System.out.println(name);
		
	}

}
