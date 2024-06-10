package cyient_Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cyient_Utils.ExtentReporter;
import cyient_Utils.Utilities;

public class MyListeners implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;
	
	@Override
	public void onStart(ITestContext context) {
		
		extentReport = ExtentReporter.generateExtentReport();
		
	}

	
	@Override
	public void onTestStart(ITestResult result) {
		
        testName = result.getName();
        extentTest = extentReport.createTest(testName);
        extentTest.log(Status.INFO, testName+"started executing");
        
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
		
//		String testName = result.getName();
		extentTest.log(Status.PASS, testName+"got successfully executed");
		
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		
//		String testName = result.getName();
		
		WebDriver driver = null;
		
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
			
			//That screenshot code is moved to utility
//		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
//		
//		try {
//			org.openqa.selenium.io.FileHandler.copy(srcScreenshot,new File(destinationScreenshotPath));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	
		String destinationScreenshotPath = Utilities.captureScreenshot(driver, testName);
		
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName+"got failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
//		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+"got skipped");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();

		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
