package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.WebDriverManager;

import com.aventstack.extentreports.Status;

public class TestListener extends WebDriverManager implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()
				+ " test case is passed");
		String testcasename = result.getMethod().getMethodName();
		String screenshotpath = CaptureScreenshot.getscreenshot(testcasename);
		try {
			test.addScreenCaptureFromPath(screenshotpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case is failed");
		String testcasename = result.getMethod().getMethodName();
		String screenshotpath = CaptureScreenshot.getscreenshot(testcasename);
		try {
			test.addScreenCaptureFromPath(screenshotpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		extent = ReportManager.getReport();
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
