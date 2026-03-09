package com.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {
	
	private static WebDriver  driver;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	public static void  initDriver() {
		
		String isHeadless = System.getProperty("headless", "no");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");   // REQUIRED
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--window-size=1920,1080");
		if(isHeadless.equals("yes")) {
		 driver = new ChromeDriver(options);	
		}
		else {
			driver = new ChromeDriver();	
		}
		
		driver.manage().window().maximize();
	}
	
	public static void quitDriver() {
		driver.quit();
	}

}
