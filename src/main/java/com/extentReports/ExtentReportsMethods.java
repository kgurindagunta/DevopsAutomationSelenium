package com.extentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.constants.FrameworkConstants;

public class ExtentReportsMethods {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static String reportDir;
	
	public static String setDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		
		Date date = new Date();
		String Dynamicdate =sdf.format(date);
		return Dynamicdate;
	}
	
	private static String  dynamicDate = setDate();
	public static void setExtentReport() {
		 reportDir = System.getProperty("user.dir")
		        + "\\TestReports\\" + dynamicDate;

		File dir = new File(reportDir);
		if (!dir.exists()) {
		    dir.mkdirs();
		}

		ExtentSparkReporter spark =
		        new ExtentSparkReporter(reportDir + "\\index.html");
		
		
		spark = new ExtentSparkReporter(reportDir + "\\index.html");
		spark.config().setDocumentTitle("PracticeTest E2E");
		spark.config().setReportName("Selenium Framework E2E");
		spark.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Owner", "Kiran");
		extent.setSystemInfo("IDE", "Eclipse");
		extent.setSystemInfo("Fullname", "Kiran Gurindagunta");		
	}
	
	public static void flushReport() {
		extent.flush();
		ExtentManager.removeExtentTest();
	//	Desktop.getDesktop().browse(new File(FrameworkConstants.getExpentPath()).toURI());
		try {
			//Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"/extent-output "+dynamicDate).toURI());
			Desktop.getDesktop().browse(new File(reportDir + "\\index.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createExtentTest(String testname) {
		ExtentTest test =extent.createTest(testname);
		ExtentManager.setExtentTest(test);
	}
	
	public static void setAuthors(String arr[]) {

		for(int i=0;i<arr.length;i++) {
			ExtentManager.getExtentTest().assignAuthor(arr[i]);
		}

	}

	public static void setTestType(String arr[]) {

		for(int i=0;i<arr.length;i++) {
			ExtentManager.getExtentTest().assignCategory(arr[i]);
		}

	}
}
