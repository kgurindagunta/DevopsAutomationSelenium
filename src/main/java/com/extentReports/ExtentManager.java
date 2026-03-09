package com.extentReports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	
	public static ThreadLocal<ExtentTest>extent = new ThreadLocal<ExtentTest>();
	
	public static ExtentTest getExtentTest() {
		return extent.get();
	}
	
	public static void setExtentTest(ExtentTest test) {
		
		extent.set(test);
		
	}
	
	public static void removeExtentTest() {
		extent.remove();
	}

}
