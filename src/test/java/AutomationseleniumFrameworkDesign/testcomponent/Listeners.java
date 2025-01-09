package AutomationseleniumFrameworkDesign.testcomponent;


import java.io.IOException;
   
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationseleniumframeworkdesign.resources.ExtentreportNG;





public class Listeners extends Basetest implements ITestListener{
     ExtentTest test;
	ExtentReports extent = ExtentreportNG.getExtentReportData();
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest> ();
	
	
	@Override
	public void onTestStart(ITestResult result) {
	
		 test = extent.createTest(result.getMethod().getMethodName(   ));
		extenttest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//test.log(Status.PASS, "Test is passed without issues");
		extenttest.get().log(Status.PASS, "Test is passed without issues");

	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		//test.fail(result.getThrowable());
		extenttest.get().fail(result.getThrowable());
		
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	

		String filepath = null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName( ));
		extenttest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName( ));
		
	}	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}
	  @Override
	 public void onFinish(ITestContext context) {
	        
	      extent.flush();
	    }
	
	
	

}
