package com.qa.utility;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{



	public ExtentHtmlReporter htmlReporter;
	public ExtentReports xReports;
	public ExtentTest xTest;



	// Loc configuration to capture the extent report (format, infor, etc..)
	public void onStart(ITestContext testContext) {

		String dateStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Automation-Report"+dateStamp+".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+repName);
		//ExtentHtmlReporter report=new ExtentHtmlReporter("./Reports/cleartrip.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);

		
		xReports = new ExtentReports();
		xReports.attachReporter(htmlReporter);
		xReports.setSystemInfo("hostName", "localhost");
		xReports.setSystemInfo("OS", "Windows");
		xReports.setSystemInfo("QA", "Vikkram");
		
		
	}

	// configuration / loc to execute after the results are captured
	public void onFinish(ITestContext testContext) {
		xReports.flush();

	}
	
	// method to read the test results of the methods annotated as @Test, when the test is passed and executed via testng.xml file

	// test should make an entry into the extent report, if it passed
	public void onTestSuccess(ITestResult tr) {
		xTest = xReports.createTest(tr.getName()); // make an entry to the extent report
		xTest.log(Status.PASS, "Test is passed");
		xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}


	// test should make an entry into the extent report, if it failed
	public void onTestFailure(ITestResult tr) {
		xTest = xReports.createTest(tr.getName()); // make an entry to the extent report
		xTest.log(Status.FAIL, "Test is failed");
		xTest.log(Status.FAIL, tr.getThrowable());
		xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String SSPath = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		
		File file = new File(SSPath);
		if(file.exists()) {
			try {
				xTest.fail("The screenshot for test failed is : " + xTest.addScreenCaptureFromPath(SSPath));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}


	// test should make an entry into the extent report, if it skipped
	public void onTestSkipped(ITestResult tr) {
		xTest = xReports.createTest(tr.getName()); // make an entry to the extent report
		xTest.log(Status.SKIP, "Test is skipped");
		xTest.log(Status.SKIP, tr.getThrowable());
		xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));


	}

}