package com.mock.darshan.listenerutility;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ISuiteListener,ITestListener  {
	
	ExtentReports report;
	ExtentTest test;
	
	String ctime= new Date().toString().replace(" ", "_").replace(":", "_");

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String tsname= result.getMethod().getMethodName();
		
		test= report.createTest(tsname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String tsname=result.getMethod().getMethodName();
		TakesScreenshot ts= (TakesScreenshot) Baseclass.sdriver;
		
		String failure= ts.getScreenshotAs(OutputType.BASE64);
		
		test.addScreenCaptureFromBase64String(failure,tsname+"_"+ctime);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
	

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
		ExtentSparkReporter spark= new ExtentSparkReporter("./testdata/advancereport"+ctime+".html");
		
		spark.config().setDocumentTitle("advance selenium");
		spark.config().setReportName("darshan ref");
		spark.config().setTheme(Theme.STANDARD);
		
		 report=  new ExtentReports();
		report.attachReporter(spark);
		
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
	}
	
	
	

}
