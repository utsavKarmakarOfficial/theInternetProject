package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import driver.DriverFactory;
import reports.ExtentManager;
import reports.ExtentTestManager;

public class TestListener implements ITestListener{
    
	private static ExtentReports reports = ExtentManager.getInstance();
	
	@Override
	public void onTestStart(ITestResult result) {
	    System.out.println("Listener triggered for: " + result.getMethod().getMethodName());
	    ExtentTest test = reports.createTest(result.getMethod().getMethodName());
	    ExtentTestManager.setTest(test);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTestManager.getTest().fail(result.getThrowable());
		
		 if (DriverFactory.getDriver() != null) {
		        try {
		            String base64 =
		              ((TakesScreenshot)DriverFactory.getDriver())
		                 .getScreenshotAs(OutputType.BASE64);

		            ExtentTestManager.getTest()
		                 .addScreenCaptureFromBase64String(base64);
		        } catch (Exception ignored) {}
		    }
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().pass("Test passed");
	}
	

	@Override
	public void onFinish(ITestContext context) {
	    reports.flush();
	}
}
