package com.utils;


import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import com.drivers.DriverSetup;

public class ScreenshotUtility {
	
	
	public static String captureScreenshot() {
		TakesScreenshot screen = (TakesScreenshot)DriverSetup.getDriver();
		return screen.getScreenshotAs(OutputType.BASE64);
	}

}
