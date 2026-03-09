package com.listeners;

import java.util.Arrays;



import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.extentReports.ExtentLogger;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentReportsMethods;

public class TestListener implements ITestListener, ISuiteListener{

	public  void onStart(ISuite suite) {
		ExtentReportsMethods.setExtentReport();
	}


	public void onFinish(ISuite suite) {
		ExtentReportsMethods.flushReport();

	}

	public void onTestStart(ITestResult result) {

		ExtentReportsMethods.createExtentTest(result.getMethod().getMethodName());

		//ExtentReportsMethods.setAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		//ExtentReportsMethods.setTestType(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());	
	}


	public void onTestSuccess(ITestResult result) {
		ExtentLogger.extentLogOnPass(result.getMethod().getMethodName());
		ExtentLogger.extentLogOnPassWithImage(result.getMethod().getMethodName());

	}


	public void onTestFailure(ITestResult result) {
		ExtentLogger.extentLogOnFailWithImage(result.getMethod().getMethodName());
		ExtentLogger.extentLogOnFail(Arrays.toString(result.getThrowable().getStackTrace()));
	}


	public void onTestSkipped(ITestResult result) {

	}

//	public static void setAuthors(String arr[]) {
//
//		for(int i=0;i<arr.length;i++) {
//			ExtentManager.getExtentTest().assignAuthor(arr[i]);
//		}
//
//	}
//
//	public static void setTestType(String arr[]) {
//
//		for(int i=0;i<arr.length;i++) {
//			ExtentManager.getExtentTest().assignCategory(arr[i]);
//		}
//
//	}


}
