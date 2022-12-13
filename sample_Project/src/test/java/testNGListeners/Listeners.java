package testNGListeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.hero.testkuapp.sample_Project.ConfigFile;

import reportsConfig.ExtentReportConfig;

public class Listeners extends ConfigFile implements ITestListener {
	
	ExtentReports extentReporter = ExtentReportConfig.getReportObjects();
	ExtentTest test;
	ThreadLocal<ExtentTest> extenTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extentReporter.createTest(result.getMethod().getMethodName());
		extenTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenTest.get().log(Status.PASS, "Test is pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
		} catch (Exception e) {
			
		}
		String testMethodName = result.getMethod().getMethodName();
		try {
			extenTest.get().addScreenCaptureFromPath(testMethodName, result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		extentReporter.flush();
		
	}
	
	

}
