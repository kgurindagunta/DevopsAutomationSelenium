package com.extentReports;

import com.aventstack.extentreports.MediaEntityBuilder;

import com.utils.ScreenshotUtility;

public class ExtentLogger {
	
	public static void extentLogOnPass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	
	public static void extentLogOnFail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	
	public static void extentLogOnSkip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void extentLogOnPassWithImage(String message) {
		ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.captureScreenshot()).build());
	}
	
	public static void extentLogOnFailWithImage(String message) {
		ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.captureScreenshot()).build());
	}
	
	
	public static void extentLogOnSkipWithImage(String message) {
		ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.captureScreenshot()).build());
	}

}
