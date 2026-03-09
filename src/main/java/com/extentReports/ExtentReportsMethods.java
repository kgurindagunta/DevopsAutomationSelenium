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

public class ExtentReportsMethods {

    public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static String reportDir;

    private static String setDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return sdf.format(new Date());
    }

    private static final String dynamicDate = setDate();

    public static void setExtentReport() {

        reportDir = System.getProperty("user.dir")
                + File.separator + "TestReports"
                + File.separator + dynamicDate;

        File dir = new File(reportDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        spark = new ExtentSparkReporter(
                reportDir + File.separator + "index.html"
        );

        spark.config().setDocumentTitle("PracticeTest E2E");
        spark.config().setReportName("Selenium Framework E2E");
        spark.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Owner", "Kiran");
        extent.setSystemInfo("IDE", "Eclipse");
        extent.setSystemInfo("Fullname", "Kiran Gurindagunta");
    }

    public static void flushReport() {

        if (extent != null) {
            extent.flush();
        }

        ExtentManager.removeExtentTest();

        // Open report only on Windows local machine
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            try {
                Desktop.getDesktop().browse(
                        new File(reportDir + File.separator + "index.html").toURI()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createExtentTest(String testname) {
        ExtentTest test = extent.createTest(testname);
        ExtentManager.setExtentTest(test);
    }

    public static void setAuthors(String[] arr) {
        for (String author : arr) {
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }

    public static void setTestType(String[] arr) {
        for (String category : arr) {
            ExtentManager.getExtentTest().assignCategory(category);
        }
    }
}