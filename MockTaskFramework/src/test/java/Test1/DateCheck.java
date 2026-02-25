package Test1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DateCheck {
	@Test
	public void DateStamp() {
		
		LocalDate today=LocalDate.now();
		System.out.println(today);
		
		LocalDate	futuredate	=today.plusDays(30);
		
		System.out.println(futuredate);
		
		LocalDateTime times= LocalDateTime.now();
		
		System.out.println(times);
		
		Date cdate= new Date();
		
		System.out.println(cdate);
		
		LocalDate	futuredate1	=today.plusDays(50);
		
		System.out.println(futuredate1);
		System.out.println("hi");

		
	}

}
