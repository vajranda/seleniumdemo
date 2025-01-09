package automationseleniumframeworkdesign.resources;

import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentreportNG {
	
	@BeforeTest
	public static ExtentReports getExtentReportData() {
		
		String file = System.getProperty("user.dir")+"//reports//index.html";
		
		ExtentSparkReporter reporter = new  ExtentSparkReporter(file);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web automation testing");
		reporter.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Tester", "Vajranda Nayak");
       return extent;
		
	}
	
	

}
