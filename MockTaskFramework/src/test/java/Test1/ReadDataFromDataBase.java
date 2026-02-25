package Test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ReadDataFromDataBase {
	
	@Test
	public void dataBaseTest() throws SQLException {
		
		Driver d= new Driver();
		
		DriverManager.registerDriver(d);
		
		Connection con= DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
		
		Statement st= con.createStatement();
		
		int resobj= st.executeUpdate("insert into project values('NH_PROJ_908','adminq','23/02/2026','adminp','done',5)");
		
		System.out.println(resobj);
	ResultSet resObja	=st.executeQuery("select * from project");
	
	while(resObja.next()) {
		
		System.out.println(resObja.getString(1)+"\t"+resObja.getString(2)+"\t"+resObja.getString(3)+"\t"+resObja.getString(4)+"\t"+ resObja.getString(5)+"\t"+resObja.getString(6));
		
	}
	
	con.close();

	}
	
	
	

}
